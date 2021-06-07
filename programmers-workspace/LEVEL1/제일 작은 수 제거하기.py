def solution(arr):
    arr2 = arr.copy()
    arr2.sort()
    arr.remove(arr2[0])
    if arr:
        return arr
    return [-1]
