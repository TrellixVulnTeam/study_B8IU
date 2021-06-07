import time


def solution(n):
    answer = ''
    for i in range(n):
        if i % 2 == 0:
            answer += "수"
        else:
            answer += "박"
        print(answer)


if __name__ == '__main__':
    t1 = time.time()
    solution(10000)
    t2 = time.time()
    print(t2 - t1)
