def solution(board, moves):
    poplist = list()
    answer = 0
    for i in range(len(moves)):
        for j in range(len(board)):
            if board[j][moves[i] - 1] != 0:
                poplist.append(board[j][moves[i] - 1])
                board[j][moves[i] - 1] = 0
                break

    i = 1
    while True:
        temp = poplist[i - 1]
        if temp == poplist[i]:
            answer = answer + 2
            del poplist[i]
            del poplist[i - 1]
            i = i - 1
            if i == 0:
                i = 1
            if not i < len(poplist):
                break
        else:
            i = i + 1
            if not i < len(poplist):
                break

    return answer
