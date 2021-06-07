def solution(s):
    answer = False
    if s.isnumeric():
        if len(s) == 4 or len(s) == 6:
            answer = True
    return answer
