import cx_Oracle
import mybatis_mapper2sql
from d210330sul.mylog import MyLog


class MyDaoSreply:
    def __init__(self):
        self.conn = cx_Oracle.connect('python/python@localhost:1521/xe')
        self.cs = self.conn.cursor()
        self.mapper = mybatis_mapper2sql.create_mapper(xml='mybatis_sreply.xml')[0]

    def myselect(self, b_seq):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, "select")
        MyLog().getLogger().debug(sql)
        rs = self.cs.execute(sql, (b_seq,))
        list = []
        for record in rs:
            list.append({'r_seq': record[0],
                         'b_seq': record[1],
                         'cmt': record[2],
                         'good': record[3],
                         'bad': record[4],
                         'in_date': record[5],
                         'in_user_id': record[6],
                         'up_date': record[7],
                         'up_user_id': record[8],
                         'in_user_name': record[9]})
        return list

    def myinsert(self, b_seq, cmt, user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, "insert")
        MyLog().getLogger().debug(sql)
        self.cs.execute(sql, (b_seq, cmt, user_id, user_id))
        self.conn.commit()
        cnt = self.cs.rowcount
        return cnt

    def myupdate(self, r_seq, cmt, user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, "update")
        MyLog().getLogger().debug(sql)
        self.cs.execute(sql, (cmt, user_id, r_seq))
        self.conn.commit()
        cnt = self.cs.rowcount
        return cnt

    def mydelete(self, user_id, r_seq):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, "delete")
        MyLog().getLogger().debug(sql)
        self.cs.execute(sql, (user_id, r_seq))
        self.conn.commit()
        cnt = self.cs.rowcount
        return cnt

    def mygood(self, r_seq):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, "good")
        MyLog().getLogger().debug(sql)
        self.cs.execute(sql, (r_seq,))
        self.conn.commit()
        cnt = self.cs.rowcount
        return cnt

    def mybad(self, r_seq):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, "bad")
        MyLog().getLogger().debug(sql)
        self.cs.execute(sql, (r_seq,))
        self.conn.commit()
        cnt = self.cs.rowcount
        return cnt

    def __del__(self):
        self.cs.close()
        self.conn.close()


if __name__ == "__main__":
    dao = MyDaoSreply()
