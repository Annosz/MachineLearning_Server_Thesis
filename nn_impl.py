import cv2
import tensorflow as tf
from tensorflow import keras
import pandas as pd
import matplotlib.pyplot as plt

from itertools import compress


TRAIN_FOLDER = "C:\\Users\\Annosz\\Documents\\GitHub\\MachineLearning_Server_Thesis\\train\\"
DATA_FOLDER = "C:\\Users\\Annosz\\Documents\\GitHub\\MachineLearning_Server_Thesis\\data\\"

IMG_HEIGHT = 250
IMG_WIDTH = 50


def create_model(lr):

    model = keras.Sequential()
    model.add(keras.layers.Conv3D(32, kernel_size=(3, 3, 3), activation='relu', padding='same', input_shape=(1, IMG_HEIGHT, IMG_WIDTH, 1)))
    model.add(keras.layers.Conv3D(32, kernel_size=(3, 3, 3), activation='relu', padding='same'))
    model.add(keras.layers.MaxPooling3D(pool_size=(2, 2, 1), padding='same'))
    model.add(keras.layers.Dropout(0.25))
    model.add(keras.layers.Conv3D(64, kernel_size=(3, 3, 3), activation='relu', padding='same'))
    model.add(keras.layers.Conv3D(64, kernel_size=(3, 3, 3), activation='relu', padding='same'))
    model.add(keras.layers.MaxPooling3D(pool_size=(2, 2, 1), padding='same'))
    model.add(keras.layers.Dropout(0.25))
    model.add(keras.layers.Flatten())
    model.add(keras.layers.Dense(256, activation='relu'))
    model.add(keras.layers.Dense(1, activation='linear'))

    model.compile(optimizer='adam',
                  loss='mean_squared_error',
                  metrics=['mse'])

    return model


def train_nn(testing):
    df = pd.read_csv(DATA_FOLDER + 'WeightFromScale.txt', delimiter='\t', decimal=",")

    train_labels = df["WeightFromScale [g]"].diff()

    train_groups = []
    shape_mask = []
    last_frame_num = 1
    for i in df["FrameNumber"]:
        train_imgs = []

        for j in range(last_frame_num, i):
            # originally 1200x700 pixels
            image = cv2.imread(TRAIN_FOLDER + "frame%d.jpg" % j)
            image_cropped = image[100:1100, 250:450]
            image = cv2.resize(image_cropped, (IMG_WIDTH, IMG_HEIGHT))
            grayscale = cv2.cvtColor(image, cv2.COLOR_RGB2GRAY)
            # if j is 85:
            #    plt.imshow(grayscale, cmap='gray')
            #    plt.show()
            reshaped = grayscale.reshape(1, IMG_HEIGHT, IMG_WIDTH, 1)
            train_imgs.append(tf.convert_to_tensor(reshaped))

        train_groups.append(tf.reshape(train_imgs, (len(train_imgs), 1, IMG_HEIGHT, IMG_WIDTH, 1)))
        shape_mask.append(len(train_imgs) == 12)
        last_frame_num = i

    dataset = tf.data.Dataset.from_tensor_slices(
        (list(compress(train_groups, shape_mask)), train_labels[shape_mask]))

    model = create_model(0.1)

    if testing:
        history = model.fit(dataset, epochs=100, steps_per_epoch=1, validation_split=0.2)

        print(history.history.keys())
        # "Loss"
        plt.plot(history.history['loss'])
        plt.plot(history.history['val_loss'])
        plt.title('model loss')
        plt.ylabel('loss')
        plt.xlabel('epoch')
        plt.legend(['train', 'validation'], loc='upper left')
        plt.show()

    else:
        model.fit(dataset, epochs=100, steps_per_epoch=1)