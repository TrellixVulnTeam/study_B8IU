A = int(input())

if not A % 4 and A % 100 or not A % 400:
    print(1)
else:
    print(0)
