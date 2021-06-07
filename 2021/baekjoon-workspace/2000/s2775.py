T = int(input())
kn = list()

for _ in range(T):
    k = int(input())
    n = int(input())
    kn.append((k, n))

for a, b in kn:
    floor = [[j for j in range(1, b + 1)]]
    for i in range(a):
        temp = [1]
        for j in range(1, b):
            temp.append(temp[j - 1] + floor[i][j])
        floor.append(temp)
    print(floor[a][b - 1])
