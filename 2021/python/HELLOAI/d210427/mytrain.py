# 필요한 라이브러리 불러오기
import tensorflow as tf
from keras import models
from keras import layers
import numpy as np

# MNIST 데이터셋 불러오기
train_images = np.load('numpy_x.npy')
train_labels = np.load('numpy_y.npy')

# 이미지 데이터 준비하기 (모델에 맞는 크기로 바꾸고 0과 1사이로 스케일링)
train_images = train_images.reshape((len(train_images), 400))
train_labels = tf.keras.utils.to_categorical(train_labels, num_classes=4, dtype='float32')

# 모델 정의하기 (여기에서는 Sequential 클래스 사용)
model = models.Sequential()
model.add(layers.Dense(512, activation='relu', input_shape=(400,)))
model.add(layers.Dense(4, activation='softmax'))

# 모델 컴파일 하기
model.compile(optimizer='rmsprop',
              loss='categorical_crossentropy',
              metrics=['accuracy'])

# fit() 메서드로 모델 훈련 시키기
model.fit(train_images, train_labels, epochs=200, batch_size=1000)

model.save('tetris.h5')
