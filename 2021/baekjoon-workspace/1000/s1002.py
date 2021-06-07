T = int(input())
location = [list(map(int, input().split())) for _ in range(T)]

for x1, y1, r1, x2, y2, r2 in location:
    d = ((x2 - x1) ** 2 + (y2 - y1) ** 2) ** 0.5

    if x1 == x2 and y1 == y2 and r1 == r2:
        print(-1)
    elif max(r1, r2) - min(r1, r2) < d < r1 + r2:
        print(2)
    elif r1 + r2 == d or max(r1, r2) - min(r1, r2) == d:
        print(1)
    else:
        print(0)