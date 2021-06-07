N = input()
numList = list(map(int, input().split()))

print(sum(numList) / max(numList) / len(numList) * 100)
