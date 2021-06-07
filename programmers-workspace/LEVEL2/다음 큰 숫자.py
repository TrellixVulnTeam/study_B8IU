def maketobinary(num):
    res = ""
    while num != 0:
        res += str(num % 2)
        num = num // 2
    return res[::-1]


def solution(n):
    num = n + 1

    binaryn = maketobinary(n)
    ansn = maketobinary(num)
    while binaryn.count("1") != ansn.count("1"):
        num += 1
        ansn = maketobinary(num)

    return num


if __name__ == '__main__':
    print(solution(78))
    print(solution(15))
