import cx_Oracle
conn=cx_Oracle.connect("sem/java@192.168.44.2:1521/xe")
cursor=conn.cursor() #커서 생성
sql="insert into pytable values(:1,:2,:3)"
data=('3','3','3')
cursor.execute(sql,data)
cursor.close()
conn.commit()
conn.close()




