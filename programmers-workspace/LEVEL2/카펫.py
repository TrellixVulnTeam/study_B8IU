import math


def solution(brown, yellow):
    yellowList = []
    for i in range(1, math.ceil(yellow / 2) + 1):
        if yellow / i == int(yellow / i):
            if yellow // i >= i:
                yellowList.append([yellow // i, i])
    for i, j in yellowList:
        if brown + yellow == (i + 2) * (j + 2):
            return [i + 2, j + 2]
