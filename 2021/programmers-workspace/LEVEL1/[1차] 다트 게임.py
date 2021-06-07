def solution(dartResult):
    answer = 0
    result_list = [1, 1, 1]
    list_pointer = -1

    while len(dartResult):
        this = dartResult[:1]
        dartResult = dartResult[1:]
        if this.isdigit():
            list_pointer += 1
            if dartResult[:1].isdigit():
                this = 10
                dartResult = dartResult[1:]
            result_list[list_pointer] *= int(this)
        elif this == "S":
            result_list[list_pointer] = result_list[list_pointer] ** 1
        elif this == "D":
            result_list[list_pointer] = result_list[list_pointer] ** 2
        elif this == "T":
            result_list[list_pointer] = result_list[list_pointer] ** 3
        elif this == "*":
            result_list[list_pointer] = result_list[list_pointer] * 2
            if list_pointer:
                result_list[list_pointer - 1] = result_list[list_pointer - 1] * 2
        elif this == "#":
            result_list[list_pointer] = result_list[list_pointer] * -1

    for i in result_list:
        answer += i
    return answer
