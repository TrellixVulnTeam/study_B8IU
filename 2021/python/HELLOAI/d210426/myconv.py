import numpy as np

STRID = 2

arr = [[0, 1, 1, 0],
       [0, 1, 1, 0],
       [0, 1, 1, 0],
       [0, 1, 1, 0]]
nparr = np.array(arr)

filterarr = [[1, 1],
             [1, 1]]
npfilterarr = np.array(filterarr)

resarr = []
for i in range(0, len(nparr) - len(filterarr) + 1, STRID):
    temp = []
    for j in range(0, len(nparr) - len(filterarr[0]) + 1, STRID):
        temp.append(np.sum(nparr[i:i + len(filterarr), j:j + len(filterarr[0])] * npfilterarr))
    resarr.append(temp)
npresarr = np.array(resarr)

print(npresarr)
