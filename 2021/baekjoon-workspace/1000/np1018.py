import numpy as np

N, M = map(int, input().split())
board = [input() for _ in range(N)]
wboard = np.zeros((N, M))

flag = True
for i in range(N):
    if not M % 2:
        flag = not flag
    for j in range(M):
        if flag:
            if board[i][j] == 'B':
                wboard[i][j] = 1
        else:
            if board[i][j] != 'B':
                wboard[i][j] = 1
        flag = not flag

res = []
for i in range(0, N - 7):
    for j in range(0, M - 7):
        res.append(np.count_nonzero(wboard[i:i+8, j:j+8] == 1))
        res.append(64 - np.count_nonzero(wboard[i:i+8, j:j+8] == 1))

print(min(res))
