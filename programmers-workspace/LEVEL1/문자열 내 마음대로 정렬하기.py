def solution(strings, n):
    strings.sort()

    answer = []
    for i in range(97, 123):
        for j in strings:
            if ord(j[n]) == i:
                answer.append(j)
    return answer
