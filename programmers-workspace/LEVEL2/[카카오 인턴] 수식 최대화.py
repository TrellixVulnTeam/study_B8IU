import itertools


def solution(expression):
    answer = 0
    expressionList = list()
    temp = ""
    for s in expression:
        if s.isnumeric():
            temp += s
        else:
            expressionList.append(temp)
            expressionList.append(s)
            temp = ""
    else:
        expressionList.append(temp)

    for order in itertools.permutations(['*', '-', '+'], 3):
        expr = expressionList.copy()
        for sign in order:
            while sign in expr:
                index = expr.index(sign) - 1
                temp = eval(str(expr.pop(index)) + expr.pop(index) + str(expr.pop(index)))
                expr.insert(index, temp)
        if abs(expr[0]) > answer:
            answer = abs(expr[0])

    return answer


if __name__ == '__main__':
    expression = "100-200*300-500+20"
    print(solution(expression))
    expression = "50*6-3*2"
    print(solution(expression))
