N = int(input())

numbers = [int(input()) for _ in range(N)]
numbers.sort()

big = numbers[-1]
small = numbers[0]

while big % small != 0:
    big, small = small, big % small

print(small)