def solution(s):
    div = int(len(s) / 2)
    rem = len(s) % 2
    if rem == 1:
        answer = s[div]
    else:
        answer = s[div - 1] + s[div]
    return answer
