import cx_Oracle
import mybatis_mapper2sql
from d210308.mylog import MyLog


class MySuserDao:
    def __init__(self):
        self.conn = cx_Oracle.connect('python/python@localhost:1521/xe')
        self.cur = self.conn.cursor()
        self.mapper = mybatis_mapper2sql.create_mapper(xml='mybatis_suser.xml')[0]
        self.mylog = MyLog.instance()

    def mySelect(self):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'select')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql)
        res = []
        for result in self.cur:
            res.append({'user_id': result[0], 'pwd': result[1], 'user_name': result[2], 'mobile': result[3], 'email': result[4], 'birth': result[5], 'in_date': result[6], 'in_user_id': result[7], 'up_date': result[8], 'up_user_id': result[9]})

        return res

    def myLogin(self, user_id, pwd):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'select_login')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (user_id, pwd))
        res = []
        for result in self.cur:
            res.append({'user_id': result[0], 'pwd': result[1], 'user_name': result[2], 'mobile': result[3], 'email': result[4], 'birth': result[5], 'in_date': result[6], 'in_user_id': result[7], 'up_date': result[8], 'up_user_id': result[9]})

        return res

    def myDupl(self, user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'select_dupl')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (user_id,))
        res = []
        for result in self.cur:
            res.append({'user_id': result[0], 'pwd': result[1], 'user_name': result[2], 'mobile': result[3], 'email': result[4], 'birth': result[5], 'in_date': result[6], 'in_user_id': result[7], 'up_date': result[8], 'up_user_id': result[9]})

        return res

    def myInsert(self, user_id, pwd, user_name, mobile, email, birth, in_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'insert')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (user_id, pwd, user_name, mobile, email, birth, in_user_id, in_user_id))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myUpdate(self, user_id, pwd, user_name, mobile, email, birth, up_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'update')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (pwd, user_name, mobile, email, birth, up_user_id, user_id))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myDelete(self, user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'delete')
        self.mylog.logger.debug(sql)
        self.cur.execute(sql, (user_id,))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def __del__(self):
        self.cur.close()
        self.conn.close()


if __name__ == '__main__':
    dao = MySuserDao()
