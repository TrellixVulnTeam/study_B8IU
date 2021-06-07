import datetime


def solution(a, b):
    weekday = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN']
    d = datetime.date(2016, a, b)
    answer = weekday[d.weekday()]
    return answer
