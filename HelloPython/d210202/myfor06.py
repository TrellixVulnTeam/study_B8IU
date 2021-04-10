a = input("a = ")
b = input("b = ")

print(a + "에서 " + b + "까지 합은")

sumnum = int(b)
for i in range(int(a), int(b)):
    sumnum += i

print(sumnum)
