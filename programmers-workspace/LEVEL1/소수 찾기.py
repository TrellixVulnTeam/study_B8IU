def solution(n):
    aSet = set(range(2, n + 1))
    for i in range(2, int(n ** 0.5 + 2)):
        aSet -= set(range(i * 2, n + 1, i))
    return len(aSet)
