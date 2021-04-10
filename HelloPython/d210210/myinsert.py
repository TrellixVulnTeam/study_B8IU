import cx_Oracle

conn = cx_Oracle.connect('python/python@localhost:1521/xe')

cur = conn.cursor()

sql = "INSERT INTO SAMPLE (col01, col02, col03) VALUES(:V_col01, :V_col02, :V_col03)"
V_col01 = '95'
V_col02 = '96'
V_col03 = '97'
params = (V_col01, V_col02, V_col03)
cur.execute(sql, params)
print(cur.rowcount)

conn.commit()
cur.close()
conn.close()
