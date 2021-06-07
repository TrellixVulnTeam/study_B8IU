def solution(arr1, arr2):
    answer = []
    for a1 in arr1:
        temp = []
        for a2 in zip(*arr2):
            num = 0
            for i, j in zip(a1, a2):
                num += i * j
            temp.append(num)
        answer.append(temp)
    return answer


if __name__ == '__main__':
    print(solution([[1, 4], [3, 2], [4, 1]],
                   [[3, 3], [3, 3]]))
    print(solution([[2, 3, 2], [4, 2, 4], [3, 1, 4]],
                   [[5, 4, 3], [2, 4, 1], [3, 1, 1]]))
