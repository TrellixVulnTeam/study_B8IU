'''
Created on 2021. 3. 15.

@author: PC16
'''

import cv2
import numpy as np

arr = [
    [0, 0, 0, 0, 255, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 255, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 255, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 255, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 255, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 255, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 255, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 255, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 255, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 255, 0, 0, 0, 0, 0],
]

n_arr = np.array(arr)
print(arr)
print(n_arr)

cv2.imwrite('susja.png', n_arr)


