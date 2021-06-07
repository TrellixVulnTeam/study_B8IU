def solution(a, b):
    zip_list = list(zip(a, b))
    result = 0
    for i, j in zip_list:
        result += i * j
    return result
