def numtobinary(num):
    res = ""
    while num:
        res += str(num % 2)
        num = num // 2
    return res[::-1]


def solution(s):
    answer = [0, 0]

    while len(s) != 1:
        startlen = len(s)
        s = s.replace("0", "")
        endlen = len(s)

        answer[0] += 1
        answer[1] += startlen - endlen

        s = numtobinary(endlen)

    return answer


if __name__ == '__main__':
    print(solution("110010101001"))
    print(solution("01110"))
    print(solution("1111111"))
