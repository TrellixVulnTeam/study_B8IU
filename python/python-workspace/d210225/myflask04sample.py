from flask import Flask, render_template, request, jsonify, send_from_directory
import cx_Oracle


def detData():
    conn = cx_Oracle.connect('python/python@localhost:1521/xe')
    cur = conn.cursor()
    cur.execute("select col01, col02, col03 from sample order by col01")

    res = []
    for result in cur:
        res.append({'col01': result[0], 'col02': result[1], 'col03': result[2]})

    cur.close()
    conn.close()

    return res


def myinsert(col01, col02, col03):
    conn = cx_Oracle.connect('python/python@localhost:1521/xe')
    cur = conn.cursor()

    sql = "INSERT INTO SAMPLE(col01, col02, col03) VALUES(:V_col01, :V_col02, :V_col03)"
    cur.execute(sql, (col01, col02, col03))
    result = cur.rowcount

    conn.commit()
    cur.close()
    conn.close()

    return result


def myupdate(col01, col02, col03):
    conn = cx_Oracle.connect('python/python@localhost:1521/xe')
    cur = conn.cursor()

    sql = "UPDATE SAMPLE SET col02 = :V_col02, col03 = :V_col03 WHERE col01 = :V_col01"
    cur.execute(sql, (col02, col03, col01))
    result = cur.rowcount

    conn.commit()
    cur.close()
    conn.close()
    return result


def mydelete(col01, col02, col03):
    conn = cx_Oracle.connect('python/python@localhost:1521/xe')
    cur = conn.cursor()

    sql = "delete from sample where col01 = :V_col01"
    cur.execute(sql, (col01,))
    result = cur.rowcount

    conn.commit()
    cur.close()
    conn.close()

    return result


app = Flask(__name__,
            static_url_path='',
            static_folder='static'
            )


@app.route('/sample')
def sample():
    sample = detData()

    return render_template('sample.html', samples=sample)


@app.route('/sampleinsert.ajax', methods=['GET', 'POST'])
def sampleinsert():
    col01 = request.args.get('col01')
    if col01 is None:
        col01 = request.form['col01']
    col02 = request.args.get('col02')
    if col02 is None:
        col02 = request.form['col02']
    col03 = request.args.get('col03')
    if col03 is None:
        col03 = request.form['col03']
    try:
        if myinsert(col01, col02, col03):
            return jsonify(response="ok")
    except:
        pass
    return jsonify(response="ng")


@app.route('/sampleupdate.ajax', methods=['GET', 'POST'])
def sampleupdate():
    col01 = request.args.get('col01')
    if col01 is None:
        col01 = request.form['col01']
    col02 = request.args.get('col02')
    if col02 is None:
        col02 = request.form['col02']
    col03 = request.args.get('col03')
    if col03 is None:
        col03 = request.form['col03']
    try:
        print(col01, col02, col03)
        if myupdate(col01, col02, col03):
            return jsonify(response="ok")
    except:
        pass
    return jsonify(response="ng")


@app.route('/sampledelete.ajax', methods=['GET', 'POST'])
def sampledelete():
    col01 = request.args.get('col01')
    if col01 is None:
        col01 = request.form['col01']
    col02 = request.args.get('col02')
    if col02 is None:
        col02 = request.form['col02']
    col03 = request.args.get('col03')
    if col03 is None:
        col03 = request.form['col03']
    try:
        if mydelete(col01, col02, col03):
            return jsonify(response="ok")
    except:
        pass
    return jsonify(response="ng")


if __name__ == '__main__':
    app.run(debug=True)
