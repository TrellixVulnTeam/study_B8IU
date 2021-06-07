def solution(priorities, location):
    answer = 0
    index = 0

    while True:
        if index == len(priorities):
            index = 0
        print(priorities, index)
        if priorities[index] != max(priorities):
            index += 1
        else:
            answer += 1
            if location == index:
                break
            else:
                del priorities[index]
                if index < location:
                    location -= 1

    return answer
