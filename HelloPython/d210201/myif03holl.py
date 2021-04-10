import random

human = input("홀/짝을 입력하세요.")

if random.random() > 1 / 2:
    com = "홀"
else:
    com = "짝"

print("당신은 %s을 컴퓨터는 %s을 냈습니다." % (human, com))
if human == com:
    print("맞췄습니다.")
else:
    print("틀렸습니다.")
