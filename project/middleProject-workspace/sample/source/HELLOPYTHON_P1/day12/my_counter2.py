import sys
import threading
import time
from PyQt5.QtWidgets import *
from PyQt5 import uic

form_class = uic.loadUiType("my_counter2.ui")[0]
       
class WindowClass(QMainWindow, form_class) :
    def __init__(self) :
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.on_click)
        
    def on_increase(self,s,e):
        for i in range(s,e):
            a = int(self.lbl.text())
            a += 1
            self.lbl.setText(str(a)) 
            time.sleep(1)
                 

    def on_click(self) :
        print("on_increase") 
        t1 = threading.Thread(target=self.on_increase, args=(1,10))
        t1.start()
        

if __name__ == "__main__" :
    app = QApplication(sys.argv) 
    myWindow = WindowClass() 
    myWindow.show()
    app.exec_()