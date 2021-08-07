import os
import datetime
import pandas as pd

from flask import Flask, render_template, jsonify, request, session, escape, redirect, send_file
from werkzeug.utils import secure_filename

from d210330sul.mydao_snotice import MyDaoSnotice
from d210330sul.mydao_suser import MyDaoSuser
from d210330sul.mydao_survey import MyDaoSurvey
from d210330sul.mydao_sdetail import MyDaoSdetail
from d210330sul.mydao_starget import MyDaoStarget
from d210330sul.mymail import MyMail
from d210330sul.mydao_sresult import MyDaoSresult
from d210330sul.mysms import MySms
from d210330sul.mydao_sreply import MyDaoSreply

app = Flask(__name__, static_url_path="", static_folder="static")
app.secret_key = "ABCDEFG"
DIR_UPLOAD = 'static/upload'


def getSession():
    user_id = ""
    try:
        user_id = str(escape(session["user_id"]))
    except:
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
    st_mobile = request.args.get('st_mobile')
    list = MyDaoSdetail().myselect(survey_id)
    q_cnt = len(list)
    return render_template('sview.html', list=list, survey_id=survey_id, st_mobile=st_mobile, q_cnt=q_cnt)


@app.route("/logout")
def logout_render():
    session.clear()
    return redirect("main")


#############################################

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


##################################################
@app.route('/join.ajax', methods=['POST'])
def join_ajax():
    user_id = request.form["user_id"]
    pwd = '1'
    user_name = request.form["user_name"]
    mobile = request.form["mobile"]
    email = request.form["email"]
    birth = request.form["birth"]

    print(user_id)

    cnt = MyDaoSuser().myinsert(user_id, pwd, user_name, mobile, email, birth, "", "S00001", "", "S00001")

    content = user_id + "님!!!^o^ 당신의 계정은 " + user_id + "이고 비밀번호는 1입니다. 로그인 후 변경바랍니다"
    MyMail().mysendmail(email, "설조 회원가입을 축하드립니다", content)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


#############################################

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


#################################################

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
    in_user_id = str(escape(session["user_id"]))
    up_date = request.form["up_date"]
    up_user_id = str(escape(session["user_id"]))
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
    in_user_id = str(escape(session["user_id"]))
    up_date = request.form["up_date"]
    up_user_id = str(escape(session["user_id"]))

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
    in_user_id = str(escape(session["user_id"]))
    up_date = request.form["up_date"]
    up_user_id = str(escape(session["user_id"]))
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


@app.route("/starget_form")
def starget_form():
    survey_id = request.args.get('survey_id')
    flag_ses, user_id = getSession()
    if not flag_ses:
        return redirect("login.html")

    return render_template('starget_form.html', survey_id=survey_id)


@app.route("/starget_excel", methods=['POST'])
def starget_excel():
    flag_ses, user_id = getSession()
    if not flag_ses:
        return redirect("login.html")

    survey_id = request.form['survey_id']

    try:
        file = request.files['file']

        excel = pd.read_excel(file)
        cnt = MyDaoStarget().insertAll(survey_id, excel["전화번호"], user_id)

        if cnt:
            return "<script>alert('업로드 성공');opener.location.reload();self.close()</script>"
    except:
        pass
    return "<script>alert('업로드 실패');opener.location.reload();self.close()</script>"


@app.route('/starget_sms.ajax', methods=['POST'])
def starget_sms_ajax():
    survey_id = request.form["survey_id"]

    list = MyDaoStarget().myselect(survey_id)

    print(list)

    for i in list:
        mobile = i['st_mobile']
        url = "http://192.168.41.3:5000/sview?survey_id=" + survey_id + "&st_mobile=" + i['st_mobile']
        MySms().mysendSms(mobile, url)

    msg = ""
    if len(list) > 0:
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
    in_user_id = str(escape(session["user_id"]))
    up_date = request.form["up_date"]
    up_user_id = str(escape(session["user_id"]))

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
    in_user_id = str(escape(session["user_id"]))
    up_date = request.form["up_date"]
    up_user_id = str(escape(session["user_id"]))
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


#############################################################

