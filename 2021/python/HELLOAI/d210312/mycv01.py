import cv2
import numpy as np

# 이미지 읽기
img = cv2.imread('3_4.png', 1)

array = []
for i in range(100):
    temparray = []
    for j in range(100):
        temp = [np.unit8(0), np.unit8(0), np.unit8(255)]
        temparray.append(temp)
    array.append(temparray)
img = np.array(array)
print(img, type(img), len(img))

# 이미지 화면에 표시
cv2.imshow('Test Image', img)
cv2.waitKey(0)
# 이미지 윈도우 삭제
cv2.destroyAllWindows()

# 이미지 다른 파일로 저장
cv2.imwrite('test2.png', img)
