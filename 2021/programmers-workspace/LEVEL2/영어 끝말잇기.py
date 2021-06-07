def solution(n, words):
    answer = len(words)
    count = len(words)
    result = [0, 0]

    for i in range(1, answer):
        if words[i - 1][len(words[i - 1]) - 1] != words[i][0]:
            answer = i
            break

    for i in range(answer):
        if words.count(words[i]) > 1:
            if words[i + 1:].index(words[i]) + i + 1 < answer:
                count = words[i + 1:].index(words[i]) + i + 1
                break

    if answer != len(words) or count != len(words):
        if answer <= count:
            result = [(answer + 1) % n, answer // n + 1]
        else:
            result = [(count + 1) % n, count // n + 1]

    if result[0] == 0 and result[1] != 0:
        result[0] = n

    return result
