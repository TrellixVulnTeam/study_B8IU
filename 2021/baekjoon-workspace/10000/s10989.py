import sys

N = int(input())

inputList = [0] * 10001

for n in range(N):
    inputList[int(sys.stdin.readline().rstrip())] += 1

for n in range(10001):
    for _ in range(inputList[n]):
        sys.stdout.write(str(n) + '\n')
