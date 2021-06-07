def solution(w, h):
    maxnum, minnum = max(w, h), min(w, h)
    while maxnum % minnum:
        maxnum, minnum = minnum, maxnum % minnum

    return w * h - w - h + minnum