@app.route("/sresult")
def sresult_render():
    survey_id = request.args.get('survey_id')
    flag_ses, user_id = getSession()
    if not flag_ses:
        return redirect("login.html")

    list = MyDaoSresult().myselect_graph(survey_id)
    return render_template('../d210308/templates/sresult.html', list=list, enumerate=enumerate)


@app.route('/sresult_submit.ajax', methods=['POST'])
def sresult_submit_ajax():
    survey_id = request.form["survey_id"]
    st_mobile = request.form["st_mobile"]
    ans = request.form["ans"]

    cnt = MyDaoSresult().myinsert_ans(survey_id, st_mobile, ans)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/sresult_ins.ajax', methods=['POST'])
def sresult_ins_ajax():
    survey_id = request.form["survey_id"]
    s_seq = request.form["s_seq"]
    st_mobile = request.form["st_mobile"]
    answer = request.form["answer"]
    in_date = request.form["in_date"]
    in_user_id = str(escape(session["user_id"]))
    up_date = request.form["up_date"]
    up_user_id = str(escape(session["user_id"]))

    cnt = MyDaoSresult().myinsert(survey_id, s_seq, st_mobile, answer, in_date, in_user_id, up_date, up_user_id)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/sresult_upd.ajax', methods=['POST'])
def sresult_upd_ajax():
    survey_id = request.form["survey_id"]
    s_seq = request.form["s_seq"]
    st_mobile = request.form["st_mobile"]
    answer = request.form["answer"]
    in_date = request.form["in_date"]
    in_user_id = str(escape(session["user_id"]))
    up_date = request.form["up_date"]
    up_user_id = str(escape(session["user_id"]))
    cnt = MyDaoSresult().myupdate(survey_id, s_seq, st_mobile, answer, in_date, in_user_id, up_date, up_user_id)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


@app.route('/sresult_del.ajax', methods=['POST'])
def sresult_del_ajax():
    survey_id = request.form["survey_id"]
    s_seq = request.form["s_seq"]
    st_mobile = request.form["st_mobile"]

    cnt = MyDaoSresult().mydelete(survey_id, s_seq, st_mobile)

    msg = ""
    if cnt == 1:
        msg = "ok"
    else:
        msg = "ng"

    return jsonify(msg=msg)


#############################################################

@app.route("/snotice_list")
def snotice_list_render():
    user_id = ''
    if 'user_id' in session:
        user_id = str(escape(session["user_id"]))
    search = request.args.get('search', '')

    list = MyDaoSnotice().myselect(user_id, search)

    return render_template('snotice_list.html', list=list, search=search)


@app.route("/snotice_detail")
def snotice_detail_render():
    user_id = ''
    if 'user_id' in session:
        user_id = str(escape(session["user_id"]))

    b_seq = request.args.get('b_seq')

    MyDaoSnotice().myhit(b_seq, user_id)
    data = MyDaoSnotice().mydetail(user_id, b_seq)

    if data:
        reply = MyDaoSreply().myselect(b_seq)
        return render_template('snotice_detail.html', data=data, reply=reply)
    return "<script>alert('해당 글이 존재하지 않습니다.');history.back();location.reload();</script>"


@app.route("/snotice_add")
def snotice_add():
    if 'user_id' in session:
        return render_template('snotice_add.html')
    return redirect("login.html")


@app.route("/snotice_add_form", methods=['POST'])
def snotice_add_form():
    if 'user_id' in session:
        user_id = str(escape(session["user_id"]))

        file = request.files['file']
        attach_file = ''
        if file:
            filename, extension = os.path.splitext(secure_filename(file.filename))
            filename = filename + datetime.datetime.today().strftime('%Y%m%d%H%M%S%f') + extension
            file.save(os.path.join(DIR_UPLOAD, filename))
            attach_file = filename
            os.makedirs(DIR_UPLOAD, exist_ok=True)

        display_yn = request.form['display_yn']
        title = request.form['title']
        content = request.form['content']
        cnt = MyDaoSnotice().myinsert(display_yn, title, content, DIR_UPLOAD, attach_file, user_id)
        if cnt:
            return "<script>alert('저장되었습니다.');opener.location.reload();self.close();</script>"
    return "<script>alert('권한이 없습니다.');self.close();</script>"


