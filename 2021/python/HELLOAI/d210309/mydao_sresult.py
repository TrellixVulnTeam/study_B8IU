import cx_Oracle
import mybatis_mapper2sql

from d210308.mylog import MyLog


class MyDaoSresult:
    def __init__(self):
        self.conn = cx_Oracle.connect('python/python@localhost:1521/xe')
        self.cur = self.conn.cursor()
        self.mapper = mybatis_mapper2sql.create_mapper(xml='mybatis_sresult.xml')[0]
        self.mylog = MyLog.instance()

    def mySelect(self, survey_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'select')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (survey_id,))
        res = []
        for result in self.cur:
            res.append({'survey_id': result[0], 's_seq': result[1], 'st_mobile': result[2], 'answer': result[3], 'in_date': result[4], 'in_user_id': result[5], 'up_date': result[6], 'up_user_id': result[7]})

        return res

    def myInsert(self, survey_id, s_seq, st_mobile, answer, in_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'insert')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (survey_id, s_seq, st_mobile, answer, in_user_id, in_user_id))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myInsertAll(self, addList):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'insert')
        self.mylog.logger.debug(sql)
        for s in addList:
            self.cur.execute(sql, (s['survey_id'], s['s_seq'], s['mobile'], s['answer'], s['mobile'], s['mobile']))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myUpdate(self, survey_id, s_seq, st_mobile, answer, up_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'update')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (answer, up_user_id, survey_id, s_seq, st_mobile))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myDelete(self, survey_id, s_seq, st_mobile):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'delete')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (survey_id, s_seq, st_mobile, ))
        self.conn.commit()
        result = self.cur.rowcount
        return result

    def __del__(self):
        self.cur.close()
        self.conn.close()
