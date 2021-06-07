N, M = map(int, input().split())
board = [input() for _ in range(N)]
wboard = [[0 for _ in range(M)] for _ in range(N)]

flag = True
for w in range(N):
    if not M % 2:
        flag = not flag
    for x in range(M):
        if flag:
            if board[w][x] == 'B':
                wboard[w][x] = 1
        else:
            if board[w][x] != 'B':
                wboard[w][x] = 1
        flag = not flag

res = []
for w in range(0, N - 7):
    for x in range(0, M - 7):
        count = 0
        for y in range(w, w + 8):
            for z in range(x, x + 8):
                if wboard[y][z]:
                    count += 1
        res.append(count)
        res.append(64 - count)

print(min(res))
