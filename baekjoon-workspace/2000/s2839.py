N = int(input())

k5 = N // 5
k3 = (N % 5) // 3

while not k5 * 5 + k3 * 3 == N:
    if k5 == 0:
        print(-1)
        exit()
    k5 -= 1
    k3 = (N - k5 * 5) // 3

print(k5 + k3)
