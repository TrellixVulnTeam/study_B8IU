S = input()
res = []

for i in range(97, 123):
    try:
        res.append(str(S.index(chr(i))))
    except:
        res.append(str(-1))

print(" ".join(res))
