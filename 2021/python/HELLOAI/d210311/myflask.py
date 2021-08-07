from flask import Flask, render_template, jsonify, request, session, escape, redirect
import cx_Oracle
import json
from d210311.mydao_suser import MyDaoSuser
from d210311.mydao_survey import MyDaoSurvey
from d210311.mydao_sdetail import MyDaoSdetail
from d210311.mydao_starget import MyDaoStarget
from d210311.mydao_sresult import MyDaoSresult
from d210311.mymail import MyMail
from d210311.mysms import MyMessage

app = Flask(__name__, static_url_path="", static_folder="static")
app.secret_key = "ABCDEFG"


def getSession():
    user_id = ""
    try:
        user_id = str(escape(session["user_id"]))
    except Exception as e:
        print(e)
        pass

    if user_id == "":
        return False, user_id
    else:
        return True, user_id


@app.route("/")
@app.route("/main")
def main_render():
    return render_template('../d210308/templates/main.html')


@app.route("/sview")
def sview_render():
    survey_id = request.args.get('survey_id')
    mobile = request.args.get('mobile')
    list = MyDaoSdetail().myselect(survey_id)
    return render_template('sview.html', list=list, survey_id=survey_id, mobile=mobile)


@app.route("/sview_add.ajax", methods=['POST'])
def sview_add():
    addList = eval(request.form["result"])
    cnt = MyDaoSresult().myMerge(addList)

    msg = ""
    if cnt > 0:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route("/logout")
def logout_render():
    session.clear()
    return redirect("main")


@app.route('/join.ajax', methods=['POST'])
def join_ajax():
    user_id = request.form["user_id"]
    pwd = '1'
    user_name = request.form["user_name"]
    mobile = request.form["mobile"]
    email = request.form["email"]
    birth = request.form["birth"]

    cnt = MyDaoSuser().myinsert(user_id, pwd, user_name, mobile, email, birth, "", "S00001", "", "S00001")

    content = user_name + "님!!!^^\n 당신의 계정은 " + user_id + "이고 비밀번호는 1입니다. 로그인후 변경바랍니다."
    MyMail().mysendmail(email, "설조 회원가입을 축하드립니다.", content)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/dupl.ajax', methods=['POST'])
def dupl_ajax():
    user_id = request.form["user_id"]
    print("user_id", user_id)

    list = MyDaoSuser().mydupl(user_id)

    msg = ""
    if len(list) == 1:
        msg = "ng"
    else:
        msg = "ok"

    return jsonify(msg=msg)


@app.route('/login.ajax', methods=['POST'])
def login_ajax():
    user_id = request.form["user_id"]
    pwd = request.form["pwd"]

    print("user_id", user_id)
    print("pwd", pwd)

    list = MyDaoSuser().mylogin(user_id, pwd)

    msg = ""
    if len(list) == 1:
        session["user_id"] = list[0]['user_id']
        session["user_name"] = list[0]['user_name']
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


#############################################


@app.route("/suser")
def suser_render():
    flag_ses, user_id = getSession()
    if not flag_ses:
        return redirect("login.html")

    list = MyDaoSuser().myselect()
    return render_template('../d210308/templates/suser.html', list=list)


@app.route('/suser_ins.ajax', methods=['POST'])
def suser_ins_ajax():
    user_id = request.form["user_id"]
    pwd = request.form["pwd"]
    user_name = request.form["user_name"]
    mobile = request.form["mobile"]
    email = request.form["email"]
    birth = request.form["birth"]
    in_date = request.form["in_date"]
    in_user_id = str(escape(session["user_id"]))
    up_date = request.form["up_date"]
    up_user_id = str(escape(session["user_id"]))

    cnt = MyDaoSuser().myinsert(user_id, pwd, user_name, mobile, email, birth, in_date, in_user_id, up_date, up_user_id)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/suser_upd.ajax', methods=['POST'])
