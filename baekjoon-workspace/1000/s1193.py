N = int(input())

floor = 1
stack = 1

while stack < N:
    floor += 1
    stack += floor
if floor % 2:
    print(str(stack - N + 1) + "/" + str(N - stack + floor))
else:
    print(str(N - stack + floor) + "/" + str(stack - N + 1))
