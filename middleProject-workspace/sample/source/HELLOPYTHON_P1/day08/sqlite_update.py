import sqlite3
 
#conn = sqlite3.connect("mydb.db")
# Autocommit 사용시:
conn = sqlite3.connect("mydb.db", isolation_level=None)
 
cur = conn.cursor()
sql = "update mytable set col02=?, col03=? where col01=?"
cur.execute(sql, ('5', '5','4'))
# conn.commit() 
conn.close()