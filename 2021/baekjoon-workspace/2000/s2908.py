a, b = input().split()

a, b = int(a[::-1]), int(b[::-1])

if a < b:
    print(b)
else:
    print(a)
