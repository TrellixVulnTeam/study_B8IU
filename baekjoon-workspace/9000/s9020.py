T = int(input())
nList = [int(input()) for _ in range(T)]

maxnum = max(nList)

flagList = [True] * (maxnum + 1)

flagList[1] = False
for i in range(2, int(maxnum ** 0.5) + 1):
    if flagList[i]:
        for j in range(i * 2, maxnum + 1, i):
            flagList[j] = False

for n in nList:
    a = n // 2
    while True:
        if flagList[a] and flagList[n - a]:
            print(a, n - a)
            break
        a -= 1
