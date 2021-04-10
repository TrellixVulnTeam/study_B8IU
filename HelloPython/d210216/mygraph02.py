import matplotlib.pyplot as plt
import cx_Oracle
import numpy as np


def getCprice(s_name):
    conn = cx_Oracle.connect('python/python@localhost:1521/xe')
    cur = conn.cursor()
    sql = "select * from (select * from stock where S_NAME = '%s' and ROWNUM <= 10 order by in_time desc) order by in_time" % s_name
    cur.execute(sql)
    return list(cur)


def show3D(index, s_name):
    result = getCprice(s_name)
    x = np.ones(10) * index
    y = range(len(result))
    z = list()
    for stock in result:
        z.append(stock[2])

    ax.plot(x, y, z)  # y축의 2에 해당하는 위치에 2차원 그래프를 출력합니다.


if __name__ == '__main__':
    fig = plt.figure()
    ax = fig.gca(projection='3d')  # 보여줄 방식을 3d로 설정합니다.
    ax.set_zlabel('Z')
    ax.set_ylabel('Y')
    ax.set_xlabel('X')
    s_names = "삼성전자", "LG"
    for index, s_name in enumerate(s_names):
        show3D(index, s_name)
    plt.show()

    # s_names = ["삼성전자", "LG", "SK"]
    # cnt = len(getCprice(s_names[0]))
    # y = range(cnt)
    # x = np.zeros(cnt)
    #
    # for i, s_name in enumerate(s_names):
    #     z = getCprice(s_name)
    #     ax.plot(x + i, y, z)
    # plt.show()
