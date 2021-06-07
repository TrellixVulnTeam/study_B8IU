N = input()
backup = N

if len(N) == 1:
    result = int(N)
else:
    result = (int(N[1:]) + 1) * len(N)
    print(result)

    while N:
        result += 10 ** (len(N) - 1) * 0.9 * (len(N) - 1)
        N = N[1:]

print(int(result))

result = 0
for i in range(1, 1 + int(backup)):
    result += len(str(i))

print(result)
