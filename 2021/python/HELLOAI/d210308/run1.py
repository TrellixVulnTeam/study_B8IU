table = "sresult"

pkcolumn = ['survey_id', 's_seq','st_mobile']
nomalcolumn = ['answer']

with open(f"./templates/{table}_text.html", "w", encoding="UTF-8") as file:
    text = """<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>"""
    text += table
    text += """</title>
    <style>
        table {
            border-collapse: collapse;
            text-align: center;
            margin: 5px;
        }

        table table th {
            width: 100px;
        }

        label {
            display: inline-block;
            width: 100px;
        }

        input {
            margin: 5px;
        }
    </style>
    <script src="./js/jquery-3.5.1.js"></script>
    <script>
        function setData("""
    for index, column in enumerate(pkcolumn):
        if not index:
            text += column
        else:
            text += ", " + column
    for index, column in enumerate(nomalcolumn):
        text += ", " + column
    text += """) {"""
    for column in pkcolumn:
        text += f"\n            $('#{column}').val({column});"
    for column in nomalcolumn:
        text += f"\n            $('#{column}').val({column});"
    text += """
        }

        function fn_add() {"""
    for column in pkcolumn:
        text += f"\n            let {column} = $('#{column}').val();"
    for column in nomalcolumn:
        text += f"\n            let {column} = $('#{column}').val();"
    text += """

            let param = "";
            param += "dummy=" + Math.random();"""
    for column in pkcolumn:
        text += f"\n            param += '&{column}=' + {column};"
    for column in nomalcolumn:
        text += f"\n            param += '&{column}=' + {column};"

    text += """
            console.log(param)

            $.ajax({
                url: '"""
    text += table + """_ins.ajax',
                data: param,
                dataType: "json",
                type: "post",
                async: false,
                statusCode: {
                    404: function () {
                        alert("네트워크가 불안정합니다. 다시 시도부탁드립니다.");
                    }
                },
                success: function (data) {
                    if (data["msg"] === "ok") {
                        location.reload()
                    } else {
                        alert("추가 도중 문제가 발생하였습니다.");
                    }
                }
            });
        }

        function fn_upd() {"""
    for column in pkcolumn:
        text += f"\n            let {column} = $('#{column}').val();"
    for column in nomalcolumn:
        text += f"\n            let {column} = $('#{column}').val();"
    text += """

            let param = "";
            param += "dummy=" + Math.random();"""
    for column in pkcolumn:
        text += f"\n            param += '&{column}=' + {column};"
    for column in nomalcolumn:
        text += f"\n            param += '&{column}=' + {column};"

    text += """
            console.log(param)

            $.ajax({
                url: '"""
    text += table + """_upd.ajax',
                data: param,
                dataType: "json",
                type: "post",
                async: false,
                statusCode: {
                    404: function () {
                        alert("네트워크가 불안정합니다. 다시 시도부탁드립니다.");
                    }
                },
                success: function (data) {
                    if (data["msg"] === "ok") {
                        location.reload()
                    } else {
                        alert("수정 중 문제가 발생하였습니다.");
                    }
                }
            });
        }

        function fn_del() {"""
    for column in pkcolumn:
        text += f"\n            let {column} = $('#{column}').val();"
    for column in nomalcolumn:
        text += f"\n            let {column} = $('#{column}').val();"
    text += """

            let param = "";
            param += "dummy=" + Math.random();"""
    for column in pkcolumn:
        text += f"\n            param += '&{column}=' + {column};"
    for column in nomalcolumn:
        text += f"\n            param += '&{column}=' + {column};"

    text += """
            console.log(param)

            $.ajax({
                url: '"""
    text += table + """_del.ajax',
                data: param,
                dataType: "json",
                type: "post",
                async: false,
                statusCode: {
                    404: function () {
                        alert("네트워크가 불안정합니다. 다시 시도부탁드립니다.");
                    }
                },
                success: function (data) {
                    if (data["msg"] === "ok") {
                        location.reload()
                    } else {
                        alert("삭제 중 문제가 발생하였습니다.");
                    }
                }
            });
        }
    </script>
</head>
<body>
<table border="1">
    <tr>
        <td>
            <table border="1">
                <tr>"""
    for column in pkcolumn:
        text += f"\n                    <th>{column}</th>"
    for column in nomalcolumn:
        text += f"\n                    <th>{column}</th>"
    text += """
                    <th>in_date</th>
                    <th>in_user_id</th>
                    <th>up_date</th>
                    <th>up_user_id</th>
                </tr>
                {% for """
    text += table + """ in """
    text += table + """s %}
                <tr>
                    <td><a href="javascript:setData("""
    for index, column in enumerate(pkcolumn):
        if not index:
            text += "'{{"+table+".get('" + column + "')}}'"
        else:
            text += ", '{{"+table+".get('" + column + "')}}'"
    for index, column in enumerate(nomalcolumn):
        text += ", {{"+table+".get('" + column + "')}}"
    text += """)">{{"""
    text += table
    text += """.get('""" + pkcolumn[0] + """')}}"""
    text += """</a></td>"""
    for index, column in enumerate(pkcolumn):
        if index:
            text += "\n                    <td>{{" + table + ".get('" + column + "')}}</td>"
    for index, column in enumerate(nomalcolumn):
        text += "\n                    <td>{{" + table + ".get('" + column + "')}}</td>"
    text += """
                    <td>{{"""
    text += table
    text += """.get('in_date')}}</td>
                    <td>{{"""
    text += table
    text += """.get('in_user_id')}}</td>
                    <td>{{"""
    text += table
    text += """.get('up_date')}}</td>
                    <td>{{"""
    text += table
    text += """.get('up_user_id')}}</td>
                </tr>
                {% endfor %}
            </table>
        </td>
        <td>
            <table>"""
    for index, column in enumerate(pkcolumn):
        text += f"""\n                <tr>
                    <td><label>{column}</label><input type="text" name="{column}" id="{column}"></td>
                </tr>"""
    for index, column in enumerate(nomalcolumn):
        text += f"""\n                <tr>
                    <td><label>{column}</label><input type="text" name="{column}" id="{column}"></td>
                </tr>"""

    text += """
                <tr>
                    <td>
                        <input type="button" value="추가" onclick="fn_add()">
                        <input type="button" value="수정" onclick="fn_upd()">
                        <input type="button" value="삭제" onclick="fn_del()">
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>"""
    file.write(text)

