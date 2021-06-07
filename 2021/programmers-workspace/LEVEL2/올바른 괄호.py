def solution(s):
    index = 0
    count = 0
    while True:
        if index == len(s):
            break

        if s[index] == '(':
            count += 1
        else:
            count -= 1

        if count < 0:
            break

        index += 1

    if count == 0:
        return True
    else:
        return False
