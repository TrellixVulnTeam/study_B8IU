import cx_Oracle
import mybatis_mapper2sql


class MyDao:
    def __init__(self):
        self.conn = cx_Oracle.connect('python/python@localhost:1521/xe')
        self.cur = self.conn.cursor()
        self.mapper = mybatis_mapper2sql.create_mapper(xml='mybatis_sample.xml')[0]

    def mySelect(self):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'select')
        self.cur.execute(sql)
        res = []
        for result in self.cur:
            res.append({'col01': result[0], 'col02': result[1], 'col03': result[2]})

        return res

    def myInsert(self, col01, col02, col03):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'insert')
        self.cur.execute(sql, (col01, col02, col03))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myUpdate(self, col01, col02, col03):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'update')
        self.cur.execute(sql, (col02, col03, col01))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myDelete(self, col01, col02=0, col03=0):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'delete')
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
    print(dao.mySelect())
    print(dao.myUpdate(10, 4, 5))
    print(dao.mySelect())
    print(dao.myDelete(10))
