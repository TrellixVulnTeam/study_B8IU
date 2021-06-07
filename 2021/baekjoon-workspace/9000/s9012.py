T = int(input())

PS = [input() for _ in range(T)]

for xx in PS:
    stack = []
    for x in xx:
        if x == "(":
            stack.append("(")
        elif x == ")":
            if not stack:
                print("NO")
                break
            else:
                stack.pop()
    else:
        if stack:
            print("NO")
        else:
            print("YES")