def suser_upd_ajax():
    user_id = request.form["user_id"]
    pwd = request.form["pwd"]
    user_name = request.form["user_name"]
    mobile = request.form["mobile"]
    email = request.form["email"]
    birth = request.form["birth"]
    in_date = request.form["in_date"]
    in_user_id = str(session['user_id'])
    up_date = request.form["up_date"]
    up_user_id = str(session['user_id'])
    cnt = MyDaoSuser().myupdate(user_id, pwd, user_name, mobile, email, birth, in_date, in_user_id, up_date, up_user_id)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/suser_del.ajax', methods=['POST'])
def suser_del_ajax():
    user_id = request.form["user_id"]

    cnt = MyDaoSuser().mydelete(user_id)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


########################################################


@app.route("/survey")
def survey_render():
    flag_ses, user_id = getSession()
    if not flag_ses:
        return redirect("login.html")

    user_id = str(escape(session["user_id"]))

    list = MyDaoSurvey().myselect(user_id)
    return render_template('../d210308/templates/survey.html', list=list)


@app.route('/survey_ins.ajax', methods=['POST'])
def survey_ins_ajax():
    survey_id = request.form["survey_id"]
    title = request.form["title"]
    content = request.form["content"]
    interview_cnt = request.form["interview_cnt"]
    deadline = request.form["deadline"]
    in_date = request.form["in_date"]
    in_user_id = str(escape(session["user_id"]))
    up_date = request.form["up_date"]
    up_user_id = str(escape(session["user_id"]))
    cnt = MyDaoSurvey().myinsert(survey_id, title, content, interview_cnt, deadline, in_date, in_user_id, up_date, up_user_id)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/survey_upd.ajax', methods=['POST'])
def survey_upd_ajax():
    survey_id = request.form["survey_id"]
    title = request.form["title"]
    content = request.form["content"]
    interview_cnt = request.form["interview_cnt"]
    deadline = request.form["deadline"]
    in_date = request.form["in_date"]
    in_user_id = str(escape(session["user_id"]))
    up_date = request.form["up_date"]
    up_user_id = str(escape(session["user_id"]))
    cnt = MyDaoSurvey().myupdate(survey_id, title, content, interview_cnt, deadline, in_date, in_user_id, up_date, up_user_id)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/survey_del.ajax', methods=['POST'])
def survey_del_ajax():
    survey_id = request.form["survey_id"]

    cnt = MyDaoSurvey().mydelete(survey_id)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


########################################################################


@app.route("/sdetail")
def sdetail_render():
    survey_id = request.args.get('survey_id')
    flag_ses, user_id = getSession()
    if not flag_ses:
        return redirect("login.html")

    list = MyDaoSdetail().myselect(survey_id)
    return render_template('../d210308/templates/sdetail.html', list=list, survey_id=survey_id)


@app.route('/sdetail_ins.ajax', methods=['POST'])
def sdetail_ins_ajax():
    survey_id = request.form["survey_id"]
    s_seq = request.form["s_seq"]
    question = request.form["question"]
    a1 = request.form["a1"]
    a2 = request.form["a2"]
    a3 = request.form["a3"]
    a4 = request.form["a4"]
    in_date = request.form["in_date"]
    in_user_id = escape(session["user_id"])
    up_date = request.form["up_date"]
    up_user_id = escape(session["user_id"])

    cnt = MyDaoSdetail().myinsert(survey_id, s_seq, question, a1, a2, a3, a4, in_date, in_user_id, up_date, up_user_id)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/sdetail_upd.ajax', methods=['POST'])
def sdetail_upd_ajax():
    survey_id = request.form["survey_id"]
    s_seq = request.form["s_seq"]
    question = request.form["question"]
    a1 = request.form["a1"]
    a2 = request.form["a2"]
    a3 = request.form["a3"]
    a4 = request.form["a4"]
    in_date = request.form["in_date"]
    in_user_id = escape(session["user_id"])
    up_date = request.form["up_date"]
    up_user_id = escape(session["user_id"])
    cnt = MyDaoSdetail().myupdate(survey_id, s_seq, question, a1, a2, a3, a4, in_date, in_user_id, up_date, up_user_id)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/sdetail_del.ajax', methods=['POST'])
