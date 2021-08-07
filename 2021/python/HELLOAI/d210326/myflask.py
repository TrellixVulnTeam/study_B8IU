from flask import Flask, render_template, request
from flask_socketio import SocketIO
import cx_Oracle

conn = cx_Oracle.connect('python/python@localhost:1521/xe')
cur = conn.cursor()

sql = "INSERT INTO TETRIS (LEARN400, ACTION) VALUES(:V_LEARN400, :V_ACTION)"

app = Flask(__name__)
app.config['SECRET_KEY'] = '비밀번호 설정'
socketio = SocketIO(app)


@app.route('/')
def sessions():
    return render_template('tetrisnetwork_ai.html')


@app.route('/saveai', methods=['POST'])
def saveai():
    datasets = request.form['datasets']
    datasets = datasets.split(',')

    for dataset in datasets:
        cur.execute(sql, (dataset[:-1], dataset[-1]))
    conn.commit()

    return "saveai"


def myReceived(methods=['GET', 'POST']):
    print('message was received!!!')


@socketio.on('to_server')
def to_server(json, methods=['GET', 'POST']):
    print('received my event: ' + str(json))
    socketio.emit('to_client', json, callback=myReceived)


if __name__ == '__main__':
    socketio.run(app, host='0.0.0.0', port=9999)
