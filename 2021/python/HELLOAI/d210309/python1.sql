SELECT * FROM SUSER;
UPDATE SUSER SET USER_NAME='������' WHERE USER_ID = 1;
UPDATE SUSER SET USER_ID='s00001' WHERE USER_ID = 1;
UPDATE SUSER SET PWD='01022223333' WHERE USER_ID='s00001';
UPDATE SUSER SET USER_ID='s00002' WHERE USER_ID = 2;

COMMIT;

--�������
CREATE TABLE SRESULT(
    SURVEY_ID NUMBER,
    S_SEQ NUMBER,
    ST_MOBILE VARCHAR2(11),
    ANSWER VARCHAR(1),
    IN_DATE VARCHAR2(15),
    IN_USER_ID VARCHAR2(20),
    UP_DATE VARCHAR2(15),
    UP_USER_ID VARCHAR2(20),
    
    CONSTRAINT PK_SRESULT PRIMARY KEY(SURVEY_ID, S_SEQ, ST_MOBILE)
);