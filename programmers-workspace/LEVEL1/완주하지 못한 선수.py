def solution(participant, completion):
    completion.append('')
    participant.sort(reverse=True)
    completion.sort(reverse=True)
    ziplist = list(zip(participant, completion))
    for i, j in ziplist:
        if i != j:
            return i
