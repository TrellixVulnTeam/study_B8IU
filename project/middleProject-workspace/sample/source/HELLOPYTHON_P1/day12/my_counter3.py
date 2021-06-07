import sys
import threading
import time
from PyQt5.QtWidgets import *
from PyQt5 import uic

form_class = uic.loadUiType("my_counter3.ui")[0]
       
class WindowClass(QMainWindow, form_class) :
    def __init__(self) :
        self.index = 0
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.on_click)
        
    def on_shift(self,s,e):
        for i in range(s,e):
            if self.index%3 == 0: 
                self.lblr.setStyleSheet("background-color: #FF0000")
                self.lblg.setStyleSheet("background-color: #00FF00")
                self.lblb.setStyleSheet("background-color: #0000FF")
                self.lblr.setText("")
                self.lblg.setText("")
                self.lblb.setText("")

            if self.index%3 == 1: 
                self.lblr.setStyleSheet("background-color: #0000FF")
                self.lblg.setStyleSheet("background-color: #FF0000")
                self.lblb.setStyleSheet("background-color: #00FF00")
                self.lblr.setText("")
                self.lblg.setText("")
                self.lblb.setText("")

            if self.index%3 == 2: 
                self.lblr.setStyleSheet("background-color: #00FF00")
                self.lblg.setStyleSheet("background-color: #0000FF")
                self.lblb.setStyleSheet("background-color: #FF0000")
                self.lblr.setText("")
                self.lblg.setText("")
                self.lblb.setText("")

            time.sleep(1)
            self.index += 1

    def on_click(self) :
        print("on_click") 
        t1 = threading.Thread(target=self.on_shift, args=(1,10))
        t1.start()
        

if __name__ == "__main__" :
    app = QApplication(sys.argv) 
    myWindow = WindowClass() 
    myWindow.show()
    app.exec_()