A = int(input())
B = int(input())
C = int(input())

numdice = {'0': 0,
           '1': 0,
           '2': 0,
           '3': 0,
           '4': 0,
           '5': 0,
           '6': 0,
           '7': 0,
           '8': 0,
           '9': 0}

mulnum = str(A * B * C)
for i in mulnum:
    numdice[i] = numdice.get(i, 0) + 1

for i in numdice.values():
    print(i)
