a = input("출력할 구구단은? ex) 2 ~ 9\n")

for i in range(1, 10):
    print(a + " * " + str(i) + " = " + str(int(a) * i))
