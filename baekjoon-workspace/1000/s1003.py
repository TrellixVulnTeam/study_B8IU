def fibonacci(num):
    if fibonacciDict.get(num, False):
        return fibonacciDict[num]

    if not num:
        fibonacciDict[num] = 1, 0
        return 1, 0
    elif num == 1:
        fibonacciDict[num] = 0, 1
        return 0, 1
    else:
        f_1 = fibonacci(num - 1)
        f_2 = fibonacci(num - 2)
        fibonacciDict[num] = f_1[0] + f_2[0], f_1[1] + f_2[1]
        return f_1[0] + f_2[0], f_1[1] + f_2[1]


if __name__ == '__main__':
    count = int(input())
    fibonacciDict = dict()
    for input_num in [int(input()) for _ in range(count)]:
        cnt_0, cnt_1 = fibonacci(input_num)
        print(cnt_0, cnt_1)
