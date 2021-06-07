def solution(n, t, m, p):
    aList = ['0']
    number = 1
    while len(aList) < m * t + p:
        temp = number
        tempList = []
        while temp:
            tempList.append(temp % n)
            temp = temp // n
        tempList.reverse()
        for i in range(0, len(tempList)):
            if tempList[i] == 10:
                tempList[i] = 'A'
            elif tempList[i] == 11:
                tempList[i] = 'B'
            elif tempList[i] == 12:
                tempList[i] = 'C'
            elif tempList[i] == 13:
                tempList[i] = 'D'
            elif tempList[i] == 14:
                tempList[i] = 'E'
            elif tempList[i] == 15:
                tempList[i] = 'F'
            else:
                tempList[i] = str(tempList[i])
        aList.extend(tempList)
        number += 1

    answer = ''
    pointer = p - 1
    while pointer < len(aList) and len(answer) < t:
        answer += aList[pointer]
        pointer += m

    return answer
