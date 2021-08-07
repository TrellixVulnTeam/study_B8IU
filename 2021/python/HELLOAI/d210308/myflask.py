from flask import Flask, render_template, request, jsonify, redirect, session, url_for, escape

from d210308.mydao_sdetail import MySdetailDao
from d210308.mydao_sresult import MySresultDao
from d210308.mydao_starget import MyStargetDao
from d210308.mydao_suser import MySuserDao
from d210308.mydao_survey import MySurveyDao
from d210308.mymail import MyMail

app = Flask(__name__,
            static_url_path='',
            static_folder='static'
            )

app.secret_key = "secret"


def getsession():
    if "user_id" in session:
        return True, session['user_id']
    return False, None


@app.route('/')
@app.route('/main')
def main():
    return render_template('templates/main.html')


@app.route('/suser')
def suser():
    flag_ses, user_id = getsession()
    if not flag_ses:
        return redirect('/login.html')

    suser = MySuserDao().mySelect()
    return render_template('templates/suser.html', susers=suser)


@app.route('/survey')
def survey():
    if "user_id" not in session:
        return redirect('/login.html')
    survey = MySurveyDao().mySelect()
    return render_template('templates/survey.html', surveys=survey)


@app.route('/sdetail')
def sdetail():
    if "user_id" not in session:
        return redirect('/login.html')
    sdetail = MySdetailDao().mySelect()
    return render_template('templates/sdetail.html', sdetails=sdetail)


@app.route('/starget')
def starget():
    if "user_id" not in session:
        return redirect('/login.html')
    starget = MyStargetDao().mySelect()

    return render_template('templates/starget.html', stargets=starget)


@app.route('/sresult')
def sresult():
    if "user_id" not in session:
        return redirect('/login.html')
    sresult = MySresultDao().mySelect()

    return render_template('templates/sresult.html', sresults=sresult)


@app.route('/login.ajax', methods=['POST'])
def loginajax():
    user_id = request.form['user_id']
    pwd = request.form['pwd']

    loginlist = MySuserDao().myLogin(user_id, pwd)
    if loginlist:
        session["user_id"] = loginlist[0].get('user_id')
        session["user_name"] = loginlist[0].get('user_name')
        return jsonify(msg="ok")
    return jsonify(msg="ng")


@app.route('/dupl.ajax', methods=['POST'])
def duplajax():
    user_id = request.form['user_id']

    duplList = MySuserDao().myDupl(user_id)
    if duplList:
        return jsonify(msg="ng")
    return jsonify(msg="ok")


@app.route('/join.ajax', methods=['POST'])
def joinajax():
    user_id = request.form['user_id']
    pwd = "1"
    user_name = request.form['user_name']
    mobile = request.form['mobile']
    email = request.form['email']
    birth = request.form['birth']
    in_user_id = escape(session.get("user_id", "S0001"))

    try:
        if MySuserDao().myInsert(user_id, pwd, user_name, mobile, email, birth, in_user_id):
            content = f"{user_name}님!^^ 당신의 계정은 {user_id}이고, 비밀번호는 {pwd}입니다. 로그인 후 변경 바랍니다."
            MyMail().mysendmail(email, "설조 회원가입을 축하드립니다.", content)
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/logout')
def logout():
    session.clear()
    return redirect(url_for('main'))


