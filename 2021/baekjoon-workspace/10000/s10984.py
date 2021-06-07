T = int(input())
for _ in range(T):
    N = int(input())
    scores = [map(float, input().split()) for _ in range(N)]

    cglist = []
    for C, G in scores:
        cglist.append([C, C * G])

    scoreList = list(zip(*cglist))

    print(int(sum(scoreList[0])), sum(scoreList[1]) / int(sum(scoreList[0])))
