import numpy as np
import matplotlib.pyplot as plt
import tensorflow as tf
from tensorflow import keras
from tensorflow.keras import datasets, layers, models


def plot_value_array(i, predictions_array, true_label):
    cifar10 = datasets.cifar10
    (train_images, train_labels), (test_images, test_labels) = cifar10.load_data()

    class_names = ['airplane', 'automobile', 'bird', 'cat', 'deer', 'dog', 'frog', 'horse', 'ship', 'truck']

    print("Train samples:", train_images.shape, train_labels.shape)
    print("Test samples:", test_images.shape, test_labels.shape)

    train_images = train_images.reshape((50000, 32, 32, 3))
    test_images = test_images.reshape((10000, 32, 32, 3))

    predictions_array, true_label = predictions_array[i], true_label[i]
    plt.grid(False)
    plt.xticks([])
    plt.yticks([])
    thisplot = plt.bar(range(10), predictions_array, color="#777777")
    plt.ylim([0, 1])
    predicted_label = np.argmax(predictions_array)

    thisplot[predicted_label].set_color('red')
    thisplot[true_label[0]].set_color('blue')


if __name__ == '__main__':
    cifar10 = datasets.cifar10
    (train_images, train_labels), (test_images, test_labels) = cifar10.load_data()

    class_names = ['airplane', 'automobile', 'bird', 'cat', 'deer', 'dog', 'frog', 'horse', 'ship', 'truck']

    print("Train samples:", train_images.shape, train_labels.shape)
    print("Test samples:", test_images.shape, test_labels.shape)

    train_images = train_images.reshape((50000, 32, 32, 3))
    test_images = test_images.reshape((10000, 32, 32, 3))

    plt.figure(figsize=(10, 10))
    for i in range(25):
        plt.subplot(5, 5, i + 1)
        plt.xticks([])
        plt.yticks([])
        plt.grid(False)
        plt.imshow(train_images[i])
        plt.xlabel(class_names[train_labels[i][0]])
    plt.show()

    train_images = train_images / 255.0
    test_images = test_images / 255.0

    model = tf.keras.models.load_model("cnn.h5")

    test_loss, test_acc = model.evaluate(test_images, test_labels)

    print('Test accuracy:', test_acc)

    predictions = model.predict(test_images)

    i = 0
    plt.figure(figsize=(6, 3))
    plt.subplot(1, 2, 1)
    plt.subplot(1, 2, 2)
    plot_value_array(i, predictions, test_labels)
    plt.show()
