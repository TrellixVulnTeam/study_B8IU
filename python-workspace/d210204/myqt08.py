import sys
import random
from PyQt5.QtWidgets import *
from PyQt5 import uic

# UI파일 연결
# 단, UI파일은 Python 코드 파일과 같은 디렉토리에 위치해야한다.
form_class = uic.loadUiType("myqt08.ui")[0]


# 화면을 띄우는데 사용되는 Class 선언
class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)

        # 버튼에 기능을 할당하는 코드
        self.pb.clicked.connect(self.pbFunction)

    def pbFunction(self):
        le1 = self.le1.text()
        if le1 != "홀" and le1 != "짝":
            self.le3.setText("올바른 입력이 아닙니다.")
            return
        le2 = random.choice(["홀", "짝"])
        self.le2.setText(le2)
        if le1 == le2:
            le3 = "승리"
        else:
            le3 = "패배"
        self.le3.setText(le3)


if __name__ == "__main__":
    # QApplication : 프로그램을 실행시켜주는 클래스
    app = QApplication(sys.argv)

    # WindowClass의 인스턴스 생성
    myWindow = WindowClass()

    # 프로그램 화면을 보여주는 코드
    myWindow.show()

    # 프로그램을 이벤트루프로 진입시키는(프로그램을 작동시키는) 코드
    app.exec_()
