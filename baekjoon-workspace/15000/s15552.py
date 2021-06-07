import sys

count = int(sys.stdin.readline().rstrip())

inputList = []
for _ in range(count):
    inputList.append(list(map(int, sys.stdin.readline().rstrip().split())))

for i, j in inputList:
    print(i + j)