def sdetail_del_ajax():
    survey_id = request.form["survey_id"]
    s_seq = request.form["s_seq"]

    cnt = MyDaoSdetail().mydelete(survey_id, s_seq)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


#####################################################################


@app.route("/starget")
def starget_render():
    survey_id = request.args.get('survey_id')
    flag_ses, user_id = getSession()
    if not flag_ses:
        return redirect("login.html")

    list = MyDaoStarget().myselect(survey_id)
    return render_template('../d210308/templates/starget.html', list=list, survey_id=survey_id)


@app.route('/starget_sms.ajax', methods=['POST'])
def starget_sms_ajax():
    survey_id = request.form["survey_id"]

    list = MyDaoStarget().myselect(survey_id)

    for target in list:
        MyMessage.mysendmsms(target['st_mobile'], f"http://192.168.41.42:5000/sview?survey_id={survey_id}&mobile={target['st_mobile']}")

    if len(list):
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/starget_ins.ajax', methods=['POST'])
def starget_ins_ajax():
    survey_id = request.form["survey_id"]
    st_mobile = request.form["st_mobile"]
    complete_yn = request.form["complete_yn"]
    in_date = request.form["in_date"]
    in_user_id = escape(session["user_id"])
    up_date = request.form["up_date"]
    up_user_id = escape(session["user_id"])

    cnt = MyDaoStarget().myinsert(survey_id, st_mobile, complete_yn, in_date, in_user_id, up_date, up_user_id)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/starget_upd.ajax', methods=['POST'])
def starget_upd_ajax():
    survey_id = request.form["survey_id"]
    st_mobile = request.form["st_mobile"]
    complete_yn = request.form["complete_yn"]
    in_date = request.form["in_date"]
    in_user_id = escape(session["user_id"])
    up_date = request.form["up_date"]
    up_user_id = escape(session["user_id"])
    cnt = MyDaoStarget().myupdate(survey_id, st_mobile, complete_yn, in_date, in_user_id, up_date, up_user_id)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/starget_del.ajax', methods=['POST'])
def starget_del_ajax():
    survey_id = request.form["survey_id"]
    st_mobile = request.form["st_mobile"]

    cnt = MyDaoStarget().mydelete(survey_id, st_mobile)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


############################


@app.route('/sresult')
def sresult():
    survey_id = request.args.get('survey_id')
    if "user_id" not in session:
        return redirect('/login.html')
    sresult = MyDaoSresult().mySelect(survey_id)

    return render_template('../d210308/templates/sresult.html', sresults=sresult, survey_id=survey_id)


@app.route('/sresult_ins.ajax', methods=['POST', 'GET'])
def sresultinsert():
    survey_id = request.form['survey_id']
    s_seq = request.form['s_seq']
    st_mobile = request.form['st_mobile']
    answer = request.form['answer']
    in_user_id = escape(session["user_id"])

    try:
        if MyDaoSresult().myInsert(survey_id, s_seq, st_mobile, answer, in_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/sresult_upd.ajax', methods=['POST'])
def sresultupdate():
    survey_id = request.form['survey_id']
    s_seq = request.form['s_seq']
    st_mobile = request.form['st_mobile']
    answer = request.form['answer']
    up_user_id = escape(session["user_id"])

    try:
        if MyDaoSresult().myUpdate(survey_id, s_seq, st_mobile, answer, up_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/sresult_del.ajax', methods=['GET', 'POST'])
def sresultdelete():
    survey_id = request.form['survey_id']
    s_seq = request.form['s_seq']
    st_mobile = request.form['st_mobile']

    try:
        if MyDaoSresult().myDelete(survey_id, s_seq, st_mobile):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


if __name__ == "__main__":
    app.run(host='0.0.0.0')
