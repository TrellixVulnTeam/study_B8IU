count = int(input())

inputList = []
for _ in range(count):
    inputList.append(list(map(int, input().split())))

for i, j in inputList:
    print(i + j)
