from collections import deque

N = int(input())
order = [input() for _ in range(N)]
queue = deque()

for o in order:
    if o.startswith("push"):
        queue.append(o.split()[1])
    elif o.startswith("pop"):
        if len(queue) == 0:
            print(-1)
        else:
            print(queue.popleft())
    elif o == "size":
        print(len(queue))
    elif o == "empty":
        print(int(not bool(queue)))
    elif o == "front":
        if len(queue) == 0:
            print(-1)
        else:
            num = queue.popleft()
            print(num)
            queue.appendleft(num)
    elif o == "back":
        if len(queue) == 0:
            print(-1)
        else:
            num = queue.pop()
            print(num)
            queue.append(num)
