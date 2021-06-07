inputs = []
lines = []
temp = []

while True:
    inputString = input()
    if inputString == ".":
        break
    inputs.extend(list(inputString))

for s in inputs:
    if s == "[":
        temp.append(s)
    elif s == "]":
        temp.append(s)
    elif s == "(":
        temp.append(s)
    elif s == ")":
        temp.append(s)
    elif s == ".":
        lines.append(temp)
        temp = []

for line in lines:
    stack = []
    for s in line:
        if s == "[":
            stack.append("[")
        elif s == "]":
            if not stack or "[" != stack.pop():
                print("no")
                break
        elif s == "(":
            stack.append("(")
        elif s == ")":
            if not stack or "(" != stack.pop():
                print("no")
                break
    else:
        if stack:
            print("no")
        else:
            print("yes")
