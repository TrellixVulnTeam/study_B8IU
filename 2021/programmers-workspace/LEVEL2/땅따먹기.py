from itertools import product


def solution(land):
    answer = 0

    productlist = product(range(4), repeat=len(land))
    for prod in productlist:
        for index in range(len(prod) - 1):
            if prod[index] == prod[index + 1]:
                break
        else:
            values = 0
            for index in range(len(prod)):
                values += land[index][prod[index]]
            if answer < values:
                answer = values

    return answer


if __name__ == '__main__':
    print(solution([[1, 2, 3, 5], [5, 6, 7, 8], [4, 3, 2, 1]]))
