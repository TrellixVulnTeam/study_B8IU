import numpy as np


def solution(citations):
    cnt = np.zeros((max(citations) + 1, 2), dtype=int)
    for citation in citations:
        cnt[citation:, 0] += 1
        cnt[:citation + 1, 1] += 1
    answer = 0
    for idx, (i, j) in enumerate(cnt):
        if i <= idx <= j:
            answer = idx
    return answer


if __name__ == '__main__':
    print(solution([3, 0, 6, 1, 5]))
