import cv2
import numpy as np

# 이미지 읽기
img = cv2.imread('lena.jpg', 1)
print(img)

# rows, cols = img.shape[:2]
#
# # 이미지의 중심점을 기준으로 90도 회전 하면서 0.5배 Scale
# M = cv2.getRotationMatrix2D((cols / 2, rows / 2), 90, 1)
#
# dst = cv2.warpAffine(img, M, (cols, rows))
#
# cv2.imshow('Original', img)
# cv2.imshow('Rotation', dst)

img90 = cv2.rotate(img, cv2.ROTATE_90_CLOCKWISE)  # 시계방향으로 90도 회전
img180 = cv2.rotate(img, cv2.ROTATE_180)  # 180도 회전
img270 = cv2.rotate(img, cv2.ROTATE_90_COUNTERCLOCKWISE)  # 반시계방향으로 90도 회전
# = 시계방향으로 270도 회전


cv2.imshow('original', img)
cv2.imshow('rotate90', img90)
cv2.imshow('rotate180', img180)
cv2.imshow('rotate270', img270)

cv2.waitKey(0)
# 이미지 윈도우 삭제
cv2.destroyAllWindows()

# 이미지 다른 파일로 저장
cv2.imwrite('img180.png', img180)
