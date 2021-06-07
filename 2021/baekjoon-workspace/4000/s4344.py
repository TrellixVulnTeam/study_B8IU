N = int(input())
numList = []

for _ in range(N):
    numList.append(list(map(int, input().split())))

for numlist in numList:
    numlist = numlist[1:]
    avg = (sum(numlist) / len(numlist))
    count = 0
    for num in numlist:
        if num > avg:
            count += 1
    avgper = count / len(numlist) * 100
    print('%.3f%%' % avgper)
