def splitmelody(s):
    res = list()
    for c in s:
        if c == "#":
            res[-1] += "#"
        else:
            res.append(c)
    return res


def solution(m, musicinfos):
    answer = '(None)'

    inputlist = splitmelody(m)

    for musicinfo in musicinfos:
        if m in musicinfo.split(',')[3] * 3:
            infolist = splitmelody(musicinfo.split(',')[3]) * 3
            for i in range(len(inputlist)):
                if inputlist[i] not in infolist:
                    break
            else:
                answer = musicinfo.split(',')[2]
    return answer


if __name__ == '__main__':
    print(solution("ABCDEFG", ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]))
    print(solution("CC#BCC#BCC#BCC#B", ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]))
    print(solution("ABC", ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]))
