N = int(input())

honeycomb = 1

multiplier = 0

while honeycomb < N:
    multiplier += 1
    honeycomb += 6 * multiplier

print(multiplier + 1)
