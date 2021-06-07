import heapq


def solution(n, works):
    if sum(works) <= n:
        return 0

    heap = []

    for work in works:
        heapq.heappush(heap, (-work, work))

    for _ in range(n):
        work = heapq.heappop(heap)[1] - 1
        heapq.heappush(heap, (-work, work))

    return sum([work ** 2 for _, work in heap])


if __name__ == '__main__':
    print(solution(4, [4, 3, 3]))
    print(solution(1, [2, 1, 2]))
    print(solution(3, [1, 1]))