with open(f"./mybatis_{table}_text.xml", "w", encoding="UTF-8") as file:
    text = f"""<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="{table}">
    <select id="select">
        SELECT """
    for index, column in enumerate(pkcolumn):
        if not index:
            text += column.upper()
        else:
            text += ",\n                " + column.upper()
    for index, column in enumerate(nomalcolumn):
        text += ",\n                " + column.upper()
    text += f""",
                IN_DATE,
                IN_USER_ID,
                UP_DATE,
                UP_USER_ID
            FROM {table.upper()}
            ORDER BY """
    for index, column in enumerate(pkcolumn):
        if not index:
            text += column.upper()
        else:
            text += ", " + column.upper()
    text += f"""
    </select>
    <insert id="insert">
        INSERT INTO {table.upper()}(
            """
    for index, column in enumerate(pkcolumn):
        if not index:
            text += column.upper()
        else:
            text += ",\n            " + column.upper()
    for index, column in enumerate(nomalcolumn):
        text += ",\n            " + column.upper()
    text += """,
            IN_DATE,
            IN_USER_ID,
            UP_DATE,
            UP_USER_ID
        ) VALUES (
            """
    for index, column in enumerate(pkcolumn):
        if not index:
            text += ":V_" + column.upper()
        else:
            text += ",\n            :V_" + column.upper()
    for index, column in enumerate(nomalcolumn):
        text += ",\n            :V_" + column.upper()
    text += f""",
            TO_CHAR(SYSDATE, 'YYYYMMDD.HH24MISS'),
            :V_IN_USER_ID,
            TO_CHAR(SYSDATE, 'YYYYMMDD.HH24MISS'),
            :V_UP_USER_ID
        )
    </insert>
    <update id="update">
        UPDATE {table.upper()}
            SET """
    for index, column in enumerate(nomalcolumn):
        if not index:
            text += f"{column.upper()} = :V_{column.upper()}"
        else:
            text += f",\n                {column.upper()} = :V_{column.upper()}"
    text += """,
                UP_DATE = TO_CHAR(SYSDATE, 'YYYYMMDD.HH24MISS'),
                UP_USER_ID = :V_UP_USER_ID
            WHERE """
    for index, column in enumerate(pkcolumn):
        if not index:
            text += f"{column.upper()} = :V_{column.upper()}"
        else:
            text += f"\n                AND {column.upper()} = :V_{column.upper()}"
    text += f"""
    </update>
    <delete id="delete">
        DELETE
            FROM {table.upper()}
            WHERE """
    for index, column in enumerate(pkcolumn):
        if not index:
            text += f"{column.upper()} = :V_{column.upper()}"
        else:
            text += f"\n                AND {column.upper()} = :V_{column.upper()}"
    text += """
    </delete>
</mapper>"""
    file.write(text)

