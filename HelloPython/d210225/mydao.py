import cx_Oracle


def detData():
    conn = cx_Oracle.connect('python/python@localhost:1521/xe')
    cur = conn.cursor()
    cur.execute("select col01, col02, col03 from sample")

    res = []
    for result in cur:
        res.append({'col01': result[0], 'col02': result[1], 'col03': result[2]})

    cur.close()
    conn.close()

    return res


def writehistroy(col01, col02, col03):
    conn = cx_Oracle.connect('python/python@localhost:1521/xe')
    cur = conn.cursor()

    sql = "INSERT INTO SAMPLE(col01, col02, col03) VALUES(:V_col01, :V_col02, :V_col03)"
    params = (col01, col02, col03)
    result = cur.execute(sql, params)

    conn.commit()
    cur.close()
    conn.close()

    return result


def mydelete(col01):
    conn = cx_Oracle.connect('python/python@localhost:1521/xe')
    cur = conn.cursor()

    sql = "delete from sample where col01 = :V_col01"
    cur.execute(sql, (col01,))
    result = cur.rowcount

    conn.commit()
    cur.close()
    conn.close()

    return result
