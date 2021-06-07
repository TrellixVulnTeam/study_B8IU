def solution(number, k):
    numlist = list(number)
    pointer = 0
    while k:
        listpart = numlist[pointer:pointer + k + 1]
        if listpart:
            start = listpart.index(max(listpart))
            if start:
                numlist = numlist[:pointer] + numlist[pointer + start:]
                k -= start
            pointer += 1
        else:
            numlist = numlist[:-k]

    return ''.join(numlist)


if __name__ == '__main__':
    print(solution("1924", 2))
    print(solution("1231234", 3))
    print(solution("4177252841", 4))
