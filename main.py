import nn_impl
import tensorflow as tf
import matplotlib.pyplot as plt
import time

if __name__ == '__main__':
    #nn_impl.train_nn(True)

    test_groups, weight_labels, time_labels = nn_impl.get_picture_data(10)
    weight_labels = weight_labels.tolist()
    time_labels = time_labels.tolist()

    model = tf.keras.models.load_model(nn_impl.MODEL_FOLDER + "PharmaNN")

    prediction_times = []
    predictions = []
    weights = []
    start = time.time()
    for i in range(0, len(time_labels)):
        if i == 0:
            predictions.append(nn_impl.predict(test_groups[0], model)[0])
            weights.append(weight_labels[1])
        else:
            predictions.append(predictions[i-1] + nn_impl.predict(test_groups[i], model)[0])
            weights.append(weights[i - 1] + weight_labels[i])
        prediction_times.append(time.time() - start)

    plt.plot(time_labels, weights, color='blue', linewidth=2)
    plt.plot(prediction_times, predictions, color='red', linewidth=2)
    plt.ylabel('Weight')
    plt.xlabel('Time')
    plt.show()
