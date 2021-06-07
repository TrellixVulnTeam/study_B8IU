N = int(input())
nList = [int(input()) for _ in range(N)]
nDict = dict()

for n in nList:
    nDict[n] = nDict.get(n, 0) + 1

maxnum = -4000
maxnumList = []
for i, j in nDict.items():
    if maxnum < j:
        maxnum = j
        maxnumList = [i]
    elif maxnum == j:
        maxnumList.append(i)

maxnumList.sort()
nList.sort()

print(round(sum(nList) / len(nList)))
print(nList[len(nList)//2])
if len(maxnumList) > 1:
    print(maxnumList[1])
else:
    print(maxnumList[0])
print(max(nList) - min(nList))
