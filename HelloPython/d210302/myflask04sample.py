from flask import Flask, render_template, request, jsonify
from d210226.mydao import MyDao

app = Flask(__name__,
            static_url_path='',
            static_folder='static'
            )


@app.route('/sample')
def sample():
    sample = MyDao().mySelect()

    return render_template('sample.html', samples=sample)


@app.route('/sample_ins.ajax', methods=['GET', 'POST'])
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
        if MyDao().myInsert(col01, col02, col03):
            return jsonify(msg="ok")
    except:
        pass
    return jsonify(msg="ng")


@app.route('/sample_upd.ajax', methods=['GET', 'POST'])
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
        if MyDao().myUpdate(col01, col02, col03):
            return jsonify(msg="ok")
    except:
        pass
    return jsonify(msg="ng")


@app.route('/sample_del.ajax', methods=['GET', 'POST'])
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
        if MyDao().myDelete(col01, col02, col03):
            return jsonify(msg="ok")
    except:
        pass
    return jsonify(msg="ng")


if __name__ == '__main__':
    app.run(debug=True)
