import nn_impl
import tensorflow as tf
import matplotlib.pyplot as plt
import time
import datetime
import matplotlib.dates as mdates
import requests
import json


def get_local_prediction(test_group):
    return nn_impl.predict(test_group)[0]


def get_remote_prediction(test_group):
    sess = tf.InteractiveSession()
    return requests.post("http://127.0.0.1:5000/predict", json=json.dumps(test_group.eval().tolist()))


if __name__ == '__main__':
    #nn_impl.train_nn(False)
    #requests.get("http://127.0.0.1:5000/train")

    test_groups, weight_labels, time_labels = nn_impl.get_picture_data()
    weight_labels = weight_labels.tolist()
    time_labels = time_labels.tolist()

    # specify a date to use for the times
    zero = datetime.datetime(2019, 5, 17)
    times = [zero + t for t in time_labels]
    # convert datetimes to numbers
    zero = mdates.date2num(zero)
    time_labels = [(t - zero)*100000 for t in mdates.date2num(times)]

    model = tf.keras.models.load_model(nn_impl.MODEL_FOLDER + "PharmaNN")

    prediction_times = []
    predictions = []
    weights = []
    start = time.time()
    for i in range(0, len(time_labels)):
        while (time.time() - start) < time_labels[i]:
            time.sleep(0.001)

        prediction = get_local_prediction(test_groups[i])

        # prediction = get_remote_prediction(test_groups[i])
        # prediction = float(prediction.text)

        if i == 0:
            predictions.append(prediction)
            weights.append(weight_labels[1])
        else:
            predictions.append(predictions[i-1] + prediction)
            weights.append(weights[i - 1] + weight_labels[i])

        prediction_times.append(time.time() - start)

    plt.plot(time_labels, weights, color='blue', linewidth=2)
    plt.plot(prediction_times, predictions, color='red', linewidth=2)
    plt.legend(['Weight from scale', 'Weight from server'], loc='upper left')
    plt.ylabel('Weight [g]')
    plt.xlabel('Time [s]')
    plt.show()

