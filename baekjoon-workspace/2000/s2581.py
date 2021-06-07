M = int(input())
N = int(input())

count = 0
minnum = 10000
for num in range(M, N + 1):
    div = 2
    if num < div:
        continue
    while div <= num ** 0.5:
        if not num % div:
            break
        div += 1
    else:
        count += num
        if num < minnum:
            minnum = num

if count:
    print(count)
    print(minnum)
else:
    print(-1)
