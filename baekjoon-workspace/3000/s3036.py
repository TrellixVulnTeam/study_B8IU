N = int(input())
numbers = list(map(int, input().split()))
firstnumber = numbers[0]

for number in numbers[1:]:
    num1 = max(firstnumber, number)
    num2 = min(firstnumber, number)
    while num1 % num2 != 0:
        num1, num2 = num2, num1 % num2

    print(firstnumber // num2, end="")
    print("/", end="")
    print(number // num2)
