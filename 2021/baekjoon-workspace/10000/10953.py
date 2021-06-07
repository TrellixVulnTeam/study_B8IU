N = int(input())
numbers = [sum(map(int, input().split(','))) for _ in range(N)]

for number in numbers:
    print(number)
