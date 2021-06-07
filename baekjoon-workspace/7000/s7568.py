N = int(input())
people = [tuple(map(int, input().split())) for _ in range(N)]
result = []

for x1, y1 in people:
    count = 1
    for x2, y2 in people:
        if x2 > x1 and y2 > y1:
            count += 1
    result.append(str(count))

print(" ".join(result))
