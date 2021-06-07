import numpy as np


def solution(bridge_length, weight, truck_weights):
    answer = 0

    time = np.zeros(1, dtype=int)
    time = np.append(time, np.zeros(5, dtype=int))
    print(time)

    return answer


if __name__ == '__main__':
    print(solution(2, 10, [7, 4, 5, 6]))
    print(solution(100, 100, [10]))
    print(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]))
