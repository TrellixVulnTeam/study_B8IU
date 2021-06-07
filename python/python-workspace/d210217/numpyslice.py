import numpy as np

aList = [(1, 2, 3), (2, 2, 3), (3, 2, 3), (4, 2, 3), (5, 2, 3)]

npList = np.array(aList)

print(npList[0:, 0:])
print(npList[:, 2:3])
