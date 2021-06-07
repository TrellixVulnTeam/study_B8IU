import tensorflow as tf 
from keras import models
from keras.utils import multi_gpu_model

model = models.Sequential()
model = multi_gpu_model(model, gpus=2)