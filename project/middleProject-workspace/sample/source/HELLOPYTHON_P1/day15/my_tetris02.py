import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

form_class = uic.loadUiType("tetris.ui")[0]

class WindowClass(QMainWindow, form_class) :
    def __init__(self) :
        super().__init__()
        self.setupUi(self)
        self.block2D = []
        self.stack2D = []
        self.scrin2D = []
        self.lbl2D = []
    
        self.initBlock2DStack2DScrin2D()
        
        self.scrin2D[0][0]=1 
        self.scrin2D[0][1]=1 
        self.scrin2D[1][1]=1 
        self.scrin2D[2][1]=1 
        
        for i in range(20):
            arr = []
            for j in range(10):
                pb = QPushButton('', self)
                pb.setGeometry(30*j,30*i,29,29)
                pb.setStyleSheet("background-color: #00ff00")
                arr.append(pb)
            self.lbl2D.append(arr) 
            
        self.myrender()    
        self.print2D(self.scrin2D)
        
        
        
    
    def initBlock2DStack2DScrin2D(self):
        for i in range(20):
            self.block2D.append([0,0,0,0,0, 0,0,0,0,0])
            self.stack2D.append([0,0,0,0,0, 0,0,0,0,0])
            self.scrin2D.append([0,0,0,0,0, 0,0,0,0,0])
        
    def print2D(self,arr):
        print("----------------------------------------------")
        for line in arr:
            print(line)
            
    def myrender(self):
        for i in range(20):
            for j in range(10):  
                if self.scrin2D[i][j] == 0:
                    self.lbl2D[i][j].setStyleSheet("background-color: #ffffff")
                    
                if self.scrin2D[i][j] == 1:
                    self.lbl2D[i][j].setStyleSheet("background-color: #ff0000")   
                if self.scrin2D[i][j] == 2:
                    self.lbl2D[i][j].setStyleSheet("background-color: #ef0000")
                if self.scrin2D[i][j] == 3:
                    self.lbl2D[i][j].setStyleSheet("background-color: #df0000")   
                if self.scrin2D[i][j] == 4:
                    self.lbl2D[i][j].setStyleSheet("background-color: #cf0000")   
                if self.scrin2D[i][j] == 5:
                    self.lbl2D[i][j].setStyleSheet("background-color: #bf0000")
                if self.scrin2D[i][j] == 6:
                    self.lbl2D[i][j].setStyleSheet("background-color: #af0000")                     
                if self.scrin2D[i][j] == 7:
                    self.lbl2D[i][j].setStyleSheet("background-color: #9f0000")
                    
                if self.scrin2D[i][j] == 11:
                    self.lbl2D[i][j].setStyleSheet("background-color: #00ff00")   
                if self.scrin2D[i][j] == 12:
                    self.lbl2D[i][j].setStyleSheet("background-color: #00ef00")
                if self.scrin2D[i][j] == 13:
                    self.lbl2D[i][j].setStyleSheet("background-color: #00df00")   
                if self.scrin2D[i][j] == 14:
                    self.lbl2D[i][j].setStyleSheet("background-color: #00cf00")   
                if self.scrin2D[i][j] == 15:
                    self.lbl2D[i][j].setStyleSheet("background-color: #00bf00")
                if self.scrin2D[i][j] == 16:
                    self.lbl2D[i][j].setStyleSheet("background-color: #00af00")                     
                if self.scrin2D[i][j] == 17:
                    self.lbl2D[i][j].setStyleSheet("background-color: #009f00")
                    
                    
                     

if __name__ == "__main__" :
    app = QApplication(sys.argv) 
    myWindow = WindowClass() 
    myWindow.show()
    app.exec_()