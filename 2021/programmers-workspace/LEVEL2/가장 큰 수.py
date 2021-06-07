def solution(numbers):
    number = list(map(str, numbers))
    answer = list()
    for num in number:
        i = 0
        for i in range(len(answer)):

        answer.insert(i, num)



if __name__ == '__main__':
    print(solution([0, 5, 10, 15, 20]))
    print(solution([1000, 0, 5, 99, 100]))
    print(solution([40, 403]))
