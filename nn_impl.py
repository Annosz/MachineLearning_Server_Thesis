import tensorflow as tf
from tensorflow import keras
import numpy as np
import matplotlib.pyplot as plt


def create_model(lr):

    #model = keras.Sequential([
    #    keras.layers.Conv3D(input_shape=(12, 1200, 700, 1), data_format='channels_last'),
    #    keras.layers.Dense(128, activation=tf.nn.relu),
    #    keras.layers.Dense(1, activation='linear')
    #])

    model = keras.Sequential()
    model.add(keras.layers.Conv3D(32, kernel_size=(3, 3, 3), activation='relu', padding='same', input_shape=(1, 1200, 700, 1)))
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