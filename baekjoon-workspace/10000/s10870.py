def fibonacci(num):
    if not num:
        return 0
    if num == 1:
        return 1
    return fibonacci(num - 2) + fibonacci(num - 1)


if __name__ == '__main__':
    n = int(input())
    print(fibonacci(n))
