a = input("시작 수 ( 큰 수 ) : ")
b = input("끝 수 ( 작은 수 ) : ")

# for i in range(int(a), int(b) - 1, -1):
#     print(i)

for i in reversed(range(int(b), int(a) + 1)):
    print(i)
