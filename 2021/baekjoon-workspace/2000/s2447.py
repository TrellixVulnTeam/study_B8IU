def removeStars(x, y, size):
    if size > 3:
        for i in range(x, x + size, size // 3):
            for j in range(y, y + size, size // 3):
                removeStars(i, j, size // 3)
    for i in range(x + size // 3, x + size // 3 * 2):
        for j in range(y + size // 3, y + size // 3 * 2):
            stars[i][j] = ' '


if __name__ == '__main__':
    N = int(input())
    stars = [['*' for _ in range(N)] for _ in range(N)]
    removeStars(0, 0, N)
    for star in stars:
        print(''.join(star))
