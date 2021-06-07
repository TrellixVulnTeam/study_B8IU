def solution(name):
    string = "A" * len(name)
    pointer = 0
    changeList = [min(abs(65 - ord(name[i])), abs(91 - ord(name[i]))) for i in range(len(name))]
    answer = sum(changeList)
    string = name[0] + string[1:]

    while string != name:
        step = 0
        check = pointer + step
        if check >= len(name):
            check -= len(name)

        while string[check] == name[check] and string[pointer - step] == name[pointer - step]:
            step += 1
            check = pointer + step
            if check >= len(name):
                check -= len(name)
        if string[check] != name[check]:
            pointer = check
        else:
            pointer = pointer - step
            if pointer < 0:
                pointer += len(name)
        answer += step

        string = string[:pointer] + name[pointer] + string[pointer + 1:]

    return answer


if __name__ == '__main__':
    name = "JAZ"
    print(solution(name))
    name = "JEROEN"
    print(solution(name))
    name = "JAN"
    print(solution(name))
