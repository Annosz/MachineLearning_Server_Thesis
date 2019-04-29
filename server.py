from flask import Flask, request, jsonify
import pandas as pd
import adviewcount
from invalidusage import InvalidUsage
import threading

app = Flask(__name__)


@app.route("/train", methods=['GET', 'POST'])
def train():
    df = None
    n_estimators = request.args.get('n_estimators')
    learning_rate = request.args.get('learning_rate')
    max_depth = request.args.get('max_depth')
    if request.method == 'POST':
        try:
            data = request.get_json()
            print(data)
            df = pd.read_json(data, orient="records")
            if df.empty:
                raise InvalidUsage('Empty json received as train data', status_code=400)
        except ValueError:
            raise InvalidUsage('Not a valid json body for train request', status_code=400)
    try:
        trainingThread = threading.Thread(target=adviewcount.train_ml, args=(df, False, n_estimators, learning_rate, max_depth))
        trainingThread.start()
        # adviewcount.train_ml(df, use_tf=False, n_estimators=n_estimators, learning_rate=learning_rate, max_depth=max_depth)
        return "Training started"
    except Exception:
        raise InvalidUsage('Exception during the training process', status_code=500)


@app.route("/model_ready", methods=['GET'])
def model_ready():
    return str(adviewcount.model_ready)


@app.route("/predict", methods=['GET', 'POST'])
def predict():
    df_test = None
    if request.method == 'POST':
        try:
            data = request.get_json()
            df_test = pd.read_json(data, orient="records")
            if df_test.empty:
                raise InvalidUsage('Empty json received as test data', status_code=400)
        except ValueError:
            raise InvalidUsage('Not a valid json body for predict request', status_code=400)

    try:
        results = adviewcount.predict_ml(df_test)
        return results.to_json(orient="records")
    except Exception:
        raise InvalidUsage('Exception during the predicting process', status_code=500)


@app.errorhandler(InvalidUsage)
def handle_invalid_usage(error):
    response = jsonify(error.to_dict())
    response.status_code = error.status_code
    return response


if __name__ == '__main__':
    app.run(debug=True)
