import requests
from bs4 import BeautifulSoup
import cx_Oracle
import time
import datetime

conn = cx_Oracle.connect('python/python@localhost:1521/xe')
cur = conn.cursor()
sql = "INSERT INTO STOCK(s_code, s_name, cprice, in_time) VALUES (:s_code, :s_name, :cprice, :in_time)"
url = "https://vip.mk.co.kr/newSt/rate/item_all.php"

for _ in range(10):
    print()
    print(datetime.datetime.now(), "데이터 요청")
    response = requests.get(url)
    response.encoding = 'euc-kr'
    html = response.text
    soup = BeautifulSoup(html, 'html.parser')
    sts = soup.select(".st2")

    # now = time.localtime()
    # in_time = now.tm_year, now.tm_mon, now.tm_mday, now.tm_hour, now.tm_min
    in_time = datetime.datetime.now().strftime("%Y%m%d.%H%M")
    print(datetime.datetime.now(), "데이터 수신 완료")
    print(datetime.datetime.now(), "DB 추가 시작")
    for st in sts:
        s_code = st.select_one('a')["title"]
        s_name = st.text
        cprice = int(st.parent.select('td')[1].text.replace(",", ""))
        params = (s_code, s_name, cprice, in_time)
        try:
            cur.execute(sql, params)
        except Exception as e:
            print(e)
    conn.commit()
    print(datetime.datetime.now(), "DB 추가 끝")
    try:
        time.sleep(60)
    except Exception as e:
        print(e)
        break

cur.close()
conn.close()
