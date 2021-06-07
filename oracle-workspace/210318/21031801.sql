2021-03-18-01)
/
--�Լ� ����
--������ ���� ����Ͻÿ�
--��ǰ�ڵ�, ��ǰ��, ��з��ڵ�, ��з���
--�Լ��� ���. �Լ����� FN_PRODNM
CREATE OR REPLACE FUNCTION FN_PRODNM(P_LPROD_GU IN LPROD.LPROD_GU % TYPE)
	RETURN VARCHAR2
IS
	R_LPROD_NM LPROD.LPROD_NM % TYPE;
BEGIN
	SELECT LPROD_NM
		INTO R_LPROD_NM
		FROM LPROD
		WHERE LPROD_GU = P_LPROD_GU;
	RETURN R_LPROD_NM;
EXCEPTION
	WHEN OTHERS
		THEN
			RETURN NULL;
END;
/
SELECT PROD_ID,
		PROD_NAME,
		PROD_LGU,
		FN_PRODNM(PROD_LGU)
	FROM PROD
	ORDER BY PROD_ID;
/
--�Լ�����2
--������ ���� ����Ͻÿ�.
--��ٱ����ڵ�, ��ǰ�ڵ�, �ǸŰ���, ȸ�����̵�, ȸ����
--�Լ��� ���, �Լ����� FN_GET_MEM_NM
CREATE OR REPLACE FUNCTION FN_GET_MEM_NM(P_CART_MEMBER VARCHAR2)
	RETURN VARCHAR2
IS
	R_MEM_NAME MEMBER.MEM_NAME % TYPE;
BEGIN
	SELECT MEM_NAME
		INTO R_MEM_NAME
		FROM MEMBER
		WHERE MEM_ID = P_CART_MEMBER;
	RETURN R_MEM_NAME;
EXCEPTION
	WHEN OTHERS
		THEN
			RETURN NULL;
END;
/
SELECT CART_NO,
		CART_PROD,
		CART_QTY,
		CART_MEMBER,
		FN_GET_MEM_NM(CART_MEMBER)
	FROM CART
    ORDER BY CART_NO,
        CART_PROD;
/
--�Լ� ���� 3
--������ ���� ����Ͻÿ�.
--�ּ�1�� �޾Ƽ� ���������� ����
--ȸ�����̵� ȸ���� ��������
--�Լ��� ���. �Լ����� FN_GET_CITY
CREATE OR REPLACE FUNCTION FN_GET_CITY(P_MEM_ID MEMBER.MEM_ID % TYPE)
	RETURN VARCHAR2
IS
	R_MEM_ADD MEMBER.MEM_REGNO1 % TYPE;
BEGIN
	SELECT SUBSTR(MEM_ADD1, 1, 2)
		INTO R_MEM_ADD
		FROM MEMBER
		WHERE MEM_ID = P_MEM_ID;
	RETURN R_MEM_ADD;
EXCEPTION
	WHEN OTHERS
		THEN
			RETURN NULL;
END;
/
SELECT MEM_ID AS ȸ�����̵�,
		MEM_NAME AS ȸ����,
		FN_GET_CITY(MEM_ID) AS ��������
	FROM MEMBER
	ORDER BY MEM_ID;
/
--�Լ�����4
--2005�⵵ ��ǰ�з� ��
--��ǰ�з� �� �� �Ǹűݾ� ( SUM ( PROD_SALE * CART_QTY ) ) �� ���
CREATE OR REPLACE FUNCTION ALL_SALE_AMT(
		P_LPROD_GU VARCHAR2,
		P_YEAR NUMBER
	)
	RETURN NUMBER
IS
	R_SALE_AMT NUMBER;
BEGIN
	SELECT NVL(SUM(A.CART_QTY * B.PROD_SALE), 0)
		INTO R_SALE_AMT
		FROM CART A, PROD B
		WHERE A.CART_PROD = B.PROD_ID
			AND A.CART_NO LIKE P_YEAR || '%'
			AND B.PROD_LGU = P_LPROD_GU;
	RETURN R_SALE_AMT;
EXCEPTION
	WHEN OTHERS
		THEN
			RETURN 0;
END;
/
SELECT LPROD_GU AS ��ǰ�з��ڵ�,
		LPROD_NM AS ��ǰ�з���,
		ALL_SALE_AMT(LPROD_GU, 2005) AS ���Ǹűݾ�
	FROM LPROD;
/
SET SERVEROUTPUT ON;
/
--P.23
--Ʈ���� ����
CREATE OR REPLACE TRIGGER TG_LPROD_IN
	AFTER INSERT
	ON LPROD
BEGIN
	DBMS_OUTPUT.PUT_LINE('��ǰ�з��� �߰��Ǿ����ϴ�.');
END;
/
INSERT INTO LPROD(LPROD_ID, LPROD_GU, LPROD_NM)
	VALUES(22, 'P212', '�׽�Ʈ2');
INSERT INTO LPROD(LPROD_ID, LPROD_GU, LPROD_NM)
	VALUES(23, 'P213', '�׽�Ʈ3');
INSERT INTO LPROD(LPROD_ID, LPROD_GU, LPROD_NM)
	VALUES(24, 'P214', '�׽�Ʈ4');
/
ROLLBACK;
/
CREATE TABLE EMP01(
	EMPNO NUMBER(4) PRIMARY KEY,
	EMPNAME VARCHAR2(45),
	EMPJOB VARCHAR2(60)
);
CREATE TABLE SAL01(
	SALNO NUMBER(4) PRIMARY KEY,
	SAL NUMBER(7, 2),
	EMPNO NUMBER(4) REFERENCES EMP01(EMPNO)
);
CREATE SEQUENCE SAL01_SALNO_SEQ
	INCREMENT BY 1
	START WITH 1;

CREATE OR REPLACE TRIGGER TRG_02
	AFTER INSERT ON EMP01
FOR EACH ROW
BEGIN
	INSERT INTO SAL01 VALUES (SAL01_SALNO_SEQ.NEXTVAL, 100, :NEW.EMPNO);
END;
/
INSERT INTO EMP01 VALUES(1, '������', '���α׷���');
INSERT INTO EMP01 VALUES(2, '�ڸ���', '���α׷���');
/
SELECT * FROM EMP01;
SELECT * FROM SAL01;
/