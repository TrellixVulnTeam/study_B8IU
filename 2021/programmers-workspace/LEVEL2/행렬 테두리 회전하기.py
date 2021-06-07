def solution(rows, columns, queries):
    answer = []

    board = [[i * columns + j + 1 for j in range(columns)] for i in range(rows)]

    for x1, y1, x2, y2 in queries:
        temp = board[x1 - 1][y1 - 1]
        minimum = temp
        for x in range(x1, x2):
            y = y1 - 1
            if board[x][y] < minimum:
                minimum = board[x][y]
            board[x - 1][y] = board[x][y]

        for y in range(y1, y2):
            x = x2 - 1
            if board[x][y] < minimum:
                minimum = board[x][y]
            board[x][y - 1] = board[x][y]

        for x in range(x2 - 1, x1 - 1, -1):
            y = y2 - 1
            if board[x][y] < minimum:
                minimum = board[x][y]
            board[x][y] = board[x - 1][y]

        for y in range(y2 - 1, y1 - 1, -1):
            x = x1 - 1
            if board[x][y] < minimum:
                minimum = board[x][y]
            board[x][y] = board[x][y - 1]

        board[x1 - 1][y1] = temp
        answer.append(minimum)

    return answer


if __name__ == '__main__':
    rows = 6
    columns = 6
    queries = [[2, 2, 5, 4], [3, 3, 6, 6], [5, 1, 6, 3]]
    print(solution(rows, columns, queries))

    rows = 3
    columns = 3
    queries = [[1, 1, 2, 2], [1, 2, 2, 3], [2, 1, 3, 2], [2, 2, 3, 3]]
    print(solution(rows, columns, queries))

    rows = 100
    columns = 97
    queries = [[1, 1, 100, 97]]
    print(solution(rows, columns, queries))
