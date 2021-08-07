from flask import Flask, render_template, request, send_file
from werkzeug.utils import secure_filename
import os

app = Flask(__name__, static_url_path="", static_folder="static")


@app.route('/')
@app.route('/upload', methods=['POST'])
def upload_file():
    if request.method == 'POST':
        file = request.files['file']

        path = "uploads"
        os.makedirs(path, exist_ok=True)

        filename = secure_filename(file.filename)
        file.save(os.path.join(path, filename))

        return 'uploads 디렉토리 → 파일 업로드 성공!'
    return render_template('upload.html', names=list)


@app.route('/download')
def download_file():
    path = "uploads"
    filename = 'pc.png'

    return send_file(os.path.join(path, filename), as_attachment=True)


if __name__ == '__main__':
    app.run(debug=True)
