clo = []

n = int(input())

for _ in range(n):
    c = int(input())
    clo.append([input().split() for _ in range(c)])

for c in clo:
    clodict = dict()
    for n in c:
        if n[1] in clodict:
            clodict[n[1]] += 1
        else:
            clodict[n[1]] = 2
    num = 1
    for s in clodict.values():
        num *= s
    print(num - 1)
