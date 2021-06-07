K = int(input())
numbers = [int(input()) for _ in range(K)]

stack = []

for number in numbers:
    if number == 0:
        stack.pop()
    else:
        stack.append(number)

print(sum(stack))
