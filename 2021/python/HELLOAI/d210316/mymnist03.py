import tensorflow as tf
import numpy as np
import cv2
import os
import sys

# 1. Fashion MNIST 데이터셋 임포트
fashion_mnist = tf.keras.datasets.fashion_mnist
(train_images, train_labels), (test_images, test_labels) = fashion_mnist.load_data()

src = cv2.imread('pants.jpg', cv2.IMREAD_GRAYSCALE)
dst = cv2.resize(src, dsize=(28, 28), interpolation=cv2.INTER_AREA)
dst = 255 - dst
cv2.imwrite('2828.jpg', dst)
npArray = np.array([dst])

# 2. 데이터 전처리
train_images, test_images_sec = train_images / 255.0, npArray / 255.0

# 3. 모델 구성
model = tf.keras.models.Sequential([
    tf.keras.layers.Flatten(input_shape=(28, 28)),
    tf.keras.layers.Dense(512, activation='relu'),
    tf.keras.layers.Dense(10, activation='softmax')
])

# 4. 모델 컴파일
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# 5. 모델 훈련
model.fit(train_images, train_labels, epochs=5)

predictions = model.predict(test_images_sec)

print(predictions[0], np.argmax(predictions[0]))
