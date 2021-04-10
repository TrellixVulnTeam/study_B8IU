2021-02-10-02) 데이터 타입
	- 숫자형, 문자형, 날짜, 기타로 구분

1. 날짜형
	- 고정길이 형식 ( CHAR )
	- 가변길이 형식 ( VARCHAR, VARCHAR2, LONG, CLOB, NVARCHAR2, NCLOB )

	1) CHAR
		. 고정길이 문자열을 저장
		. 기억공간이 남으면 오른쪽에 공백이 삽입되어 저장
		. 데이터가 크면 오류
		. 주로 기본키의 데이터 타입으로 사용
		. 한글 한 글자는 3BYTE
		. 최대 2000BYTE까지 저장 가능

		사용 형식
			컬럼명 CHAR ( 크기[BYTE|CHAR] );

		- 크기 : 1 ~ 2000
		- BYTE|CHAR
			'크기'로 지정된 값이 BYTE 값인지, CHAR 갯수인지 지정
			'CHAR'로 지정되더라도 2000BYTE를 초과할 수 없음
			DEFAULT 값은 BYTE

		예)
			CREATE TABLE TEMP01 (
				COL1 CHAR(20 BYTE),
				COL2 CHAR(20 CHAR),
				COL3 CHAR(20)
			);

			INSERT INTO TEMP01(COL1, COL2, COL3)
				VALUES ('무궁화 꽃이', '무궁화 꽃이', 'ABCDEFGHIJKLMN');

			INSERT INTO TEMP01(COL1, COL2, COL3)
				VALUES ('무궁화 꽃이', '무궁화 꽃이 피었습니다. 무궁화 꽃은 우', 'ABCDEFGHIJKLMN');

			SELECT LENGTHB(COL1),
					LENGTHB(COL2),
					LENGTHB(COL3)
				FROM TEMP01;

			SELECT *
				FROM TEMP01;


	2) VARCHAR2
		. 가변길이 문자열을 저장
		. 1 ~ 4000 BYTE 처리 가능
		. ORACLE에서만 사용 가능한 데이터 타입 ( 다른 DBMS에서는 VARCHAR를 사용 )

		사용 형식
			컬럼명 VARCHAR2(크기[BYTE|CHAR])

		- 크기 : 1 ~ 4000
		- BYTE|CHAR
			'크기'로 지정된 값이 BYTE값인지 CHAR 갯수인지 지정
			'CHAR'로 지정되더라도 4000BYTE를 초과할 수 없으며,
			DEFAULT 값은 BYTE이다.

		사용 예)
			CREATE TABLE TEMP02 (
				COL1 VARCHAR2(50),
				COL2 VARCHAR2(50 CHAR),
				COL3 VARCHAR2(50 BYTE)
			);

			INSERT INTO TEMP02(COL1, COL2, COL3)
				VALUES ('무궁화 꽃이', '무궁화 꽃이', 'ABCDEFGHIJKLMN');

			INSERT INTO TEMP02(COL1, COL2, COL3)
				VALUES ('무궁화 꽃이', '무궁화 꽃이 피었습니다. 무궁화 꽃은 우', 'ABCDEFGHIJKLMN');

			SELECT LENGTHB(COL1),
					LENGTHB(COL2),
					LENGTHB(COL3)
				FROM TEMP02;

			SELECT *
				FROM TEMP02;

	3) NVARCHAR2, VARCHAR
		. VARCHAR와 VARCHAR2는 동일 기능 제공
		. ORACLE 사에서는 VARCHAR2 사용을 권고
		. NVARCHAR2는 국제표준코드(다국적 언어)를 사용하여 문자열 저장
		. UTF-8(가변길이), UTF-16(고정길이) 형식으로 처리

	4) LONG
		. 대용량 가변길이 자료를 저장
		. 2GB까지 처리 가능
		. 제약사항 : 한 테이블에 한 컬럼만 LONG 타입으로 선언 가능
		. CLOB 타입으로 대체 ( 현재 기능 개선이 종료 됨 )

		사용 형식
			컬럼명 LONG;

		사용 예)
			CREATE TABLE TEMP03 (
				COL1 LONG,
				COL2 CLOB,
				COL3 VARCHAR2(3000)
			);

			INSERT INTO TEMP03(COL1, COL2, COL3)
				VALUES ('무궁화 꽃이', '무궁화 꽃이', 'ABCDEFGHIJKLMN');

			INSERT INTO TEMP03(COL1, COL2, COL3)
				VALUES ('무궁화 꽃이', '무궁화 꽃이 피었습니다. 무궁화 꽃은 우', 'ABCDEFGHIJKLMN');

			SELECT LENGTHB(COL1),
					LENGTHB(COL2),
					LENGTHB(COL3)
				FROM TEMP03;

			SELECT *
				FROM TEMP03;

			SELECT DBMS_LOB.GETLENGTH(COL2),
					LENGTHB(COL3)
				FROM TEMP03;


	5) CLOB
		. LOB ( Large Objects ) 타입
		. 대용량 자료 ( 4GB ) 를 저장하기 위한 가변길이 데이터 타입
		. 여러 칼럼에서 동시에 사용 가능 ( LONG 타입 개선 )
		. 일부 기능은 DBMS_LOB API 지원을 받아야 함 ( LENGTH, SUBSTR 등 )

		사용 형식
			컬럼명 CLOB;

		CREATE TABLE TEMP04 (
			COL1 CLOB,
			COL2 CLOB,
			COL3 VARCHAR2(1000)
		);

		INSERT INTO TEMP04(COL1, COL2, COL3)
			VALUES ('무궁화 꽃이', '무궁화 꽃이', 'ABCDEFGHIJKLMN');

		INSERT INTO TEMP04(COL1, COL2, COL3)
			VALUES ('무궁화 꽃이', '무궁화 꽃이 피었습니다. 무궁화 꽃은 우', 'ABCDEFGHIJKLMN');

		SELECT DBMS_LOB.GETLENGTH(COL1),
				DBMS_LOB.GETLENGTH(COL2),
				LENGTHB(COL3)
			FROM TEMP04;

		SELECT *
			FROM TEMP04;

		SELECT SUBSTR(COL3, 2, 5)
			FROM TEMP04;

		SELECT DBMS_LOB.SUBSTR(COL2, 2, 5)
			FROM TEMP04;

		SELECT LENGTH(COL2),
				LENGTH(COL3)
			FROM TEMP04;

		SELECT DBMS_LOB.GETLENGTH(COL2) AS "데이터 길이"
			FROM TEMP04;

		SELECT TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일" AM HH:MI:SS') AS "SYSDATE"
			FROM DUAL;