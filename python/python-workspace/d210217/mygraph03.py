import matplotlib.pyplot as plt
import cx_Oracle
import numpy as np


def getCprice(s_name):
    sql = "select * from (select * from stock where S_NAME = '%s' and ROWNUM <= 10 order by in_time desc) order by in_time" % s_name
    cur.execute(sql)
    result = list()
    for stock in cur:
        result.append(stock[2])
    return result


def show3D(index, s_name):
    result = getCprice(s_name)
    x = np.ones(10) * index
    y = range(len(result))
    z = list()
    for stock in result:
        z.append(stock[2])

    ax.plot(x, y, z)  # y축의 2에 해당하는 위치에 2차원 그래프를 출력합니다.


def getSName():
    sql = "select distinct s_name from stock"
    cur.execute(sql)
    result = []
    for i in cur:
        result.append(i[0])
    result = np.array(list(cur))
    return result


if __name__ == '__main__':
    conn = cx_Oracle.connect('python/python@localhost:1521/xe')
    cur = conn.cursor()

    fig = plt.figure()
    ax = fig.gca(projection='3d')  # 보여줄 방식을 3d로 설정합니다.
    ax.set_zlabel('Z')
    ax.set_ylabel('Y')
    ax.set_xlabel('X')

    s_names = getSName()
    cnt = len(getCprice(s_names[0]))
    x = np.zeros(cnt)
    y = range(cnt)

    for i, s_name in enumerate(s_names):
        z = np.array(getCprice(s_name))
        z_init = z[0]
        if z_init:
            z = (z / z_init) * 100
            ax.plot(x + i, y, z)
    plt.show()

    cur.close()
    conn.close()

    # s_names = "삼성전자", "LG"
    # for index, s_name in enumerate(s_names):
    #     show3D(cur, index, s_name)
    # plt.show()

    # s_names = ["삼성전자", "LG", "SK"]
    # cnt = len(getCprice(s_names[0]))
    # x = np.zeros(cnt)
    # y = range(cnt)
    # print(s_names, x, y)
    #
    # for i, s_name in enumerate(s_names):
    #     z = getCprice(s_name)
    #     ax.plot(x + i, y, z)
    # plt.show()
