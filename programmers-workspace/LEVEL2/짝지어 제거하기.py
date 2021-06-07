def solution(s):
    stack = []
    for ch in s:
        if not stack:
            stack.append(ch)
            continue
        if stack[-1] == ch:
            stack.pop()
            continue
        stack.append(ch)

    return int(not stack)


if __name__ == '__main__':
    s = 'baabaa'
    print(solution(s))
    s = 'cdcd'
    print(solution(s))
