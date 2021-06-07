import cx_Oracle

conn = cx_Oracle.connect('python/python@localhost:1521/xe')

cur = conn.cursor()

sql = "UPDATE SAMPLE SET col02 = :V_col02, col03 = :V_col03 WHERE col01 = :V_col01"
V_col01 = '9'
V_col02 = '8'
V_col03 = '7'
params = (V_col02, V_col03, V_col01)
cur.execute(sql, params)
print(cur.rowcount)

conn.commit()

cur.close()
conn.close()