with open(f"./mydao_{table}_text.py", "w", encoding="UTF-8") as file:
    text = """import cx_Oracle
import mybatis_mapper2sql


class My"""
    text += table.capitalize()
    text += """Dao:
    def __init__(self):
        self.conn = cx_Oracle.connect('python/python@localhost:1521/xe')
        self.cur = self.conn.cursor()
        self.mapper = mybatis_mapper2sql.create_mapper(xml='mybatis_"""
    text += table
    text += """.xml')[0]

    def mySelect(self):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'select')
        self.cur.execute(sql)
        res = []
        for result in self.cur:
            res.append({"""
    for index, column in enumerate(pkcolumn):
        if not index:
            text += f"'{column}': result[{index}]"
        else:
            text += f", '{column}': result[{index}]"
    for index, column in enumerate(nomalcolumn):
        text += f", '{column}': result[{len(pkcolumn) + index}]"
    for index, column in enumerate(['in_date', 'in_user_id', 'up_date', 'up_user_id']):
        text += f", '{column}': result[{len(pkcolumn) + len(nomalcolumn) + index}]"
    text += """})

        return res

    def myInsert(self"""
    for index, column in enumerate(pkcolumn):
        text += f", {column}"
    for index, column in enumerate(nomalcolumn):
        text += f", {column}"
    text += """, in_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'insert')
        self.cur.execute(sql, ("""
    for index, column in enumerate(pkcolumn):
        if not index:
            text += column
        else:
            text += f", {column}"
    for index, column in enumerate(nomalcolumn):
        text += f", {column}"
    text += """, in_user_id, in_user_id))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myUpdate(self"""
    for index, column in enumerate(pkcolumn):
        text += f", {column}"
    for index, column in enumerate(nomalcolumn):
        text += f", {column}"
    text += """, up_user_id):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'update')
        self.cur.execute(sql, ("""
    for index, column in enumerate(nomalcolumn):
        if not index:
            text += column
        else:
            text += f", {column}"
    text += """, up_user_id"""
    for index, column in enumerate(pkcolumn):
        text += f", {column}"
    text += """))
        self.conn.commit()
        result = self.cur.rowcount

        return result

    def myDelete(self"""
    for index, column in enumerate(pkcolumn):
        text += f", {column}"
    text += """):
        sql = mybatis_mapper2sql.get_child_statement(self.mapper, 'delete')
        self.cur.execute(sql, ("""
    for index, column in enumerate(pkcolumn):
        text += f"{column}, "
    text += """))
        self.conn.commit()
        result = self.cur.rowcount
        return result

    def __del__(self):
        self.cur.close()
        self.conn.close()
"""
    file.write(text)

text = f"""@app.route('/{table}')
def {table}():
    {table} = My{table.capitalize()}Dao().mySelect()

    return render_template('{table}.html', {table}s={table})


@app.route('/{table}_ins.ajax', methods=['POST', 'GET'])
def {table}insert():"""
for index, column in enumerate(pkcolumn):
    text += f"\n    {column} = request.form['{column}']"
for index, column in enumerate(nomalcolumn):
    text += f"\n    {column} = request.form['{column}']"
text += f"""
    in_user_id = escape(session["user_id"])

    try:
        if My{table.capitalize()}Dao().myInsert("""
for index, column in enumerate(pkcolumn):
    if not index:
        text += column
    else:
        text += ", " + column
for index, column in enumerate(nomalcolumn):
    text += ", " + column
text += f""", in_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/{table}_upd.ajax', methods=['POST'])
def {table}update():"""
for index, column in enumerate(pkcolumn):
    text += f"\n    {column} = request.form['{column}']"
for index, column in enumerate(nomalcolumn):
    text += f"\n    {column} = request.form['{column}']"
text += f"""
    up_user_id = escape(session["user_id"])

    try:
        if My{table.capitalize()}Dao().myUpdate("""
for index, column in enumerate(pkcolumn):
    if not index:
        text += column
    else:
        text += ", " + column
for index, column in enumerate(nomalcolumn):
    text += ", " + column
text += f""", up_user_id):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")


@app.route('/{table}_del.ajax', methods=['GET', 'POST'])
def {table}delete():"""
for index, column in enumerate(pkcolumn):
    text += f"\n    {column} = request.form['{column}']"
text += f"""

    try:
        if My{table.capitalize()}Dao().myDelete("""
for index, column in enumerate(pkcolumn):
    if not index:
        text += column
    else:
        text += ", " + column
text += """):
            return jsonify(msg="ok")
    except Exception as e:
        print(e)
    return jsonify(msg="ng")"""

print(text)





