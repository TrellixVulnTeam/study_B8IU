N = int(input())
numbers = [map(int, input().split()) for _ in range(N)]
for num1, num2 in numbers:
    big = max(num1, num2)
    small = min(num1, num2)

    while big % small != 0:
         big, small = small, big % small

    print(num1 * num2 // small)
