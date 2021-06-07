def solution(n, lost, reserve):
    n_list = [1 for _ in range(n)]

    for i in lost:
        n_list[i - 1] -= 1
    for i in reserve:
        n_list[i - 1] += 1
    while True:
        if 0 in n_list:
            if n_list.index(0) == 0:
                if n_list[n_list.index(0) + 1] == 2:
                    n_list[n_list.index(0) + 1] = 1
                    n_list[n_list.index(0)] = 1

                else:
                    del n_list[n_list.index(0)]
            elif n_list.index(0) == len(n_list) - 1:
                if n_list[n_list.index(0) - 1] == 2:
                    n_list[n_list.index(0) - 1] = 1
                    n_list[n_list.index(0)] = 1

                else:
                    del n_list[n_list.index(0)]
            else:
                if n_list[n_list.index(0) - 1] == 2:
                    n_list[n_list.index(0) - 1] = 1
                    n_list[n_list.index(0)] = 1

                elif n_list[n_list.index(0) + 1] == 2:
                    n_list[n_list.index(0) + 1] = 1
                    n_list[n_list.index(0)] = 1

                else:
                    del n_list[n_list.index(0)]
        else:
            break
    answer = len(n_list)
    return answer
