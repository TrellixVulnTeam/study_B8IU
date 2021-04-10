import cx_Oracle


class MyDao:
    def __init__(self):
        self.conn = cx_Oracle.connect('python/python@localhost:1521/xe')
        self.cur = self.conn.cursor()

    def mySelect(self):
        self.cur.execute("select col01, col02, col03 from sample")
        res = []
        for result in self.cur:
            res.append({'col01': result[0], 'col02': result[1], 'col03': result[2]})

        return res

    def myInsert(self, col01, col02, col03):
        sql = "INSERT INTO SAMPLE(col01, col02, col03) VALUES(:V_col01, :V_col02, :V_col03)"
        self.cur.execute(sql, (col01, col02, col03))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myUpdate(self, col01, col02, col03):
        sql = "UPDATE SAMPLE SET col02 = :V_col02, col03 = :V_col03 WHERE col01 = :V_col01"
        self.cur.execute(sql, (col02, col03, col01))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myDelete(self, col01, col02=0, col03=0):
        sql = "delete from sample where col01 = :V_col01"
        self.cur.execute(sql, (col01,))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def __del__(self):
        self.cur.close()
        self.conn.close()
        print("ㅇㅇ")


if __name__ == '__main__':
    dao = MyDao()
    print(dao.mySelect())
    print(dao.myInsert(10, 2, 3))
    print(dao.myUpdate(10, 4, 5))
    print(dao.myDelete(10))
