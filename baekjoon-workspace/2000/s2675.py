N = int(input())
mxList = []

for _ in range(N):
    mxList.append(input().split())

for index, string in mxList:
    for c in string:
        print(c * int(index), end='')
    print()
