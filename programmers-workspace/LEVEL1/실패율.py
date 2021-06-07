def solution(N, stages):
    answer = []
    percentage = []
    sucess_list = [0 for _ in range(N + 1)]

    for i in stages:
        for j in range(i):
            sucess_list[j] += 1

    for i in range(N):
        if sucess_list[i] > 0:
            percentage.append(tuple([(sucess_list[i + 1] - sucess_list[i]) / sucess_list[i], i + 1]))
        else:
            percentage.append(tuple([0, i + 1]))
    percentage.sort()
    for _, i in percentage:
        answer.append(i)
    print(percentage)
    return answer
