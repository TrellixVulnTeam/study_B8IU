from flask import Flask, render_template, request, jsonify
import tensorflow as tf
import numpy as np

app = Flask(__name__, static_url_path="", static_folder="static")
model = tf.keras.models.load_model("tetris.h5")


@app.route('/')
def home():
    return render_template('tetris.html')


@app.route('/ajax', methods=['POST'])
def ajax():
    learn400 = [list(request.form['learn400'])]
    learn400 = np.array(learn400, dtype=np.float32)
    predict = model.predict(learn400)
    return jsonify({'action': str(np.argmax(predict))})


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
