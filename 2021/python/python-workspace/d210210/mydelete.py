import cx_Oracle

conn = cx_Oracle.connect('python/python@localhost:1521/xe')

cur = conn.cursor()

sql = "delete from sample where col01 = :col01"
V_col01 = '95'
params = (V_col01,)
cur.execute(sql, params)
print(cur.rowcount)

conn.commit()

cur.close()
conn.close()
