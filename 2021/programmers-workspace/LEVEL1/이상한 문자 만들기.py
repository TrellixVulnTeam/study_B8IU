def solution(s):
    answer = ''
    t = s.split(' ')
    for k in t:
        j = 0
        for i in k:
            if not j % 2:
                answer += i.upper()
            else:
                answer += i.lower()
            j += 1
        answer += " "
    return answer[:-1]
