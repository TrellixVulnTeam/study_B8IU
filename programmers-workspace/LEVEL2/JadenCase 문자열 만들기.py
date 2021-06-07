def solution(s):
    arr = []
    temp = ""
    for c in s:
        if c == " ":
            arr.append(temp.capitalize())
            temp = ""
        else:
            temp += c
    else:
        arr.append(temp.capitalize())

    answer = ' '.join(arr)
    return answer


if __name__ == '__main__':
    print(solution("3people unFollowed me"))
    print(solution("for the last week"))
