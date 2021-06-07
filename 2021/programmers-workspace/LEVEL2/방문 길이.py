def solution(dirs):
    position = [0, 0]
    answerset = set()

    for dir in dirs:
        if dir == "L":
            if position[0] <= -5:
                continue
            if ((position[0] - 1, position[1]), (position[0], position[1])) not in answerset:
                answerset.add(((position[0], position[1]), (position[0] - 1, position[1])))
            position[0] -= 1
        if dir == "R":
            if 5 <= position[0]:
                continue
            if ((position[0] + 1, position[1]), (position[0], position[1])) not in answerset:
                answerset.add(((position[0], position[1]), (position[0] + 1, position[1])))
            position[0] += 1
        if dir == "U":
            if position[1] <= -5:
                continue
            if ((position[0], position[1] - 1), (position[0], position[1])) not in answerset:
                answerset.add(((position[0], position[1]), (position[0], position[1] - 1)))
            position[1] -= 1
        if dir == "D":
            if 5 <= position[1]:
                continue
            if ((position[0], position[1] + 1), (position[0], position[1])) not in answerset:
                answerset.add(((position[0], position[1]), (position[0], position[1] + 1)))
            position[1] += 1

    return len(answerset)


if __name__ == '__main__':
    print(solution("ULURRDLLU"))
    print(solution("LULLLLLLU"))
