def solution(s):
    answer = s.split()
    for i in range(len(answer)):
        answer[i] = int(answer[i])

    answer = str(min(answer)) + " " + str(max(answer))
    return answer
