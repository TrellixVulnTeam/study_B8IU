def up(position, nList, num):
    position[0] -= 1
    position[1] -= 1
    num += 1
    nList[position[0]][position[1]] = num

    return position, nList, num


def down(position, nList, num):
    position[0] += 1
    num += 1
    nList[position[0]][position[1]] = num

    return position, nList, num


def right(position, nList, num):
    position[1] += 1
    num += 1
    nList[position[0]][position[1]] = num

    return position, nList, num


def solution(n):
    answer = []
    nList = []

    for i in range(1, n + 1):
        nListTemp = [0 for _ in range(i)]
        nList.append(nListTemp)

    position = [-1, 0]
    count = 0
    num = 0
    for i in reversed(range(1, n + 1)):
        if count % 3 == 0:
            for _ in range(i):
                position, nList, num = down(position, nList, num)
        elif count % 3 == 1:
            for _ in range(i):
                position, nList, num = right(position, nList, num)
        else:
            for _ in range(i):
                position, nList, num = up(position, nList, num)
        count += 1

    for listPart in nList:
        for i in listPart:
            answer.append(i)
    return answer
