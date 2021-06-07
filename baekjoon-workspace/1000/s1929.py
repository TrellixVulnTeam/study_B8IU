M, N = map(int, input().split())

flagList = [True] * (N + 1)

for i in range(2, int(N ** 0.5) + 1):
    if flagList[i]:
        for j in range(i * 2, N + 1, i):
            flagList[j] = False

for i in range(M, N + 1):
    if i <= 1:
        continue
    if flagList[i]:
        print(i)
