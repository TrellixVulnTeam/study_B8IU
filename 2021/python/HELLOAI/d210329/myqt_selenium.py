# Ch_selenium/example/tutorial1.py
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

from PyQt5.QtWidgets import *
from PyQt5 import uic, QtGui, QtCore
import sys

# UI파일 연결
# 단, UI파일은 Python 코드 파일과 같은 디렉토리에 위치해야한다.
form_class = uic.loadUiType("myqt_selenium.ui")[0]


# 화면을 띄우는데 사용되는 Class 선언
class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)

    def myclick(self):
        trs = driver.find_elements_by_xpath('/html/body/table/tbody/tr/td[1]/table/tbody/tr')
        for i, tr in enumerate(trs):
            if i != 0:
                print(tr.find_elements_by_tag_name('td')[0].text, end='\t')
                print(tr.find_elements_by_tag_name('td')[1].text, end='\t')
                print(tr.find_elements_by_tag_name('td')[2].text, end='\t')
                print(tr.find_elements_by_tag_name('td')[3].text, end='\t')
                print(tr.find_elements_by_tag_name('td')[4].text, end='\t')
                print(tr.find_elements_by_tag_name('td')[5].text)


if __name__ == "__main__":
    driver = webdriver.Chrome('./chromedriver')  # 또는 chromedriver.exe
    driver.implicitly_wait(15)  # 묵시적 대기, 활성화를 최대 15초가지 기다린다.

    # 페이지 가져오기(이동)
    driver.get('http://192.168.41.4:5000/')
    driver.find_element_by_xpath('/html/body/a[2]').click()

    id_box = driver.find_element_by_xpath('//*[@id="user_id"]')
    id_box.send_keys('s00001')
    pw_box = driver.find_element_by_xpath('//*[@id="pwd"]')
    pw_box.send_keys('1')
    driver.find_element_by_xpath('/html/body/form/input[3]').click()
    driver.find_element_by_xpath('/html/body/a[3]').click()

    # QApplication : 프로그램을 실행시켜주는 클래스
    app = QApplication(sys.argv)

    # WindowClass의 인스턴스 생성
    myWindow = WindowClass()

    # 프로그램 화면을 보여주는 코드
    myWindow.show()

    # 프로그램을 이벤트루프로 진입시키는(프로그램을 작동시키는) 코드
    app.exec_()
