def factorial(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return factorial(n - 1) * n


N = int(input())

if N:
    facN = factorial(N)
    print(len(str(facN)) - len(str(facN)[::-1].lstrip("0")))
else:
    print(0)
