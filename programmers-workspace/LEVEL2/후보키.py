from pandas import DataFrame

def solution(relation):
    answer = 0

    pdarr = DataFrame(relation)
    print(pdarr)
    for i in pdarr:
        for j in pdarr[i]:
            if pdarr[i].tolist().count(j) > 1:
                print(pdarr[i].tolist())
                break
        else:
            answer += 1
    return answer


if __name__ == '__main__':
    relation = [["100", "ryan", "music", "2"], ["200", "apeach", "math", "2"], ["300", "tube", "computer", "3"], ["400", "con", "computer", "4"], ["500", "muzi", "music", "3"], ["600", "apeach", "music", "2"]]
    print(solution(relation))
