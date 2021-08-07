import tensorflow as tf
import numpy as np
import cv2
import os
import sys

# 1. Fashion MNIST 데이터셋 임포트

src = cv2.imread('pants.jpg', cv2.IMREAD_GRAYSCALE)
dst = cv2.resize(src, dsize=(1, 28, 28), interpolation=cv2.INTER_AREA)
dst = 255 - dst

# 2. 데이터 전처리
test_images_sec = dst / 255.0

model = tf.keras.models.load_model("mnist_model.h5")

predictions = model.predict(test_images_sec)

print(predictions[0], np.argmax(predictions[0]))
