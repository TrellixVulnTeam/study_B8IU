def solution(clothes):
    answer = 1
    clothes_dict = dict()
    for _, j in clothes:
        clothes_dict[j] = clothes_dict.get(j, 0) + 1
    for i in clothes_dict.values():
        answer *= i + 1
    return answer - 1
