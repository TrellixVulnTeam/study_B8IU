import cx_Oracle
import mybatis_mapper2sql
from d210308.mylog import MyLog


class MySurveyDao:
    def __init__(self):
        self.conn = cx_Oracle.connect('python/python@localhost:1521/xe')
        self.cur = self.conn.cursor()
        self.mapper = mybatis_mapper2sql.create_mapper(xml='mybatis_survey.xml')[0]
        self.mylog = MyLog.instance()

    def mySelect(self):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'select')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql)
        res = []
        for result in self.cur:
            res.append({'s_id': result[0], 'title': result[1], 'content': result[2], 'interview_cnt': result[3], 'deadline': result[4], 'in_date': result[5], 'in_user_id': result[6], 'up_date': result[7], 'up_user_id': result[8]})

        return res

    def myInsert(self, s_id, title, content, interview_cnt, deadline, in_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'insert')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (s_id, title, content, interview_cnt, deadline, in_user_id, in_user_id))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myUpdate(self, s_id, title, content, interview_cnt, deadline, up_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'update')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (title, content, interview_cnt, deadline, up_user_id, s_id))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myDelete(self, s_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'delete')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (s_id,))
        self.conn.commit()
        result = self.cur.rowcount
        return result

    def __del__(self):
        self.cur.close()
        self.conn.close()


if __name__ == '__main__':
    dao = MySurveyDao()
