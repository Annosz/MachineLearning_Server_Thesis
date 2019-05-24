import os
from flask import Flask, request, jsonify
from werkzeug.utils import secure_filename
import livepoly
from invalidusage import InvalidUsage

TRAIN_FOLDER = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'train_imgs')
TEST_FOLDER = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'test_imgs')
ALLOWED_EXTENSIONS = set(['png'])

app = Flask(__name__)
app.config['TRAIN_FOLDER'] = TRAIN_FOLDER
app.config['TEST_FOLDER'] = TEST_FOLDER


@app.route("/train_imgs", methods=['GET', 'POST', 'DELETE'])
def train_imgs():
    if request.method == 'GET':
        return jsonify(os.listdir(app.config['TRAIN_FOLDER']))
    if request.method == 'DELETE':
        for file in os.listdir(app.config['TRAIN_FOLDER']):
            os.remove(os.path.join(app.config['TRAIN_FOLDER'], file))
    if request.method == 'POST':
        if 'image' not in request.files:
            raise InvalidUsage('No file found in the message', status_code=400)
        image = request.files['image']
        if image.filename == '':
            raise InvalidUsage('File is empty or unnamed', status_code=422)
        if image and allowed_file(image.filename):
            filename = secure_filename(image.filename)
            image.save(os.path.join(app.config['TRAIN_FOLDER'], filename))
    return "OK"


@app.route("/train", methods=['GET', 'POST'])
def train():
    if request.method == 'POST':
        if 'image' not in request.files:
            raise InvalidUsage('No file found in the message', status_code=400)
        image = request.files['image']
        if image.filename == '':
            raise InvalidUsage('File is empty or unnamed', status_code=422)
        if image and allowed_file(image.filename):
            filename = secure_filename(image.filename)
            image.save(os.path.join(app.config['UPLOAD_FOLDER'], filename))

    try:
        livepoly.train()
        return "OK"
    except Exception:
        raise InvalidUsage('Exception during the training process', status_code=500)



@app.errorhandler(InvalidUsage)
def handle_invalid_usage(error):
    response = jsonify(error.to_dict())
    response.status_code = error.status_code
    return response


def allowed_file(filename):
    return '.' in filename and \
           filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS


if __name__ == '__main__':
    app.run(debug=True)
