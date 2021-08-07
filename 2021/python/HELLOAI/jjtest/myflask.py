from flask import Flask, render_template, jsonify, request, session, escape, redirect
import cx_Oracle
import json
from d210311.mydao_suser import MyDaoSuser
from d210311.mydao_survey import MyDaoSurvey
from d210311.mydao_sdetail import MyDaoSdetail
from d210311.mydao_starget import MyDaoStarget
from d210311.mydao_sresult import MyDaoSresult
from d210311.mymail import MyMail

app = Flask(__name__, static_url_path="", static_folder="static")
app.secret_key = "ABCDEFG"


@app.route("/")
@app.route("/main", methods=["GET", "POST"])
def main_render():
    # print(dict(request.args))
    print(dict(request.args))
    return render_template('../d210308/templates/main.html')


if __name__ == "__main__":
    app.run()
