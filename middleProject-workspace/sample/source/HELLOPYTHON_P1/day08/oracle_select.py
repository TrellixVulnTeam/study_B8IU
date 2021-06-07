import cx_Oracle
conn=cx_Oracle.connect("sem/java@192.168.44.2:1521/xe")
cursor=conn.cursor() #커서 생성
sql="select col01,col02,col03 from pytable"
cursor.execute(sql)

for row in cursor:
    print(row[0],row[1],row[2])

cursor.close()
conn.close()


