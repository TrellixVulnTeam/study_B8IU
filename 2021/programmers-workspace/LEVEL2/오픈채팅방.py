def solution(record: list):
    memberDict = dict()
    status = list()

    for rec in record:
        reco = rec.split(' ')
        if reco[0] == 'Enter':
            memberDict[reco[1]] = reco[2]
            status.append(Status(reco[1], "님이 들어왔습니다."))
        elif reco[0] == 'Change':
            memberDict[reco[1]] = reco[2]
        elif reco[0] == 'Leave':
            status.append(Status(reco[1], "님이 나갔습니다."))

    answer = list()
    for stat in status:
        answer.append(memberDict[stat.member] + stat.status)

    return answer


class Status:
    def __init__(self, member, status):
        self.member = member
        self.status = status
