import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic, QtGui

# UI파일 연결
# 단, UI파일은 Python 코드 파일과 같은 디렉토리에 위치해야한다.
form_class = uic.loadUiType("myomoc01.ui")[0]


# 화면을 띄우는데 사용되는 Class 선언
class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)

        # 버튼에 기능을 할당하는 코드
        self.pb.clicked.connect(self.pbFunction)

    def pbFunction(self):
        try:
            self.sender().mystate += 1
            if self.sender().mystate == 3:
                self.sender().mystate = 0
        except AttributeError:
            self.sender().mystate = 1
        rMyIcon = QtGui.QPixmap(str(self.sender().mystate) + ".png")
        self.sender().setIcon(QtGui.QIcon(rMyIcon))


if __name__ == "__main__":
    # QApplication : 프로그램을 실행시켜주는 클래스
    app = QApplication(sys.argv)

    # WindowClass의 인스턴스 생성
    myWindow = WindowClass()

    # 프로그램 화면을 보여주는 코드
    myWindow.show()

    # 프로그램을 이벤트루프로 진입시키는(프로그램을 작동시키는) 코드
    app.exec_()
