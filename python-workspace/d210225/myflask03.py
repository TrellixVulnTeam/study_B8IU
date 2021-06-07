from flask import Flask, render_template, request

app = Flask(__name__)


@app.route('/render')
def home():
    list = ['홍길동', '전우치', '이순신']
    return render_template('index.html', names=list)


if __name__ == '__main__':
    app.run(debug=True)
