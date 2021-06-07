def solution(s):
    answer = len(s)

    for i in range(1, len(s) // 2 + 1):
        temp = [[1, s[:i]]]
        for j in range(i, len(s), i):
            if s[j:i + j] == temp[-1][1]:
                temp[-1][0] += 1
                continue
            temp.append([1, s[j:i + j]])

        result = ""
        for count, string in temp:
            if count != 1:
                result += str(count)
            result += string

        if len(result) < answer:
            answer = len(result)
    return answer


if __name__ == '__main__':
    s = "aabbaccc"
    print(solution(s))
    s = "ababcdcdababcdcd"
    print(solution(s))
    s = "abcabcdede"
    print(solution(s))
    s = "abcabcabcabcdededededede"
    print(solution(s))
    s = "xababcdcdababcdcd"
    print(solution(s))