@app.route("/snotice_mod")
def snotice_mod():
    if 'user_id' in session:
        user_id = str(escape(session["user_id"]))
        b_seq = request.args.get('b_seq')

        data = MyDaoSnotice().mydetail(user_id, b_seq)
        print(data)
        if data:

            if data["in_user_id"] == user_id:
                return render_template('snotice_mod.html', data=data, enumerate=enumerate)

    return "<script>alert('권한이 없습니다.');self.close();</script>"


@app.route("/snotice_mod_form", methods=['POST'])
def snotice_mod_form():
    if 'user_id' in session:
        user_id = str(escape(session["user_id"]))
        b_seq = request.form['b_seq']
        data = MyDaoSnotice().mydetail(user_id, b_seq)

        if data:
            file = request.files['file']
            attach_file = request.form['old_attach_file']
            if file:
                filename, extension = os.path.splitext(secure_filename(file.filename))
                filename = filename + datetime.datetime.today().strftime('%Y%m%d%H%M%S%f') + extension
                os.makedirs(DIR_UPLOAD, exist_ok=True)
                file.save(os.path.join(DIR_UPLOAD, filename))
                attach_file = filename

            display_yn = request.form['display_yn']
            title = request.form['title']
            content = request.form['content']
            cnt = MyDaoSnotice().myupdate(b_seq, display_yn, title, content, DIR_UPLOAD, attach_file, user_id)
            if cnt:
                return "<script>alert('수정되었습니다.');opener.location.reload(true);self.close();</script>"

    return "<script>alert('권한이 없습니다.');self.close();</script>"


@app.route("/snotice_del")
def snotice_del():
    if 'user_id' in session:
        user_id = str(escape(session["user_id"]))
        b_seq = request.args.get('b_seq')

        if MyDaoSnotice().mydelete(user_id, b_seq):
            return "<script>alert('삭제에 성공했습니다.');opener.history.back();opener.location.reload();self.close();</script>"

    return "<script>alert('삭제에 실패했습니다.');self.close();</script>"


@app.route("/download")
def download():
    filename = request.args.get('file')

    return send_file(os.path.join(DIR_UPLOAD, filename), as_attachment=True)


@app.route("/reply_add.ajax", methods=['POST'])
def reply_add_ajax():
    if 'user_id' in session:
        user_id = str(escape(session["user_id"]))
        b_seq = request.form["b_seq"]
        cmt = request.form["replytextarea"]

        cnt = MyDaoSreply().myinsert(b_seq, cmt, user_id)
        if cnt:
            reply = MyDaoSreply().myselect(b_seq)
            return jsonify(msg="ok", reply=reply)
    return jsonify(msg="ng")


@app.route("/reply_del.ajax", methods=['POST'])
def reply_del_ajax():
    if 'user_id' in session:
        user_id = str(escape(session["user_id"]))
        r_seq = request.form["r_seq"]
        b_seq = request.form["b_seq"]

        cnt = MyDaoSreply().mydelete(user_id, r_seq)
        if cnt:
            reply = MyDaoSreply().myselect(b_seq)
            return jsonify(msg="ok", reply=reply)
    return jsonify(msg="ng")


@app.route("/reply_good.ajax", methods=['POST'])
def reply_good_ajax():
    if 'user_id' in session:
        user_id = str(escape(session["user_id"]))
        r_seq = request.form["r_seq"]
        b_seq = request.form["b_seq"]

        cnt = MyDaoSreply().mygood(r_seq)
        if cnt:
            reply = MyDaoSreply().myselect(b_seq)
            return jsonify(msg="ok", reply=reply)
    return jsonify(msg="ng")


@app.route("/reply_bad.ajax", methods=['POST'])
def reply_bad_ajax():
    if 'user_id' in session:
        user_id = str(escape(session["user_id"]))
        r_seq = request.form["r_seq"]
        b_seq = request.form["b_seq"]

        cnt = MyDaoSreply().mybad(r_seq)
        if cnt:
            reply = MyDaoSreply().myselect(b_seq)
            return jsonify(msg="ok", reply=reply)
    return jsonify(msg="ng")


#####################################################################


if __name__ == "__main__":
    app.run(debug=True)
