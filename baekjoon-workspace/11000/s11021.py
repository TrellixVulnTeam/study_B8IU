import sys

count = int(sys.stdin.readline().rstrip())

inputList = []
for _ in range(count):
    inputList.append(list(map(int, sys.stdin.readline().rstrip().split())))

for k, (i, j) in enumerate(inputList):
    print(f"Case #{k + 1}:", i + j)
