N = int(input())
strings = []
for _ in range(N):
    strings.append(input())

res = 0
for string in strings:
    strset = set()
    for index, char in enumerate(string):
        if index != 0 and char in strset and string[index - 1] != char:
            break
        strset.add(char)
    else:
        res += 1

print(res)
