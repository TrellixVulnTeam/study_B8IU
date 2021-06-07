import sqlite3
 
#conn = sqlite3.connect("mydb.db")
# Autocommit 사용시:
conn = sqlite3.connect("mydb.db", isolation_level=None)
 
cur = conn.cursor()
sql = "insert into mytable (col01,col02,col03) values (?, ?, ?)"
cur.execute(sql, ('4', '4','4'))
# conn.commit() 
conn.close()