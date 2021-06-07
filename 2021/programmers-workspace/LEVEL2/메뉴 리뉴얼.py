import itertools


def solution(orders, course):
    answer = []
    for c in course:
        orderList = []
        orderDict = dict()
        for order in orders:
            orderList.extend(itertools.combinations(sorted(order), c))
        for order in orderList:
            if orderList.count(order) in orderDict:
                orderDict[orderList.count(order)].add(order)
                continue
            orderDict[orderList.count(order)] = {order}
        if orderDict and max(orderDict) > 1:
            answer.extend(list("".join(i) for i in orderDict[max(orderDict)]))
    answer.sort()

    return answer


if __name__ == '__main__':
    orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
    course = [2, 3, 4]
    print(solution(orders, course))

    orders = ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]
    course = [2, 3, 5]
    print(solution(orders, course))

    orders = ["XYZ", "XWY", "WXA"]
    course = [2, 3, 4]
    print(solution(orders, course))
