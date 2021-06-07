point = list()

while True:
    pointList = list(map(int, input().split()))
    pointList.sort()
    a, b, c = pointList
    if not a and not b and not c:
        break
    point.append((a, b, c))

for po in point:
    if po[0] ** 2 + po[1] ** 2 == po[2] ** 2:
        print('right')
    else:
        print('wrong')
