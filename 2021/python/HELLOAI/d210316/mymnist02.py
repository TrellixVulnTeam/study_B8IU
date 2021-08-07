import tensorflow as tf
import numpy as np
import cv2
import os

# 1. Fashion MNIST 데이터셋 임포트
fashion_mnist = tf.keras.datasets.fashion_mnist
(train_images, train_labels), (test_images, test_labels) = fashion_mnist.load_data()

# 2. 데이터 전처리
train_images, test_images_sec = train_images / 255.0, test_images / 255.0

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
# print(predictions[0])
# print(np.argmax(predictions[0]), test_labels[0])


if not (os.path.isdir('miss')):
    os.makedirs(os.path.join('miss'))

count = 0
for i in range(10000):
    if np.argmax(predictions[i]) != test_labels[i]:
        count += 1
        cv2.imwrite(f'miss/{test_labels[i]}_{np.argmax(predictions[i])}_{i}.jpg', test_images[i])

print(count)

# 테스트 데이터로 정확도 측정하기
test_loss, test_acc = model.evaluate(test_images_sec, test_labels)
print('test_acc: ', test_acc)
