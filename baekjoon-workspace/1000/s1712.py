A, B, C = map(int, input().split())

benefit = C - B

if C < B or not benefit:
    print(-1)
else:
    print(A // benefit + 1)
