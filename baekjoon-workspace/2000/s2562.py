num9list = list()

for _ in range(9):
    num9list.append(int(input()))

maxnum = max(num9list)
index = num9list.index(maxnum)

print(maxnum)
print(index + 1)
