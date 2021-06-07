from collections import deque

N, M = map(int, input().split())
pos = map(int, input().split())

que = deque([i+1 for i in pos])
