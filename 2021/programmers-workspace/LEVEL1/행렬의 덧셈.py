def solution(arr1, arr2):
    answer = []
    for i in range(len(arr1)):
        zip_list = list(zip(arr1[i], arr2[i]))
        temp_list = []
        for j, k in zip_list:
            temp_list.append(j + k)
        answer.append(temp_list)
    return answer
