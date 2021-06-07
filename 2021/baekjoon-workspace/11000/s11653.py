N = int(input())

divnum = 2

while N > 1:
    if not N % divnum:
        N = N // divnum
        print(divnum)
    else:
        divnum += 1
