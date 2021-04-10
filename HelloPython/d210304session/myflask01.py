from datetime import timedelta
from flask import Flask, session, escape

app = Flask(__name__)
app.secret_key = "secret"


@app.before_request
def make_session_permanent():
    session.permanent = True
    app.permanent_session_lifetime = timedelta(minutes=1)


@app.route('/')
@app.route('/show')
def session_show():
    print(session)
    if "user_id" in session:
        return "Logged in as %s " % escape(session["user_id"])
    else:
        return "You are not logged in"


@app.route('/in')
def session_in():
    session["user_id"] = "S0001"
    return "Good~!"


@app.route('/del')
def session_del():
    session.pop("user_id", None)
    # session.clear()
    return "Session out"


if __name__ == '__main__':
    app.run(debug=True)
