if __name__ == '__main__':
    N, M = map(int, input().split())
    cardList = list(map(int, input().split()))
    sumList = []
    for i in range(N):
        for j in range(i + 1, N):
            for k in range(j + 1, N):
                if cardList[i] + cardList[j] + cardList[k] <= M:
                    sumList.append(cardList[i] + cardList[j] + cardList[k])
    print(max(sumList))
