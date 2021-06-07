nList = list()

while True:
    i = int(input())
    if not i:
        break
    nList.append(i)

maxnum = max(nList)

flagList = [True] * (maxnum * 2 + 1)

for i in range(2, int(maxnum * 2 ** 0.5) + 1):
    if flagList[i]:
        for j in range(i * 2, maxnum * 2 + 1, i):
            flagList[j] = False

for num in nList:
    count = 0
    for i in range(num + 1, 2 * num + 1):
        if i <= 1:
            continue
        if flagList[i]:
            count += 1
    print(count)
