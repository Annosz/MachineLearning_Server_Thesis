from flask import Flask, request, jsonify
from invalidusage import InvalidUsage
import nn_impl
import json
import numpy as np
import tensorflow as tf

app = Flask(__name__)


@app.route("/train", methods=['GET'])
def train():
    try:
        nn_impl.train_nn(False)
        return "Training started"
    except Exception:
        raise InvalidUsage('Exception during the training process', status_code=500)


@app.route("/model_ready", methods=['GET'])
def model_ready():
    return str(nn_impl.is_model_ready())


@app.route("/predict", methods=['POST'])
def predict():
    test_group = None
    try:
        data = request.get_json()
        test_group = tf.convert_to_tensor(json.loads(data))
    except ValueError:
        raise InvalidUsage('Not a valid json body for predict request', status_code=400)

    try:
        results = nn_impl.predict(test_group)
        return results[0]
    except Exception:
        raise InvalidUsage('Exception during the predicting process', status_code=500)


@app.errorhandler(InvalidUsage)
def handle_invalid_usage(error):
    response = jsonify(error.to_dict())
    response.status_code = error.status_code
    return response


if __name__ == '__main__':
    app.run(debug=True)