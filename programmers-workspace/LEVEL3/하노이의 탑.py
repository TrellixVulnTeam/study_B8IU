def path(N, START, GOAL, move):
    move.append([START, GOAL])


def hanoi(N, START, GOAL, ASSISTANT, move):
    if N == 1:
        path(N, START, GOAL, move)
    else:
        hanoi(N - 1, START, ASSISTANT, GOAL, move)
        path(N, START, GOAL, move)
        hanoi(N - 1, ASSISTANT, GOAL, START, move)


def solution(n):
    move = []
    hanoi(n, 1, 3, 2, move)
    return move
