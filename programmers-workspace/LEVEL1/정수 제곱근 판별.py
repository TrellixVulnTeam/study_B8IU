def solution(n):
    if int(n ** 0.5) == n ** 0.5:
        answer = (n ** 0.5 + 1) ** 2
    else:
        answer = -1
    return answer
