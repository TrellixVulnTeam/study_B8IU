import numpy as np
data = np.load('x_train.npy')

for i in data:
    print("============================================================================================================")
    for j in i:
        print(j)
