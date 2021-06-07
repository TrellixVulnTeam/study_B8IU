from collections import deque

N = int(input())
orders = [input() for _ in range(N)]
deq = deque()

for o in orders:
    if o.startswith("push_front"):
        deq.appendleft(o.split()[1])
    elif o.startswith("push_back"):
        deq.append(o.split()[1])
    elif o == "size":
        print(len(deq))
    elif o == "empty":
        print(int(not bool(deq)))
    else:
        if not deq:
            print(-1)
        elif o == "pop_front":
            print(deq.popleft())
        elif o == "pop_back":
            print(deq.pop())
        elif o == "front":
            print(deq[0])
        elif o == "back":
            print(deq[-1])
