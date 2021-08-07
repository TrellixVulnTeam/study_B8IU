DELETE FROM OMOK;
ALTER TABLE OMOK MODIFY HISTORY VARCHAR(400);

SELECT *
    FROM OMOK
    ORDER BY PAN,
        PSEQ;

SELECT S_SEQ, QUESTION, A1, A2, A3, A4 FROM SDETAIL
WHERE SURVEY_ID = 3;

SELECT DISTINCT S_SEQ AS 문항,
        ANSWER AS 답,
        COUNT(ANSWER) OVER(PARTITION BY ANSWER) AS 개수
        FROM SRESULT
    WHERE SURVEY_ID = 3;

SELECT * FROM SDETAIL;

SELECT * FROM SRESULT;

SELECT S_SEQ,
        QUESTION,
        A1,
        A2,
        A3,
        A4,
        (
            SELECT COUNT(*)
                FROM SRESULT B
                WHERE A.SURVEY_ID = B.SURVEY_ID
                    AND A.S_SEQ = B.S_SEQ
                    AND ANSWER = 1
        ) AS A1_COUNT,
        (
            SELECT COUNT(*)
                FROM SRESULT B
                WHERE A.SURVEY_ID = B.SURVEY_ID
                    AND A.S_SEQ = B.S_SEQ
                    AND ANSWER = 2
        ) AS A2_COUNT,
        (
            SELECT COUNT(*)
                FROM SRESULT B
                WHERE A.SURVEY_ID = B.SURVEY_ID
                    AND A.S_SEQ = B.S_SEQ
                    AND ANSWER = 3
        ) AS A3_COUNT,
        (
            SELECT COUNT(*)
                FROM SRESULT B
                WHERE A.SURVEY_ID = B.SURVEY_ID
                    AND A.S_SEQ = B.S_SEQ
                    AND ANSWER = 4
        ) AS A4_COUNT
    FROM SDETAIL A
WHERE SURVEY_ID = 3;


