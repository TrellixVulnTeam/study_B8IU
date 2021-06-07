import heapq


def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    while True:
        if scoville[0] >= K:
            return answer
        if len(scoville) == 1:
            return -1
        heapq.heappush(scoville, heapq.heappop(scoville) + heapq.heappop(scoville) * 2)
        answer += 1


if __name__ == '__main__':
    scoville = [1, 2, 3, 9, 10, 12]
    K = 7
    print(solution(scoville, K))
