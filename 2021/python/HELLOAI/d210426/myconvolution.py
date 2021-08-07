import cv2
import numpy as np

STRID = 2

img = cv2.imread('lena.jpg', cv2.IMREAD_COLOR)
img_g = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

filterarr = [[1, 1],
             [1, 1]]
npfilterarr = np.array(filterarr, dtype=np.uint8)

resarr = []
for i in range(0, len(img_g) - len(filterarr) + 1, STRID):
    temp = []
    for j in range(0, len(img_g) - len(filterarr[0]) + 1, STRID):
        temp.append(round(np.sum(img_g[i:i + len(filterarr), j:j + len(filterarr[0])] * npfilterarr) / 4))
    resarr.append(temp)
npresarr = np.array(resarr, dtype=np.uint8)

cv2.imshow('img_g', img_g)
cv2.imshow('npresarr', npresarr)
cv2.waitKey(0)

cv2.destroyAllWindows()
