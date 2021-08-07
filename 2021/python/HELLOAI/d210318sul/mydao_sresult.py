import cx_Oracle
import mybatis_mapper2sql

from d210318sul.mylog import MyLog


class MyDaoSresult:

    def __init__(self):
        self.conn = cx_Oracle.connect('python/python@localhost:1521/xe')
        self.cur = self.conn.cursor()
        self.mapper = mybatis_mapper2sql.create_mapper(xml='mybatis_sresult.xml')[0]

    def mySelect(self, survey_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'select')
        MyLog().getLogger().debug(sql)

        self.cur.execute(sql, (survey_id,))
        res = []
        for result in self.cur:
            res.append({'survey_id': result[0], 's_seq': result[1], 'st_mobile': result[2], 'answer': result[3], 'in_date': result[4], 'in_user_id': result[5], 'up_date': result[6], 'up_user_id': result[7]})

        return res
    
    def mySelectChart(self, survey_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'selectChart')
        MyLog().getLogger().debug(sql)

        self.cur.execute(sql, (survey_id,))
        res = []
        for result in self.cur:
            res.append({'s_seq': result[0], 'question': result[1], 'a1': result[2], 'a2': result[3], 'a3': result[4], 'a4': result[5], 'a1_count': result[6], 'a2_count': result[7], 'a3_count': result[8], 'a4_count': result[9]})

        return res

    def myInsert(self, survey_id, s_seq, st_mobile, answer, in_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'insert')
        MyLog().getLogger().debug(sql)
        self.cur.execute(sql, (survey_id, s_seq, st_mobile, answer, in_user_id, in_user_id))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myMerge(self, addList):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'merge')
        MyLog().getLogger().debug(sql)
        for s in addList:
            self.cur.execute(sql, (s['survey_id'], s['s_seq'], s['mobile'], s['answer'], s['mobile'], s['survey_id'], s['s_seq'], s['mobile'], s['answer'], s['mobile'], s['mobile']))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myUpdate(self, survey_id, s_seq, st_mobile, answer, up_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'update')
        MyLog().getLogger().debug(sql)
        self.cur.execute(sql, (answer, up_user_id, survey_id, s_seq, st_mobile))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myDelete(self, survey_id, s_seq, st_mobile):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'delete')
        MyLog().getLogger().debug(sql)
        self.cur.execute(sql, (survey_id, s_seq, st_mobile,))
        self.conn.commit()
        result = self.cur.rowcount
        return result

    def __del__(self):
        self.cur.close()
        self.conn.close()
