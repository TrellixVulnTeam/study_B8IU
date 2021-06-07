N = input()
F = int(input())

addNum = 0
while True:
    addNumToChar = str(addNum)
    if len(addNumToChar) == 1:
        addNumToChar = "0" + addNumToChar
    N = N[:-2] + addNumToChar
    if int(N) % F == 0:
        print(addNumToChar)
        break
    addNum += 1
