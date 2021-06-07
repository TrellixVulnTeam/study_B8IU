def solution(n, m):
    answer = []

    if m == n:
        return [n, m]

    if m > n:
        bigone = m
        smallone = n
    else:
        bigone = n
        smallone = m

    num = smallone
    bigtimes = 1
    smalltimes = 1

    while True:
        if not (bigone % num or smallone % num):
            answer.append(num)
            break
        else:
            num -= 1

    while True:
        if bigone * bigtimes == smallone * smalltimes:
            answer.append(bigone * bigtimes)
            break
        if bigone * bigtimes > smallone * smalltimes:
            smalltimes += 1
        else:
            bigtimes += 1

    return answer
