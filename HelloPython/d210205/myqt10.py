import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic


# UI파일 연결
# 단, UI파일은 Python 코드 파일과 같은 디렉토리에 위치해야한다.
form_class = uic.loadUiType("myqt10.ui")[0]


# 화면을 띄우는데 사용되는 Class 선언
class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)

        # 버튼에 기능을 할당하는 코드
        pb = [self.pb1, self.pb2, self.pb3, self.pb4, self.pb5, self.pb6, self.pb7, self.pb8, self.pb9, self.pb0]
        for i in pb:
            i.clicked.connect(self.pbFunction)
        self.pb_call.clicked.connect(self.callFunction)

    def pbFunction(self):
        i = self.sender().text()
        le = self.le.text()
        str_i = str(i)
        if len(le) == 3 or len(le) == 8:
            self.le.setText(le + "-" + str_i)
        else:
            self.le.setText(le + str_i)

    def callFunction(self):
        QMessageBox.about(self, "Calling", "Calling " + self.le.text())
        # msg = QMessageBox()
        # msg.setText("Calling " + self.le.text())
        # msg.setStyleSheet("QLabel{min-width: 150px;}")
        # msg.setStandardButtons(QMessageBox.Close)
        # msg.exec_()


if __name__ == "__main__":
    # QApplication : 프로그램을 실행시켜주는 클래스
    app = QApplication(sys.argv)

    # WindowClass의 인스턴스 생성
    myWindow = WindowClass()

    # 프로그램 화면을 보여주는 코드
    myWindow.show()

    # 프로그램을 이벤트루프로 진입시키는(프로그램을 작동시키는) 코드
    app.exec_()
