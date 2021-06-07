def solution(answers):
    answer = []
    supo1 = [1, 2, 3, 4, 5]
    supo2 = [2, 1, 2, 3, 2, 4, 2, 5]
    supo3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    supo1_correct = 0
    supo2_correct = 0
    supo3_correct = 0

    for i in range(len(answers)):
        if supo1[i % len(supo1)] == answers[i]:
            supo1_correct += 1
        if supo2[i % len(supo2)] == answers[i]:
            supo2_correct += 1
        if supo3[i % len(supo3)] == answers[i]:
            supo3_correct += 1
    max_correct = max(supo1_correct, supo2_correct, supo3_correct)
    if supo1_correct == max_correct:
        answer.append(1)
    if supo2_correct == max_correct:
        answer.append(2)
    if supo3_correct == max_correct:
        answer.append(3)
    return answer
