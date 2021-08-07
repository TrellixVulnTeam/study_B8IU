import cx_Oracle
import mybatis_mapper2sql
from d210308.mylog import MyLog


class MySdetailDao:
    def __init__(self):
        self.conn = cx_Oracle.connect('python/python@localhost:1521/xe')
        self.cur = self.conn.cursor()
        self.mapper = mybatis_mapper2sql.create_mapper(xml='mybatis_sdetail.xml')[0]
        self.mylog = MyLog.instance()

    def mySelect(self):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'select')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql)
        res = []
        for result in self.cur:
            res.append({'survey_id': result[0], 's_seq': result[1], 'question': result[2], 'a1': result[3], 'a2': result[4], 'a3': result[5], 'a4': result[6], 'in_date': result[7], 'in_user_id': result[8], 'up_date': result[9], 'up_user_id': result[10]})

        return res

    def myInsert(self, survey_id, s_seq, question, a1, a2, a3, a4, in_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'insert')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (survey_id, s_seq, question, a1, a2, a3, a4, in_user_id, in_user_id))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myUpdate(self, survey_id, s_seq, question, a1, a2, a3, a4, up_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'update')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (question, a1, a2, a3, a4, up_user_id, survey_id, s_seq))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myDelete(self, survey_id, s_seq):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'delete')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (survey_id, s_seq))
        self.conn.commit()
        result = self.cur.rowcount
        return result

    def __del__(self):
        self.cur.close()
        self.conn.close()


if __name__ == '__main__':
    dao = MySdetailDao()
