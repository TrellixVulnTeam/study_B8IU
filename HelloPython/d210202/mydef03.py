def main():
    result1 = minus(1, 2)
    result2 = multi(2, 3)
    result3 = divide(2, 3)
    min, mul, div = minmuldiv(1, 2)

    print(result1)
    print(result2)
    print(result3)
    print(min, mul, div)


def minus(a, b):
    return a - b


def multi(a, b):
    return a * b


def divide(a, b):
    return a / b


def minmuldiv(a, b):
    return a - b, a * b, a / b


main()
