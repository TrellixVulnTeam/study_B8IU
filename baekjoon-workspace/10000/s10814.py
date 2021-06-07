N = int(input())

agenames = []
for i in range(N):
    age, name = input().split()
    agenames.append([int(age), i, name])

agenames.sort()

for age, ord, name in agenames:
    print(age, name)
