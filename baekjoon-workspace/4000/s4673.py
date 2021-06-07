numset = set()

for i in range(1, 10001):
    temp = i
    for j in str(i):
        temp += int(j)
    numset.add(temp)

for i in range(1, 10001):
    if i not in numset:
        print(i)
