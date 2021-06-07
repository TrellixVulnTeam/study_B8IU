2021-03-10-02)
PL/SQL
	- PROCEDURAL LANGUAGE SQL의 약자
	- 표준 SQL은 프로그램의 흐름을 제어하는 기능과 변수 등의 기능을 제공하지 않음.
	- PL/SQL은 흐름제어 등의 기능을 제공하고,
		단일 가능을 수행하는 모듈 단위의 프로그램을 컴파일하여 실행 가능한 형태로 서버에 보관
	- BLOCK 구조로 구성
	- 모듈화, 캡슐화 기능 제공
	- Anonymus Block,
		Stored Procedure,
		User Defined Function,
		Package,
		trigger 등 제공

1. Annonymus Block
	- 이름이 부여되지 않은 블럭
	- PL/SQL의 기본 구조 제공

	구조
		DECLARE
			선언부;
		BEGIN
			실행부;
		[EXCEPTION
			예외처리부;
		]
		END;
	. '선언부'
		실해웁에서 사용할 변수, 상수, 커서 선언
	. '실행부'
		SELECT, DML 명령으로 구성된 비지니스 로직 처리 영역
	. '예외처리부'
		예외 발생 시 처리할 명령 기술

--SELECT * FROM LPROD;

	사용 예)
		키보드로 회원번호를 입력받아 회원정보를 출력하는 블록을 작성
		Alias는 회원번호, 회원명, 마일리지
			ACCEPT P_ID PROMPT '회원번호 : '
			DECLARE
				V_ID MEMBER.MEM_ID % TYPE;
				V_NAME MEMBER.MEM_NAME % TYPE;
				V_MILE NUMBER(5) := 0;
				V_RES VARCHAR2(100);
			BEGIN
				SELECT MEM_ID,
						MEM_NAME,
						MEM_MILEAGE
					INTO V_ID,
						V_NAME,
						V_MILE
					FROM MEMBER
					WHERE MEM_ID = '&P_ID';

				V_RES := V_ID || ', ' || V_NAME || ' → ' || V_MILE;

				DBMS_OUTPUT.PUT_LINE('--------------------');
				DBMS_OUTPUT.PUT_LINE(V_RES);
				DBMS_OUTPUT.PUT_LINE('--------------------');
			END;

	1)
		변수
			- 프로그램의 개발언어의 변수와 같은 역할
			- 실행부에서 사용

			선언 형식
				변수명 데이터타입[(크기)][ := 초기값];

			. 데이터 타입
				표준 sql에서 사용하는 데이터 타입
				BOOLEAN, PLS_INTEGER, BINARY_INTEGER 및 참조형 사용 가능
			. PLS_INTEGER, BINARY_INTEGER
				4byte 정수 ( -2147483648 ~ 2147483647 )
			. 참조형
				해당 테이블의 행 ( ROW ) 이나 열 ( COLUMN ) 과 동일한 타입 및 크기를 갖는 변수 선언
				테이블명.컬럼명 % TYPE
					컬럼 참조
				테이블명 % ROWTYPE
					해당 테이블 행을 모두 참조 ( 배열 효과 )
			. 숫자형 변수는 참조하기 전 반드시 초기화
	2)
		상수
			- 프로그램에서 변하지 않는 값을 표현
			- 상수는 할당연산자의 왼편 ( LEFT VALUE ) 로 사용 불가
			
			선언 형식
				변수명 CONSTANT 데이터타입[(크기)] := 값;

			. 반드시 초기화가 필요

	사용 예)
		월을 입력받아 2005년 해당 월에 매입집계를 출력하는 
		Alias는 상품코드, 상품명, 매입수량
			ACCEPT P_MONTH PROMPT '월 ( 1 ~ 12 ) : '
			DECLARE
				V_CODE PROD.PROD_ID % TYPE;
				V_NAME PROD.PROD_NAME % TYPE;
				V_QTY_AMT NUMBER := 0;
				V_SDATE CONSTANT DATE := TO_DATE('2005' || LTRIM(TO_CHAR(TO_NUMBER('&P_MONTH')), '00'), 'YYYYMM');
				V_EDATE CONSTANT DATE := ADD_MONTHS(TO_DATE('2005' || LTRIM(TO_CHAR(TO_NUMBER('&P_MONTH')), '00'), 'YYYYMM'), 1) - 1 / 24 / 60 / 60 / 100;
				CURSOR BUYQTY_CUR(V_SDATE DATE, V_EDATE DATE)
					IS
						SELECT BUY_PROD,
								PROD_NAME,
								SUM(BUY_QTY)
							FROM BUYPROD,
								PROD
							WHERE BUY_PROD = PROD_ID
								AND BUY_DATE BETWEEN V_SDATE AND V_EDATE
							GROUP BY BUY_PROD,
								PROD_NAME
							ORDER BY BUY_PROD,
								PROD_NAME;
			BEGIN
				OPEN BUYQTY_CUR(V_SDATE, V_EDATE);
				LOOP
					FETCH BUYQTY_CUR INTO V_CODE, V_NAME, V_QTY_AMT;
					EXIT WHEN BUYQTY_CUR % NOTFOUND;
					DBMS_OUTPUT.PUT_LINE('--------------------');
					DBMS_OUTPUT.PUT_LINE('상품코드	' || V_CODE);
					DBMS_OUTPUT.PUT_LINE('상품명	' || V_NAME);
					DBMS_OUTPUT.PUT_LINE('매입수량	' || V_QTY_AMT);
				END LOOP;
				DBMS_OUTPUT.PUT_LINE('--------------------');
				DBMS_OUTPUT.PUT_LINE('매입건수	' || BUYQTY_CUR % ROWCOUNT);
				DBMS_OUTPUT.PUT_LINE('--------------------');
			EXCEPTION WHEN OTHERS THEN
				DBMS_OUTPUT.PUT_LINE('예외발생	' || SQLERRM);
			END;

	3)
		분기문
			- 개발언어의 분기문 ( IF 문 ) 과 같은 기능 제공

			사용 형식
				IF 조건식 THEN
					명령문;
				[ELSE
					명령문;]
				END IF;

			사용 형식
				IF 조건식 THEN
					명령문;
				[ELSIF 조건식 THEN
					명령문;]
				[ELSE
					명령문;]
				END IF;

			사용 형식
				IF 조건식 THEN
					IF 조건식 THEN
						명령문;
					[ELSIF 조건식 THEN
						명령문;]
					[ELSE
						명령문;]
					END IF;
				[ELSIF 조건식 THEN
					IF 조건식 THEN
						명령문;
					[ELSIF 조건식 THEN
						명령문;]
					[ELSE
						명령문;]
					END IF;]
				[ELSE
					IF 조건식 THEN
						명령문;
					[ELSIF 조건식 THEN
						명령문;]
					[ELSE
						명령문;]
					END IF;]
				END IF;

	사용 예)
		부서번호 60번 부서에 속한 사원의 급여를 조회하여
		그 부서에서 첫 번째 조회된 사원의 급여가 5000이하이면 '저임금 사원',
		5001 - 15000 이면 '평균임금 사원',
		그 이상이면 '고임금 사원' 을 출력하는 블럭 작성
			DECLARE
				V_DEPT EMPLOYEES.EMPLOYEE_ID % TYPE := ROUND(DBMS_RANDOM.VALUE(10, 110), -1);
				V_EMP_NAME EMPLOYEES.EMP_NAME % TYPE;
				V_SALARY EMPLOYEES.SALARY % TYPE;
				V_MESSAGE VARCHAR2(100);
			BEGIN
				SELECT EMP_NAME,
						SALARY
					INTO V_EMP_NAME,
						V_SALARY
					FROM EMPLOYEES
					WHERE DEPARTMENT_ID = V_DEPT
						AND ROWNUM = 1;

				IF V_SALARY <= 5000 THEN
					V_MESSAGE := '저임금 사원';
				ELSIF V_SALARY <= 15000 THEN
					V_MESSAGE := '평균임금 사원';
				ELSE
					V_MESSAGE := '고임금 사원';
				END IF;

				V_MESSAGE := V_EMP_NAME || '	' || V_SALARY || ' → ' || V_MESSAGE;
				DBMS_OUTPUT.PUT_LINE(V_MESSAGE);
			END;




















