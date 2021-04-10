from flask import Flask, render_template, request, jsonify

from d210303survey.mydao_sdetail import MySdetailDao
from d210303survey.mydao_suser import MySuserDao
from d210303survey.mydao_survey import MySurveyDao

app = Flask(__name__,
            static_url_path='',
            static_folder='static'
            )


@app.route('/')
@app.route('/suser')
def suser():
    suser = MySuserDao().mySelect()
    return render_template('suser.html', susers=suser)


@app.route('/survey')
def survey():
    survey = MySurveyDao().mySelect()
    return render_template('survey.html', surveys=survey)


@app.route('/sdetail')
def sdetail():
    sdetail = MySdetailDao().mySelect()
    return render_template('sdetail.html', sdetails=sdetail)


@app.route('/suser_ins.ajax', methods=['POST', 'GET'])
def suserinsert():
    user_id = request.form['user_id']
    pwd = request.form['pwd']
    user_name = request.form['user_name']
    mobile = request.form['mobile']
    email = request.form['email']
    birth = request.form['birth']
    in_user_id = "ADMIN"

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
    up_user_id = "ADMIN"

    try:
        if MySuserDao().myUpdate(user_id, pwd, user_name, mobile, email, birth, up_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/suser_del.ajax', methods=['GET', 'POST'])
def suserdelete():
    user_id = request.form['user_id']

    try:
        if MySuserDao().myDelete(user_id):
            return jsonify(msg="ok")
    except:
        pass
    return jsonify(msg="ng")


@app.route('/survey_ins.ajax', methods=['POST', 'GET'])
def surveyinsert():
    s_id = request.form['s_id']
    title = request.form['title']
    content = request.form['content']
    interview_cnt = request.form['interview_cnt']
    deadline = request.form['deadline']
    in_user_id = "ADMIN"

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
    up_user_id = "ADMIN"

    try:
        if MySurveyDao().myUpdate(s_id, title, content, interview_cnt, deadline, up_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/survey_del.ajax', methods=['GET', 'POST'])
def surveydelete():
    s_id = request.form['s_id']

    try:
        if MySurveyDao().myDelete(s_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/sdetail_ins.ajax', methods=['POST', 'GET'])
def sdetailinsert():
    survey_id = request.form['survey_id']
    s_seq = request.form['s_seq']
    question = request.form['question']
    a1 = request.form['a1']
    a2 = request.form['a2']
    a3 = request.form['a3']
    a4 = request.form['a4']
    in_user_id = "ADMIN"

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
    up_user_id = "ADMIN"

    try:
        if MySdetailDao().myUpdate(survey_id, s_seq, question, a1, a2, a3, a4, up_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/sdetail_del.ajax', methods=['GET', 'POST'])
def sdetaildelete():
    survey_id = request.form['survey_id']
    s_seq = request.form['s_seq']

    try:
        if MySdetailDao().myDelete(survey_id, s_seq):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


if __name__ == '__main__':
    app.run(debug=True)
