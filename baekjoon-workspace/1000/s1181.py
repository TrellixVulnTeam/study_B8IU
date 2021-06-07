N = int(input())
words = [input() for _ in range(N)]
worddict = dict()

for word in words:
    try:
        worddict[len(word)].append(word)
    except:
        worddict[len(word)] = [word]

wordsList = list(worddict.items())
wordsList.sort()

for _, i in wordsList:
    i = list(set(i))
    i.sort()
    for j in i:
        print(j)
