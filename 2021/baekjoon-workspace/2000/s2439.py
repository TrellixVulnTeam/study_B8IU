A = int(input())

for i in range(A):
    res = '*' * (i + 1)
    for _ in range(A - len(res)):
        print(' ', end='')
    print(res)
