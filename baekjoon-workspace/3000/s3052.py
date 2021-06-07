numList = list()
numSet = set()

for _ in range(10):
    numList.append(int(input()))

for i in numList:
    numSet.add(i % 42)

print(len(numSet))
