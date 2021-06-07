N = int(input())

if N < 100:
    print(N)
else:
    count = 99

    for i in range(100, N + 1):
        if int(str(i)[0]) - int(str(i)[1]) == int(str(i)[1]) - int(str(i)[2]):
            count += 1

    print(count)
