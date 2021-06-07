import sys

N, M = map(int, sys.stdin.readline().rstrip().split())

aList = [[]]
bList = []

for _ in range(M - 1):
    bList = []
    for a in aList:
        if len(a) > 0:
            for n in range(a[-1], N + 1):
                bList.append(a + [n])
        else:
            for n in range(1, N + 1):
                bList.append(a + [n])
    aList = bList

for a in aList:
    if len(a) > 0:
        for n in range(a[-1], N + 1):
            sys.stdout.write(' '.join(list(map(str, a + [n]))) + "\n")
    else:
        for n in range(1, N + 1):
            sys.stdout.write(' '.join(list(map(str, a + [n]))) + "\n")