@app.route('/suser_ins.ajax', methods=['POST'])
def suserinsert():
    user_id = request.form['user_id']
    pwd = request.form['pwd']
    user_name = request.form['user_name']
    mobile = request.form['mobile']
    email = request.form['email']
    birth = request.form['birth']
    in_user_id = escape(session.get("user_id", user_id))

    try:
        if MySuserDao().myInsert(user_id, pwd, user_name, mobile, email, birth, in_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/suser_upd.ajax', methods=['POST'])
def suserupdate():
    user_id = request.form['user_id']
    pwd = request.form['pwd']
    user_name = request.form['user_name']
    mobile = request.form['mobile']
    email = request.form['email']
    birth = request.form['birth']
    up_user_id = escape(session["user_id"])

    try:
        if MySuserDao().myUpdate(user_id, pwd, user_name, mobile, email, birth, up_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/suser_del.ajax', methods=['POST'])
def suserdelete():
    user_id = request.form['user_id']

    try:
        if MySuserDao().myDelete(user_id):
            return jsonify(msg="ok")
    except:
        pass
    return jsonify(msg="ng")


@app.route('/survey_ins.ajax', methods=['POST'])
def surveyinsert():
    s_id = request.form['s_id']
    title = request.form['title']
    content = request.form['content']
    interview_cnt = request.form['interview_cnt']
    deadline = request.form['deadline']
    in_user_id = escape(session["user_id"])

    try:
        if MySurveyDao().myInsert(s_id, title, content, interview_cnt, deadline, in_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/survey_upd.ajax', methods=['POST'])
def surveyupdate():
    s_id = request.form['s_id']
    title = request.form['title']
    content = request.form['content']
    interview_cnt = request.form['interview_cnt']
    deadline = request.form['deadline']
    up_user_id = escape(session["user_id"])

    try:
        if MySurveyDao().myUpdate(s_id, title, content, interview_cnt, deadline, up_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/survey_del.ajax', methods=['POST'])
def surveydelete():
    s_id = request.form['s_id']

    try:
        if MySurveyDao().myDelete(s_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/sdetail_ins.ajax', methods=['POST'])
def sdetailinsert():
    survey_id = request.form['survey_id']
    s_seq = request.form['s_seq']
    question = request.form['question']
    a1 = request.form['a1']
    a2 = request.form['a2']
    a3 = request.form['a3']
    a4 = request.form['a4']
    in_user_id = escape(session["user_id"])

    try:
        if MySdetailDao().myInsert(survey_id, s_seq, question, a1, a2, a3, a4, in_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/sdetail_upd.ajax', methods=['POST'])
def sdetailupdate():
    survey_id = request.form['survey_id']
    s_seq = request.form['s_seq']
    question = request.form['question']
    a1 = request.form['a1']
    a2 = request.form['a2']
    a3 = request.form['a3']
    a4 = request.form['a4']
    up_user_id = escape(session["user_id"])

    try:
        if MySdetailDao().myUpdate(survey_id, s_seq, question, a1, a2, a3, a4, up_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/sdetail_del.ajax', methods=['POST'])
def sdetaildelete():
    survey_id = request.form['survey_id']
    s_seq = request.form['s_seq']

    try:
        if MySdetailDao().myDelete(survey_id, s_seq):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/starget_ins.ajax', methods=['POST', 'GET'])
def stargetinsert():
    survey_id = request.form['survey_id']
    st_mobile = request.form['st_mobile']
    complete_yn = request.form['complete_yn']
    in_user_id = escape(session["user_id"])

    try:
        if MyStargetDao().myInsert(survey_id, st_mobile, complete_yn, in_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/starget_upd.ajax', methods=['POST'])
def stargetupdate():
    survey_id = request.form['survey_id']
    st_mobile = request.form['st_mobile']
    complete_yn = request.form['complete_yn']
    up_user_id = escape(session["user_id"])

    try:
        if MyStargetDao().myUpdate(survey_id, st_mobile, complete_yn, up_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/starget_del.ajax', methods=['GET', 'POST'])
def stargetdelete():
    survey_id = request.form['survey_id']
    st_mobile = request.form['st_mobile']

    try:
        if MyStargetDao().myDelete(survey_id, st_mobile):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/sresult_ins.ajax', methods=['POST', 'GET'])
def sresultinsert():
    survey_id = request.form['survey_id']
    s_seq = request.form['s_seq']
    st_mobile = request.form['st_mobile']
    answer = request.form['answer']
    in_user_id = escape(session["user_id"])

    try:
        if MySresultDao().myInsert(survey_id, s_seq, st_mobile, answer, in_user_id):
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
        if MySresultDao().myUpdate(survey_id, s_seq, st_mobile, answer, up_user_id):
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
        if MySresultDao().myDelete(survey_id, s_seq, st_mobile):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


if __name__ == '__main__':
    app.run(debug=True)
