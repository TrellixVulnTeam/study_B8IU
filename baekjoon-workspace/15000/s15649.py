import sys

N, M = map(int, sys.stdin.readline().rstrip().split())

aList = [[]]
bList = []

for _ in range(M - 1):
    for a in aList:
        for n in range(1, N + 1):
            if n not in a:
                bList.append(a + [n])
    aList = bList
    bList = []

for a in aList:
    for n in range(1, N + 1):
        if n not in a:
            sys.stdout.write(' '.join(list(map(str, a + [n]))) + "\n")
