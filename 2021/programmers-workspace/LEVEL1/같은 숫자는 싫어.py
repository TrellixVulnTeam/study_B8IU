def solution(arr):
    result = []
    temp = float('inf')

    for i in arr:
        if temp != i:
            result.append(i)
        temp = i

    return result
