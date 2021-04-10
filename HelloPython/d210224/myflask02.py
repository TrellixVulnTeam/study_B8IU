from flask import Flask, request

app = Flask(__name__)


@app.route('/')
@app.route('/home')
def home():
    return 'Hello, World!'


@app.route('/hello')
def user():
    dan = request.args.get('dan', "1")

    result = f'''<h3>{dan}단</h3>
    {dan} * 1 = {int(dan) * 1}<br>
    {dan} * 2 = {int(dan) * 2}<br>
    {dan} * 3 = {int(dan) * 3}<br>
    {dan} * 4 = {int(dan) * 4}<br>
    {dan} * 5 = {int(dan) * 5}<br>
    {dan} * 6 = {int(dan) * 6}<br>
    {dan} * 7 = {int(dan) * 7}<br>
    {dan} * 8 = {int(dan) * 8}<br>
    {dan} * 9 = {int(dan) * 9}'''

    return result


if __name__ == '__main__':
    app.run(debug=True)
