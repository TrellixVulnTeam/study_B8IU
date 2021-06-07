n = int(input())

for i in range(n):
    sumnum = i
    for j in str(i):
        sumnum += int(j)
    if sumnum == n:
        print(i)
        break
else:
    print(0)
