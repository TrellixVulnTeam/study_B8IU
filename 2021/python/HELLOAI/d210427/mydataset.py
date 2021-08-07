# 필요한 라이브러리 불러오기
import cx_Oracle
import numpy as np
import tensorflow as tf

conn = cx_Oracle.connect('python/python@localhost:1521/xe')
cur = conn.cursor()
sql = """SELECT LEARN400, ACTION
FROM TETRIS
WHERE ACTION IS NOT NULL
    AND LENGTH(LEARN400) = 400
    AND (
              ACTION = 0
              OR ACTION = 1
                  AND (SUBSTR(LEARN400, 001, 1) = 0
                  AND SUBSTR(LEARN400, 011, 1) = 0
                  AND SUBSTR(LEARN400, 021, 1) = 0
                  AND SUBSTR(LEARN400, 031, 1) = 0
                  AND SUBSTR(LEARN400, 041, 1) = 0
                  AND SUBSTR(LEARN400, 051, 1) = 0
                  AND SUBSTR(LEARN400, 061, 1) = 0
                  AND SUBSTR(LEARN400, 071, 1) = 0
                  AND SUBSTR(LEARN400, 081, 1) = 0
                  AND SUBSTR(LEARN400, 091, 1) = 0
                  AND SUBSTR(LEARN400, 101, 1) = 0
                  AND SUBSTR(LEARN400, 111, 1) = 0
                  AND SUBSTR(LEARN400, 121, 1) = 0
                  AND SUBSTR(LEARN400, 131, 1) = 0
                  AND SUBSTR(LEARN400, 141, 1) = 0
                  AND SUBSTR(LEARN400, 151, 1) = 0
                  AND SUBSTR(LEARN400, 161, 1) = 0
                  AND SUBSTR(LEARN400, 171, 1) = 0
                  AND SUBSTR(LEARN400, 181, 1) = 0
                  AND SUBSTR(LEARN400, 191, 1) = 0))
   OR ACTION = 2
   OR (ACTION = 3
           AND SUBSTR(LEARN400, 010, 1) = 0
    AND SUBSTR(LEARN400, 020, 1) = 0
    AND SUBSTR(LEARN400, 030, 1) = 0
    AND SUBSTR(LEARN400, 040, 1) = 0
    AND SUBSTR(LEARN400, 050, 1) = 0
    AND SUBSTR(LEARN400, 060, 1) = 0
    AND SUBSTR(LEARN400, 070, 1) = 0
    AND SUBSTR(LEARN400, 080, 1) = 0
    AND SUBSTR(LEARN400, 090, 1) = 0
    AND SUBSTR(LEARN400, 100, 1) = 0
    AND SUBSTR(LEARN400, 110, 1) = 0
    AND SUBSTR(LEARN400, 120, 1) = 0
    AND SUBSTR(LEARN400, 130, 1) = 0
    AND SUBSTR(LEARN400, 140, 1) = 0
    AND SUBSTR(LEARN400, 150, 1) = 0
    AND SUBSTR(LEARN400, 160, 1) = 0
    AND SUBSTR(LEARN400, 170, 1) = 0
    AND SUBSTR(LEARN400, 180, 1) = 0
    AND SUBSTR(LEARN400, 190, 1) = 0
    AND SUBSTR(LEARN400, 200, 1) = 0)"""
cur.execute(sql)

tetrisdata = np.array(cur.fetchall())
numpy_x = np.array([list(data[0]) for data in tetrisdata[:, :1]], dtype='float32')
numpy_y = tetrisdata[:, 1:].astype(np.int)

np.save("numpy_x", numpy_x)
np.save("numpy_y", numpy_y)

conn.close()
