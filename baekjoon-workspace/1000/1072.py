X, Y = map(int, input().split())

now = Y * 100 // X

if now == 100 or now:
    print(-1)
else:
    x = X
    y = Y
    while True:
        y += 1
        x += 1
        if now != y * 100 // x:
            print(y - Y)
            break
