word = input()
word = word.upper()

wordDict = dict()

for wor in word:
    wordDict[wor] = wordDict.get(wor, 0) + 1

maxword = max(wordDict.values())

dupl = False

ans = ''
for word, count in wordDict.items():
    if count == maxword:
        if ans:
            dupl = True
        else:
            ans = word

if dupl:
    print('?')
else:
    print(ans)
