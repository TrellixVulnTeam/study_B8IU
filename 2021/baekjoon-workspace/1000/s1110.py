N = input()

if len(N) < 2:
    M = "0" + N
else:
    M = N

num1 = M[0]
num2 = M[1]
count = 0

while True:
    count += 1
    num3 = str(int(num1) + int(num2))
    num1 = num2[-1]
    num2 = num3[-1]
    if M == num1 + num2:
        break

print(count)
