def solution(files):
    answer = []
    for j in range(len(files)):
        file = files[j]
        tempArr = []
        temp = ""
        for i in range(len(file)):
            if not file[i].isnumeric() and not temp.isnumeric():
                temp += file[i]
            elif file[i].isnumeric() and not temp.isnumeric():
                tempArr.append(temp.lower())
                tempArr.append(temp)
                temp = file[i]
            elif file[i].isnumeric() and temp.isnumeric():
                temp += file[i]
            elif not file[i].isnumeric() and temp.isnumeric():
                tempArr.insert(1, int(temp))
                tempArr.append(temp)
                tempArr.append(file[i:])
                tempArr.insert(2, j)
                break
        else:
            tempArr.insert(1, int(temp))
            tempArr.append(temp)
            tempArr.append("")
            tempArr.insert(2, j)

        answer.append(tempArr)
    answer.sort()
    answer = ["".join(map(str, ans[3:])) for ans in answer]
    return answer


if __name__ == '__main__':
    print(solution(["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]))
    print(solution(["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]))
