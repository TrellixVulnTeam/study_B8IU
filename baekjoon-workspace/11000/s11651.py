N = int(input())
xy = [tuple(reversed(list(map(int, input().split())))) for _ in range(N)]

xy.sort()

for y, x in xy:
    print(x, y)
