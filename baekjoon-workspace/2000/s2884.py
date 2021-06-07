A, B = map(int, input().split())

B -= 45
if B < 0:
    B += 60
    A -= 1

if A < 0:
    A += 24

print(A, B)
