import sys


def isPossible():
    num1, num2 = i // N, i % N
    for atemp in a:
        a1, a2 = atemp // N, atemp % N
        if (a1 == num1 or
                a2 == num2 or
                abs(a1 - num1) == abs(a2 - num2)):
            return False
    return True


if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())

    aList = [[]]
    for _ in range(N - 1):
        bList = []
        for a in aList:
            if len(a) > 0:
                for i in range(a[-1], N ** 2):
                    if i not in a and isPossible():
                        bList.append(a + [i])
            else:
                for i in range(0, N ** 2):
                    if i not in a and isPossible():
                        bList.append(a + [i])
        aList = bList

    count = 0
    for a in aList:
        if len(a) > 0:
            for i in range(a[-1], N ** 2):
                if i not in a and isPossible():
                    count += 1
        else:
            for i in range(0, N ** 2):
                if i not in a and isPossible():
                    count += 1
    sys.stdout.write(str(count) + '\n')
