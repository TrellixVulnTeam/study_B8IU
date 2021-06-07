def solution(str1, str2):
    str1 = str1.lower()
    str2 = str2.lower()
    str1dict = dict()
    str2dict = dict()

    for i in range(len(str1) - 1):
        string = str1[i:i + 2]
        if string.isalpha():
            str1dict[string] = str1dict.get(string, 0) + 1
    for i in range(len(str2) - 1):
        string = str2[i:i + 2]
        if string.isalpha():
            str2dict[string] = str2dict.get(string, 0) + 1

    intersection = set(str1dict) & set(str2dict)
    union = set(str1dict) | set(str2dict)

    intersectioncount = 0
    unioncount = 0

    for string in list(intersection):
        intersectioncount += min(str1dict[string], str2dict[string])
    for string in list(union):
        unioncount += max(str1dict.get(string, 0), str2dict.get(string, 0))
    if not intersectioncount and not unioncount:
        return 1 * 65536

    return intersectioncount * 65536 // unioncount


if __name__ == '__main__':
    str1 = "FRANCE"
    str2 = "french"
    print(solution(str1, str2))

    str1 = "handshake"
    str2 = "shake hands"
    print(solution(str1, str2))

    str1 = "aa1+aa2"
    str2 = "AAAA12"
    print(solution(str1, str2))

    str1 = "E=M*C^2"
    str2 = "e=m*c^2"
    print(solution(str1, str2))
