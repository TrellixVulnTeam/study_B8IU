def solution(people, limit):
    answer = 0
    people.sort()

    cnt_l = 0
    cnt_r = len(people) - 1

    while not cnt_l > cnt_r:
        answer += 1
        cnt = people[cnt_r]
        cnt_r -= 1
        while True:
            if cnt + people[cnt_r] > limit:
                break
            else:
                cnt += people[cnt_r]
                cnt_r -= 1
        while True:
            if cnt + people[cnt_l] > limit:
                break
            else:
                cnt += people[cnt_l]
                cnt_l += 1

    return answer
