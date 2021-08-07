import cx_Oracle
import mybatis_mapper2sql

from d210308.mylog import MyLog


class MyStargetDao:
    def __init__(self):
        self.conn = cx_Oracle.connect('python/python@localhost:1521/xe')
        self.cur = self.conn.cursor()
        self.mapper = mybatis_mapper2sql.create_mapper(xml='mybatis_starget.xml')[0]
        self.mylog = MyLog.instance()

    def mySelect(self):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'select')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql)

        res = []
        for result in self.cur:
            res.append({'survey_id': result[0], 'st_mobile': result[1], 'complete_yn': result[2], 'in_date': result[3], 'in_user_id': result[4], 'up_date': result[5], 'up_user_id': result[6]})

        return res

    def myInsert(self, survey_id, st_mobile, complete_yn, in_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'insert')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (survey_id, st_mobile, complete_yn, in_user_id, in_user_id))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myUpdate(self, survey_id, st_mobile, complete_yn, up_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'update')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (complete_yn, up_user_id, survey_id, st_mobile))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myDelete(self, survey_id, st_mobile):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'delete')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (survey_id, st_mobile, ))
        self.conn.commit()
        result = self.cur.rowcount
        return result

    def __del__(self):
        self.cur.close()
        self.conn.close()
