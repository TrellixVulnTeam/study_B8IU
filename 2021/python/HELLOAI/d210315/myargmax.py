import tensorflow as tf
import numpy as np

arr = [1, 2, 3, 2, 1]

n_arr = np.array(arr)

print(tf.argmax(arr), type(tf.argmax(arr)))
print(tf.argmax(n_arr))
print(np.argmax(arr), type(np.argmax(arr)))
print(np.argmax(n_arr))

