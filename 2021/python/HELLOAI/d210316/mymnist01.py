import tensorflow as tf
import sys
import cv2
import os

# 1. Fashion MNIST 데이터셋 임포트
fashion_mnist = tf.keras.datasets.fashion_mnist
(train_images, train_labels), (test_images, test_labels) = fashion_mnist.load_data()

if not (os.path.isdir('train')):
    os.makedirs(os.path.join('train'))

for index, image in enumerate(train_images):
    cv2.imwrite(f'train/{train_labels[index]}_{index}.jpg', image)
    print(index)

if not (os.path.isdir('test')):
    os.makedirs(os.path.join('test'))

for index, image in enumerate(test_images):
    cv2.imwrite(f'test/{test_labels[index]}_{index}.jpg', image)
    print(index)

print(len(train_images), len(train_labels), len(test_images), len(test_labels))

sys.exit(1)

# 2. 데이터 전처리
train_images, test_images = train_images / 255.0, test_images / 255.0

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

# 테스트 데이터로 정확도 측정하기
test_loss, test_acc = model.evaluate(test_images, test_labels)
print('test_acc: ', test_acc)
