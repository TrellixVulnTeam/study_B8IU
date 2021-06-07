def solution(n, a, b):
    n, a, b = n - 1, a - 1, b - 1
    rnd = 0

    while True:
        rnd += 1
        if a % 2 == 0 and a + 1 == b or b % 2 == 0 and b + 1 == a:
            break
        a, b = a // 2, b // 2
    return rnd
