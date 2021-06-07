point = [list(map(int, input().split())) for _ in range(3)]
xList = [x for x, _ in point]
yList = [y for _, y in point]

xList.sort()
yList.sort()

if xList[0] == xList[1]:
    x = xList[2]
else:
    x = xList[0]

if yList[0] == yList[1]:
    y = yList[2]
else:
    y = yList[0]

print(x, y)
