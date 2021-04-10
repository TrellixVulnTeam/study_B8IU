import random

mine = input("가위/바위/보 중에 입력하세요.")

if mine != "가위" and mine != "바위" and mine != "보":
    print("가위/바위/보 중에 입력하세요 !!!")
    exit(0)

rnd = random.random()

if rnd < 1 / 3:
    com = "가위"
elif rnd < 2 / 3:
    com = "바위"
else:
    com = "보"

if com == mine:
    result = "무승부"
elif com == "가위" and mine == "바위" or com == "바위" and mine == "보" or com == "보" and mine == "가위":
    result = "승리"
else:
    result = "패배"

print("당신이 낸 것 : " + mine)
print("컴퓨터가 낸 것 : " + com)
print("결과 : " + result)
