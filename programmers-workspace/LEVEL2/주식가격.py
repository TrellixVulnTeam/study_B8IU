def solution(prices):
    answer = []

    for _ in prices:
        answer.append(0)

    for i in range(len(prices)):
        for j in range(i + 1, len(prices)):
            if prices[i] > prices[j]:
                answer[i] = j - i
                break
            elif len(prices) - 1 == j:
                answer[i] = j - i
                break
    return answer
