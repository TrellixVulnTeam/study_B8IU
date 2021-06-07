N, K = map(int, input().split())
members = [i + 1 for i in range(N)]
res = []
position = -1

while members:
    position = (position + K) % len(members)
    res.append(members.pop(position))
    position -= 1

print("<" + str(res)[1:-1] + ">")
