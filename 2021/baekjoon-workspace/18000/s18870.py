N = int(input())
X = list(map(int, input().split()))

numdict = {num: index for index, num in enumerate(sorted(list(set(X))))}
res = []
for x in X:
    res.append(numdict[x])
print(" ".join(map(str, res)))
