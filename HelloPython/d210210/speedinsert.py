import cx_Oracle
import time

t1 = time.time()

conn = cx_Oracle.connect('python/python@localhost:1521/xe')
cur = conn.cursor()

sql = "INSERT INTO SAMPLE (col01, col02, col03) VALUES(:V_col01, :V_col02, :V_col03)"
V_col01 = '4'
V_col02 = '4'
V_col03 = '4'
params = (V_col01, V_col02, V_col03)
for _ in range(100000):
    cur.execute(sql, params)

conn.commit()
cur.close()
conn.close()
t2 = time.time()
print("경과 시간 : ", t2 - t1)
