text = """<td>{{suser.get('title')}}</td>"""

for j, i in enumerate(['s_id', 'title', 'content', 'interview_cnt', 'deadline', 'in_date', 'in_user_id', 'up_date', 'up_user_id']):
    print(i + ", ", end='')

# text = '''TITLE,
#         CONTENT,
#         INTERVIEW_CNT,
#         DEADLINE,
#         IN_DATE,
#         IN_USER_ID,
#         UP_DATE,
#         UP_USER_ID'''
# for i in text.split(','):
#     print(i.strip().lower() + ",", end=" ")
