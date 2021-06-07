def solution(n):
    ans = 0

    while True:
        if n % 2:
            n -= 1
            ans += 1
        else:
            n = n // 2
        if not n:
            return ans
