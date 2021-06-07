import sys

A = []

while True:
    try:
        a, b = map(int, sys.stdin.readline().split())
        if not 0 < a < 10 and not 0 < b < 10:
            break
        A.append((a, b))
    except:
        break

for i, j in A:
    print(i + j)
