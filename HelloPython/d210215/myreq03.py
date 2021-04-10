import requests
from bs4 import BeautifulSoup

URL = 'http://localhost:7070/HelloWeb/tel_list.jsp'
response = requests.get(URL)

html = response.text
soup = BeautifulSoup(html, 'html.parser')

tds = soup.find_all('td')
for td in tds:
    print(td)
