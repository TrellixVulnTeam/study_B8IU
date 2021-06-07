import time
import sys
import cx_Oracle
from PyQt5.QtWidgets import *
from PyQt5 import uic

from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.wait import WebDriverWait

form_class = uic.loadUiType("hello.ui")[0]

class WindowClass(QMainWindow, form_class) :
    def __init__(self) :
        super().__init__()
        self.setupUi(self)
        self.pushButton.clicked.connect(self.button1Function)
        
        options = Options()
        options.headless = False
        self.browser = webdriver.Chrome(executable_path="chromedriver.exe", options=options)
        #http://localhost/HelloWeb/hello.jsp
        #https://map.naver.com/v5/search/%EB%A7%9B%EC%A7%91/place/16069633?c=14184560.2696510,4345479.6935407,16,0,0,0,dh
        #https://place.map.kakao.com/12468740
        self.browser.get("https://place.map.kakao.com/12468740")
        


    def button1Function(self) :
        self.conn=cx_Oracle.connect("sem/java@192.168.44.2:1521/xe")
        self.cursor=self.conn.cursor() #커서 생성
        try:
            title = self.browser.find_elements_by_class_name("tit_location")[1].text;
            objs = self.browser.find_element_by_class_name("list_menu").find_elements_by_tag_name("li")
            for obj in objs:
                mene_name = obj.find_element_by_class_name("loss_word").text
                mene_price = obj.find_element_by_class_name("price_menu").text
                
                sql="insert into mymenu (title,menu_name,menu_price) values (:1,:2,:3)"
                data=(title,mene_name,mene_price)
                self.cursor.execute(sql,data)
                print(title,mene_name,mene_price)

        except:    # 예외가 발생했을 때 실행됨
            print('예외가 발생했습니다.')
        self.cursor.close()
        self.conn.commit()
        self.conn.close()     
            
    def __del__(self):
        pass

if __name__ == "__main__" :
    app = QApplication(sys.argv) 
    myWindow = WindowClass() 
    myWindow.show()
    app.exec_()
    
    
