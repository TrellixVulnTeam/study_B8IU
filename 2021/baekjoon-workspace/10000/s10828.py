N = int(input())
orders = [input() for _ in range(N)]

stack = []

for order in orders:
    if order.startswith("push"):
        stack.append(order.split()[1])
    elif order == "size":
        print(len(stack))
    elif order == "empty":
        print(int(len(stack) == 0))
    else:
        if stack:
            if order == "pop":
                print(stack.pop())
            if order == "top":
                print(stack[-1])
        else:
            print(-1)
