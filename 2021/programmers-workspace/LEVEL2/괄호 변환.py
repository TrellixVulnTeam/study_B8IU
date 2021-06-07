def correctParenthesisString(s):
    cnt = 0
    for c in s:
        if c == '(':
            cnt += 1
        else:
            cnt -= 1
        if cnt < 0:
            return False
    return True


def reverse(s):
    res = ""
    for c in s:
        if c == "(":
            res += ")"
        else:
            res += "("
    return res


def solution(p):
    if correctParenthesisString(p):
        return p

    cnt = 0
    location = 0
    for s in p:
        location += 1
        if s == '(':
            cnt += 1
        else:
            cnt -= 1
        if cnt == 0:
            break
    u = p[:location]
    v = p[location:]

    if correctParenthesisString(u):
        return u + solution(v)
    answer = '(' + solution(v) + ')' + reverse(u[1:-1])
    return answer


if __name__ == '__main__':
    p = "(())()"
    print(solution(p))
