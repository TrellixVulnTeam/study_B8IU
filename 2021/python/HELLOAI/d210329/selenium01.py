# Ch_selenium/example/tutorial1.py
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

driver = webdriver.Chrome('./chromedriver')  # 또는 chromedriver.exe
driver.implicitly_wait(15)  # 묵시적 대기, 활성화를 최대 15초가지 기다린다.

# 페이지 가져오기(이동)
driver.get('http://192.168.41.4:5000/')
driver.find_element_by_xpath('/html/body/a[2]').click()

id_box = driver.find_element_by_xpath('//*[@id="user_id"]')
id_box.send_keys('s00002')
pw_box = driver.find_element_by_xpath('//*[@id="pwd"]')
pw_box.send_keys('2')
driver.find_element_by_xpath('/html/body/form/input[3]').click()
driver.find_element_by_xpath('/html/body/a[2]').click()
trs = driver.find_elements_by_xpath('/html/body/table/tbody/tr/td[1]/table/tbody/tr')
for i, tr in enumerate(trs):
    if i != 0:
        print(tr.find_elements_by_tag_name('td')[2].text)
