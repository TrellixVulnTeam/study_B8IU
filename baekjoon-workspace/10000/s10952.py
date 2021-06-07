A = []

while True:
    a, b = list(map(int, input().split()))
    if not a and not b:
        break
    A.append((a, b))

for i, j in A:
    print(i + j)
