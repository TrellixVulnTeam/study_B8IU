numbers = map(int, input().split())

nums = [number ** 2 for number in numbers]
print(sum(nums) % 10)
