import sys
import cx_Oracle

from PyQt5.QtWidgets import *
from PyQt5 import uic, QtGui, QtCore

# UI파일 연결
# 단, UI파일은 Python 코드 파일과 같은 디렉토리에 위치해야한다.
form_class = uic.loadUiType("myomoc02.ui")[0]


def getMax():
    conn = cx_Oracle.connect('python/python@localhost:1521/xe')
    cs = conn.cursor()
    sql = 'SELECT NVL(MAX(PAN) + 1, 1) FROM OMOK'
    cs.execute(sql)
    max_pan = cs.fetchone()[0]

    cs.close()
    conn.close()

    return max_pan


def writehistroy(pan, history, win):
    conn = cx_Oracle.connect('python/python@localhost:1521/xe')
    cs = conn.cursor()
    sql = "INSERT INTO OMOK(PAN, PSEQ, HISTORY, WIN) VALUES(:V_pan, :V_pseq, :V_history, :V_win)"
    rowcount = 0
    for i, h in enumerate(history):
        cs.execute(sql, (pan, i, h, win))
        rowcount += cs.rowcount
    print(rowcount, "개 행이 추가되었습니다.")
    cs.close()
    conn.commit()
    conn.close()


# 화면을 띄우는데 사용되는 Class 선언
class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)

        XY = 10
        self.X, self.Y = XY, XY  # 가로 및 세로 길이 지정 ( x 좌표의 범위, y 좌표의 범위 )

        self.array2D = [[0 for _ in range(self.X)] for _ in range(self.Y)]

        self.pb2d = list()
        for i in range(self.Y):
            line = list()
            for j in range(self.X):
                temp = QPushButton(self)
                temp.setGeometry(j * 40, i * 40, 40, 40)
                temp.setIcon(QtGui.QIcon("0.png"))
                temp.setIconSize(QtCore.QSize(40, 40))
                # temp.setToolTip(str(i) + "," + str(j))
                temp.clicked.connect(self.myclick)
                line.append(temp)
            self.pb2d.append(line)
        self.myrender()

        self.history = []

        self.flag_wb = True
        self.flag_ing = True
        self.pb.clicked.connect(self.myreset)

    def myrender(self):
        for i in range(len(self.array2D)):
            for j in range(len(self.array2D)):
                self.pb2d[i][j].setIcon(QtGui.QIcon(str(self.array2D[i][j]) + ".png"))

    def myclick(self):
        if not self.flag_ing:
            QMessageBox.about(self, "게임 종료", "reset 버튼을 눌러 게임을 다시 실행하세요.")
            return

        int_i, int_j = self.find_ij()

        # int_i, int_j = map(int, self.sender().toolTip().split(','))

        if self.array2D[int_i][int_j] != 0:
            QMessageBox.about(self, "알림", "이미 입력된 좌표입니다.")
            return

        if self.flag_wb:
            int_stone = 1
        else:
            int_stone = 2

        self.array2D[int_i][int_j] = int_stone
        self.myrender()
        self.flag_wb = not self.flag_wb

        str100 = ""
        for i in range(10):
            for j in range(10):
                str100 += str(self.array2D[i][j])
        self.history.append(str100)

        if self.calc(int_j, int_i, int_stone, self.up) + 1 + self.calc(int_j, int_i, int_stone, self.down) == 5 \
                or self.calc(int_j, int_i, int_stone, self.left) + 1 + self.calc(int_j, int_i, int_stone, self.right) == 5 \
                or self.calc(int_j, int_i, int_stone, self.upleft) + 1 + self.calc(int_j, int_i, int_stone, self.downright) == 5 \
                or self.calc(int_j, int_i, int_stone, self.downleft) + 1 + self.calc(int_j, int_i, int_stone, self.upright) == 5:
            self.flag_ing = False
            if int_stone == 1:
                QMessageBox.about(self, "흰색 승", "흰색 돌이 이겼습니다.")
            else:
                QMessageBox.about(self, "흑색 승", "흑색 돌이 이겼습니다.")
            max_pan = getMax()
            writehistroy(max_pan, self.history, int_stone)

    def calc(self, x, y, stone, define):
        count = 0
        while True:
            x, y = define(x, y)
            if x < 0 or y < 0 or x >= self.X or y >= self.Y or self.array2D[y][x] != stone:
                break
            count += 1
        return count

    def up(self, x, y):
        return x, y - 1

    def down(self, x, y):
        return x, y + 1

    def left(self, x, y):
        return x - 1, y

    def right(self, x, y):
        return x + 1, y

    def upleft(self, x, y):
        return x - 1, y - 1

    def upright(self, x, y):
        return x + 1, y - 1

    def downleft(self, x, y):
        return x - 1, y + 1

    def downright(self, x, y):
        return x + 1, y + 1

    def find_ij(self):
        for i in range(len(self.pb2d)):
            for j in range(len(self.pb2d[0])):
                if self.pb2d[i][j] is self.sender():
                    return i, j

    def myreset(self):
        self.array2D = [[0 for _ in range(self.X)] for _ in range(self.Y)]
        self.myrender()
        self.flag_ing = True
        self.flag_wb = True
        self.history.clear()
        print("게임을 다시 시작합니다.")


if __name__ == "__main__":
    # QApplication : 프로그램을 실행시켜주는 클래스
    app = QApplication(sys.argv)

    # WindowClass의 인스턴스 생성
    myWindow = WindowClass()

    # 프로그램 화면을 보여주는 코드
    myWindow.show()

    # 프로그램을 이벤트루프로 진입시키는(프로그램을 작동시키는) 코드
    app.exec_()
