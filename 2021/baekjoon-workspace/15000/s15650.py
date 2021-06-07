import sys

N, M = map(int, sys.stdin.readline().rstrip().split())

aSet = set()
aList = [aSet]
bList = []

for _ in range(M - 1):
    bList = []
    for a in aList:
        for n in range(len(aList[0]) + 1, N - M + len(aList[0]) + 2):
            if n not in a:
                if a | {n} not in aList:
                    bList.append(a | {n})
    aList = bList

for a in aList:
    for n in range(M, N + 1):
        if n not in a:
            if a | {n} not in bList:
                if len(a | {n}) == M:
                    bList.append(a | {n})
                    sys.stdout.write(' '.join(list(map(str, a | {n}))) + "\n")
