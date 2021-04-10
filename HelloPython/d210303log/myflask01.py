from flask import Flask
from d210303log.mylog import MyLog

mylog = MyLog()

app = Flask(__name__)


@app.route('/h1')
def h1():
    mylog.logger.info("h1")
    return 'h1'


@app.route('/h2')
def h2():
    mylog.logger.info("h2")
    return 'h2'


if __name__ == '__main__':
    app.run(debug=True)
