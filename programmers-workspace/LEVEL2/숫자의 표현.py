def solution(n):
    answer = 0
    for i in range(n // 2 + 1):
        cnt = 0
        for j in range(i + 1, n):
            cnt += j
            if cnt == n:
                answer += 1
            elif cnt > n:
                break
    return answer + 1
