import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

form_class = uic.loadUiType("increase.ui")[0]

class WindowClass(QMainWindow, form_class) :
    def __init__(self) :
        super().__init__()
        self.setupUi(self)
        self.pushButton.clicked.connect(self.button1Function)

    def button1Function(self) :
        a = self.label.text()
        b =  int(a)
        b += 1
        self.label.setText(str(b))
               
        

if __name__ == "__main__" :
    app = QApplication(sys.argv) 
    myWindow = WindowClass() 
    myWindow.show()
    app.exec_()