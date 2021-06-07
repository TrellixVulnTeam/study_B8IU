import itertools


def solution(numbers):
    answer = 0

    numberlist = []
    for i in range(len(numbers)):
        numberlist.extend(itertools.permutations(numbers, i + 1))

    numberset = list({int("".join(i)) for i in numberlist})
    maxnum = max(numberset)

    decimal = [0, 0] + [1] * (maxnum - 1)

    for i in range(maxnum // 2 + 1):
        if decimal[i] == 1:
            for j in range(i * 2, maxnum + 1, i):
                decimal[j] = 0

    for number in numberset:
        if decimal[number] == 1:
            answer += 1

    return answer


if __name__ == '__main__':
    print(solution("17"))
    print(solution("011"))
