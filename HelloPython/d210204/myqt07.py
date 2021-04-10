import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

# UI파일 연결
# 단, UI파일은 Python 코드 파일과 같은 디렉토리에 위치해야한다.
form_class = uic.loadUiType("myqt07.ui")[0]


# 화면을 띄우는데 사용되는 Class 선언
class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)

        # 버튼에 기능을 할당하는 코드
        # self.pb1.clicked.connect(lambda: self.pbFunction(2))
        # self.pb2.clicked.connect(lambda: self.pbFunction(3))
        # self.pb3.clicked.connect(lambda: self.pbFunction(4))
        # self.pb4.clicked.connect(lambda: self.pbFunction(5))
        # self.pb5.clicked.connect(lambda: self.pbFunction(6))
        # self.pb6.clicked.connect(lambda: self.pbFunction(7))
        # self.pb7.clicked.connect(lambda: self.pbFunction(8))
        # self.pb8.clicked.connect(lambda: self.pbFunction(9))
        # self.pb1.clicked.connect(self.pbFunction)
        # self.pb2.clicked.connect(self.pbFunction)
        # self.pb3.clicked.connect(self.pbFunction)
        # self.pb4.clicked.connect(self.pbFunction)
        # self.pb5.clicked.connect(self.pbFunction)
        # self.pb6.clicked.connect(self.pbFunction)
        # self.pb7.clicked.connect(self.pbFunction)
        # self.pb8.clicked.connect(self.pbFunction)
        pb = [self.pb1, self.pb2, self.pb3, self.pb4, self.pb5, self.pb6, self.pb7, self.pb8]
        for i in pb:
            i.clicked.connect(self.pbFunction)

    def pbFunction(self):
        i = self.sender().text()
        int_i = int(i)
        result = "%d * %d = %d" % (int_i, 1, int_i * 1)
        for j in range(2, 10):
            result += "\n%d * %d = %d" % (int_i, j, int_i * j)
        self.te.setText(result)


if __name__ == "__main__":
    # QApplication : 프로그램을 실행시켜주는 클래스
    app = QApplication(sys.argv)

    # WindowClass의 인스턴스 생성
    myWindow = WindowClass()

    # 프로그램 화면을 보여주는 코드
    myWindow.show()

    # 프로그램을 이벤트루프로 진입시키는(프로그램을 작동시키는) 코드
    app.exec_()
