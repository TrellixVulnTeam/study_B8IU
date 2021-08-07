import cx_Oracle
import numpy as np

conn = cx_Oracle.connect('python/python@localhost:1521/xe')
cs = conn.cursor()
rs = cs.execute("select learn400,action from tetris")

arr_x = []
arr_y = []

for record in cs:
    learn400 = record[0]
    action = record[1]
    if action == None:
        continue
    int_action = int(action)
    line = []
    for i in range(len(learn400)):
        temp = int(learn400[i:i + 1])
        line.append(temp)
    arr_x.append(line)
    arr_y.append(int_action)

numpy_x = np.array(arr_x)
numpy_y = np.array(arr_y)

print(numpy_x)
print(numpy_y)

np.save("numpy_x", numpy_x)
np.save("numpy_y", numpy_y)

cs.close()
conn.close()    
