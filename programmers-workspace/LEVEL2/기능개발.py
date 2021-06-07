import math


def solution(progresses, speeds):
    answer = []
    result = []

    for i in range(len(progresses)):
        answer.append(math.ceil((100 - progresses[i]) / speeds[i]))

    for i in range(len(progresses) - 1):
        if answer[i] > answer[i + 1]:
            answer[i + 1] = answer[i]

    answerSetList = list(set(answer))
    answerSetList.sort()

    for ans in answerSetList:
        result.append(answer.count(ans))

    return result
