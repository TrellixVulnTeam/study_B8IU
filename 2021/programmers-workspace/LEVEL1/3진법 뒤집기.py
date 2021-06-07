def solution(n):
    answer = ''
    result = 0
    while n:
        answer += str(n % 3)
        n = int(n / 3)
    while len(answer) > 0:
        result += int(answer[:1]) * 3 ** (len(answer) - 1)
        answer = answer[1:]

    return result
