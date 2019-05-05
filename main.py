from HelperClasses import SampleDataParser
import nn_impl

import pandas as pd
import numpy as np
import cv2
import tensorflow as tf
import matplotlib.pyplot as plt

TRAIN_FOLDER = "C:\\Users\\Annosz\\Documents\\GitHub\\MachineLearning_Server_Thesis\\train\\"
DATA_FOLDER = "C:\\Users\\Annosz\\Documents\\GitHub\\MachineLearning_Server_Thesis\\data\\"

if __name__ == '__main__':
    #SampleDataParser.FramesToTrainImages()

    df = pd.read_csv(DATA_FOLDER + 'WeightFromScale.txt', delimiter='\t', decimal=",")

    train_labels = df["WeightFromScale [g]"].diff()

    train_groups = []
    last_frame_num = 1
    for i in df["FrameNumber"][:70]:
        train_imgs = []
        for j in range(last_frame_num, i):
            image = cv2.imread(TRAIN_FOLDER + "frame%d.jpg" % j)
            grayscale = cv2.cvtColor(image, cv2.COLOR_RGB2GRAY)
            #if j is 85:
            #    plt.imshow(grayscale, cmap='gray')
            #    plt.show()
            reshaped = grayscale.reshape(1, 1200, 700, 1)
            train_imgs.append(tf.convert_to_tensor(reshaped))
        train_groups.append(tf.reshape(train_imgs, (len(train_imgs), 1, 1200, 700, 1)))
        last_frame_num = i

    model = nn_impl.create_model(0.1)
    model.fit(train_groups[12:70], train_labels[12:70], epochs=100, steps_per_epoch=100)

