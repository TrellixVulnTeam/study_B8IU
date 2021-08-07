import cx_Oracle
import mybatis_mapper2sql
from d210330sul.mylog import MyLog


class MyDaoSnotice:
    def __init__(self):
        self.conn = cx_Oracle.connect('python/python@localhost:1521/xe')
        self.cs = self.conn.cursor()
        self.mapper = mybatis_mapper2sql.create_mapper(xml='mybatis_snotice.xml')[0]

    def myselect(self, user_id, search):
        # sql = mybatis_mapper2sql.get_child_statement(self.mapper, "select")
        # MyLog().getLogger().debug(sql)
        # rs = self.cs.execute(sql, (user_id, user_id, search))
        rs = [[0, 'Y', '제목', '내용', '파일 경로', '파일 이름' '조회 수', '작성일', '작성자', '수정일', '수정자', '작성자명'],]
        list = []
        for record in rs:
            list.append({'b_seq': int(record[0]),
                         'display_yn': record[1],
                         'title': record[2],
                         'content': record[3],
                         'attach_pass': record[4],
                         'attach_file': record[5],
                         'hit': record[6],
                         'in_date': record[7],
                         'in_user_id': record[8],
                         'up_date': record[9],
                         'up_user_id': record[10],
                         'in_user_name': record[11]})
        return list

    def mydetail(self, user_id, b_seq):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, "detail")
        MyLog().getLogger().debug(sql)
        print(user_id, b_seq)
        self.cs.execute(sql, (b_seq, user_id, user_id))
        record = self.cs.fetchone()
        try:
            return {'b_seq': record[0], 'display_yn': record[1], 'title': record[2], 'content': record[3], 'attach_pass': record[4], 'attach_file': record[5], 'hit': record[6], 'in_date': record[7], 'in_user_id': record[8], 'up_date': record[9], 'up_user_id': record[10], 'in_user_name': record[11]}
        except:
            return None

    def myinsert(self, display_yn, title, content, attach_pass, attach_file, in_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, "insert")
        MyLog().getLogger().debug(sql)
        self.cs.execute(sql, (display_yn, title, content, attach_pass, attach_file, in_user_id, in_user_id))
        self.conn.commit()
        cnt = self.cs.rowcount
        return cnt

    def myupdate(self, b_seq, display_yn, title, content, attach_pass, attach_file, up_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, "update")
        MyLog().getLogger().debug(sql)
        self.cs.execute(sql, (display_yn, title, content, attach_pass, attach_file, up_user_id, b_seq, up_user_id, up_user_id))
        self.conn.commit()
        cnt = self.cs.rowcount
        return cnt

    def myhit(self, b_seq, user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, "hit")
        MyLog().getLogger().debug(sql)
        self.cs.execute(sql, (b_seq, user_id, user_id))
        self.conn.commit()
        cnt = self.cs.rowcount
        return cnt

    def mydelete(self, user_id, b_seq):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, "delete")
        MyLog().getLogger().debug(sql)
        self.cs.execute(sql, (b_seq, user_id, user_id))
        self.conn.commit()
        cnt = self.cs.rowcount
        return cnt

    def __del__(self):
        self.cs.close()
        self.conn.close()


if __name__ == "__main__":
    dao = MyDaoSnotice()
    print(dao.myselect())
