import requests
from bs4 import BeautifulSoup

url = "https://vip.mk.co.kr/newSt/rate/item_all.php"
response = requests.get(url)
response.encoding = 'euc-kr'
html = response.text
soup = BeautifulSoup(html, 'html.parser')

sts = soup.select(".st2")

for st in sts:
    print(st.find('a')["title"], end="\t")
    # print(td[0].select_one('a').attrs["title"], end="\t")
    print(st.text, end="\t")
    print(st.parent.select('td')[1].text)
    print(st.find('a'), st.select_one('a'))
