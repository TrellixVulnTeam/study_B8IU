from flask import Flask, render_template, jsonify, request, session, escape, redirect

app = Flask(__name__, static_url_path="", static_folder="static")
app.secret_key = "ABCDEFG"


@app.route("/")
@app.route("/sample")
def main_render():
    return render_template('sample.html')


if __name__ == "__main__":
    app.run()
