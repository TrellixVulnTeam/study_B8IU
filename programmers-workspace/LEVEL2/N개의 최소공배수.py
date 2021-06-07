def solution(arr):
    n1 = arr[0]
    for i in range(1, len(arr)):
        n2 = arr[i]
        maxnum = max(n1, n2)
        minnum = min(n1, n2)
        while maxnum % minnum:
            maxnum, minnum = minnum, maxnum % minnum
        n1 = n1 * n2 / minnum

    return n1
