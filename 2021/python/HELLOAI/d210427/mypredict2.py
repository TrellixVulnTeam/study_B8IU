# 필요한 라이브러리 불러오기
import tensorflow as tf
import numpy as np

# MNIST 데이터셋 불러오기
train_images = np.load('numpy_x.npy')
train_labels = np.load('numpy_y.npy')

# 이미지 데이터 준비하기 (모델에 맞는 크기로 바꾸고 0과 1사이로 스케일링)
train_images = train_images.reshape((len(train_images), 400))

model = tf.keras.models.load_model("tetris.h5")

predictions = model.predict(train_images)

count = 0

for predict, label in zip(predictions, train_labels):
    if np.argmax(predict) == np.argmax(label):
        count += 1

print('맞은 개수 :', count)
print('틀린 개수 :', len(train_images) - count)
