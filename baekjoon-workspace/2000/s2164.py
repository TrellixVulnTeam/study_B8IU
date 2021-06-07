from collections import deque

N = int(input())

stack = deque([i + 1 for i in range(N)])

while len(stack) != 1:
    stack.popleft()
    stack.append(stack.popleft())

print(stack[0])
