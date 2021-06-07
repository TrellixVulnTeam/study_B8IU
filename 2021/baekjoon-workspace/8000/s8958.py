N = int(input())
OXList = []

for _ in range(N):
    OXList.append(input())

for OX in OXList:
    res = 0
    count = 0
    for ox in OX:
        if ox == 'O':
            count += 1
        else:
            count = 0
        res += count
    print(res)
