N = int(input())
nList = list(map(int, input().split()))

count = 0
for num in nList:
    div = 2
    if num < div:
        continue
    while div <= num ** 0.5:
        if not num % div:
            break
        div += 1
    else:
        count += 1

print(count)
