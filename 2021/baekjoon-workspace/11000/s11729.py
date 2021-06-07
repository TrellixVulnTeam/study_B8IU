def path(N, START, GOAL):
    move.append((START, GOAL))


def hanoi(N, START, GOAL, ASSISTANT):
    if N == 1:
        path(N, START, GOAL)
    else:
        hanoi(N - 1, START, ASSISTANT, GOAL)
        path(N, START, GOAL)
        hanoi(N - 1, ASSISTANT, GOAL, START)


if __name__ == '__main__':
    N = int(input())
    move = list()
    hanoi(N, '1', '3', '2')
    print(len(move))
    for i, j in move:
        print(i, j)
