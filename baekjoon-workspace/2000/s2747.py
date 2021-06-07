fDict = {0: 0, 1: 1}


def f(n):
    if n in fDict:
        return fDict[n]
    fDict[n] = f(n - 1) + f(n - 2)
    return fDict[n]


n = int(input())
print(f(n))
