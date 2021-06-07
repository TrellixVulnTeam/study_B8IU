import math

T = int(input())
hotelList = list()

for _ in range(T):
    hotelList.append(list(map(int, input().split())))

for H, W, N in hotelList:
    floor = (N - 1) % H + 1
    room = math.ceil(N / H)
    print("%d%2s" % (floor, str(room).zfill(2)))
