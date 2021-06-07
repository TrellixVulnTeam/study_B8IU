import sqlite3

conn = sqlite3.connect("mydb.db")
cur = conn.cursor()
cur.execute("select col01,col02,col03 from mytable")
rows = cur.fetchall()
for row in rows:
    print(row)

conn.close()