import cv2
import numpy as np

# 이미지 읽기
img = cv2.imread('lena.jpg', 1)

resizeimg = cv2.resize(img, None, fx=0.5, fy=0.5, interpolation=cv2.INTER_AREA)

# 이미지 화면에 표시
cv2.imshow('Test Image', img)
cv2.imshow('resizeimg', resizeimg)
cv2.waitKey(0)
# 이미지 윈도우 삭제
cv2.destroyAllWindows()

# 이미지 다른 파일로 저장
cv2.imwrite('test2.png', img)
