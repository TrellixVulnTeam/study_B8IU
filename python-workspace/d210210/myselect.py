# def get_query(sql, ip='localhost', port='1521', sid='xe', id='python', passwd='python'):
#     import pandas as pd
#     import cx_Oracle
#     import os
#     os.putenv('NLS_LANG', 'KOREAN_KOREA.KO16MSWIN949')
#     txt = 'cx_Oracle.connect("' + id + '/' + passwd + '@' + ip + ':' + port + '/' + sid + '")'
#     con = eval(txt)
#     return pd.read_sql(sql, con=con)
#
#
# if __name__ == '__main__':import cx_Oracle
#
# conn = cx_Oracle.connect('python/python@localhost:1521/xe')
#
# cur = conn.cursor()
#
# cur.execute("select col01, col02, col03 from sample")
#
# result = list(cur)
# print(result)
#
# # for i in cur:
# #     print(i)
#
# cur.close()
# conn.close()
#     result = get_query("select * from sample")
#
#     print(result)

