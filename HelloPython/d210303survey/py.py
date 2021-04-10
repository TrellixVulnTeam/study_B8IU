text = '''<tr>
                    <td><label>s_id</label><input type="text" name="s_id" id="s_id"></td>
                </tr>'''
for i, j in enumerate(["survey_id", "s_seq", "question", "a1", "a2", "a3", "a4", "in_date", "in_user_id", "up_date", "up_user_id"]):
    print(text.replace('s_id', j), end="")

# "survey_id", "s_seq", "question", "a1", "a2", "a3", "a4", "in_date", "in_user_id", "up_date", "up_user_id"
# survey_id, s_seq, question, a1, a2, a3, a4, in_date, in_user_id, up_date, up_user_id
