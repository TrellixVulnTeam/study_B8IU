from collections import deque

T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    documents = deque(map(int, input().split()))
    weights = deque([0 for i in documents])
    weights[M] = 1

    while True:
        if documents[0] != max(documents):
            documents.append(documents.popleft())
            weights.append(weights.popleft())
        else:
            if weights[0] == 1:
                print(N - len(documents) + 1)
                break
            else:
                documents.popleft()
                weights.popleft()
