def solution(n, arr1, arr2):
    answer = []
    temp = []
    map1 = []
    map2 = []
    for i in arr1:
        for _ in range(n):
            temp.append(i % 2)
            i = i // 2
        map1.append(temp)
        temp = []

    for i in arr2:
        for _ in range(n):
            temp.append(i % 2)
            i = i // 2
        map2.append(temp)
        temp = []
    for i, j in list(zip(map1, map2)):
        for k, l in list(zip(i, j)):
            if k or l:
                temp.append('#')
            else:
                temp.append(' ')
        temp.reverse()
        answer.append("".join(temp))
        temp = []
    return answer
