def solution(n):
    i1 = 0
    i2 = 1

    for _ in range(n - 1):
        temp = i1
        i1 = i2
        i2 = temp + i1
    answer = i2 % 1234567
    return answer
