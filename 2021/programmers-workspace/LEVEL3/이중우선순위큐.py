def solution(operations):
    que = []

    for operation in operations:
        if operation.startswith("I"):
            que.append(int(operation[1:].strip()))
        elif operation == "D 1" and que:
            que.pop(que.index(max(que)))
        elif operation == "D -1" and que:
            que.pop(que.index(min(que)))
    if que:
        return [max(que), min(que)]
    return [0, 0]


if __name__ == '__main__':
    print(solution(["I 16", "D 1"]))
    print(solution(["I 7", "I 5", "I -5", "D -1"]))
