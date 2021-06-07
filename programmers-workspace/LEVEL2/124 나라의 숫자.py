def solution(n):
    a = 0
    b = 1
    answerTemp = ''
    while True:
        if a + 3 ** b < n:
            a += 3 ** b
            b += 1
        else:
            break
    while b > 0:
        added = False
        for i in range(2, -1, -1):

            if a + 3 ** b / 3 * i < n:
                n -= 3 ** b / 3 * (i + 1)
                answerTemp += str(i)
                added = True
                break
        if not added:
            answerTemp += str(0)

        b -= 1
        a -= 3 ** b

    answer = ""
    for i in answerTemp:
        if i == "0":
            answer += "1"
        elif i == "1":
            answer += "2"
        else:
            answer += "4"

    return answer
