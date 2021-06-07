A = int(input())
B = int(input())

if 0 < A and 0 < B:
    print(1)
elif A < 0 and 0 < B:
    print(2)
elif A < 0 and B < 0:
    print(3)
else:
    print(4)
