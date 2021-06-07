T = int(input())
xy = [list(map(int, input().split())) for _ in range(T)]

for x, y in xy:
    distance = max(x, y) - min(x, y)
    addnum = 1
    count = 0

    while distance - addnum * 2 > 0:
        count += 2
        distance -= addnum * 2
        addnum += 1

    while distance:
        if distance < addnum:
            addnum -= 1
        if not distance < addnum:
            count += 1
            distance -= addnum

    print(count)
