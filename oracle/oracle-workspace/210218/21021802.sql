2021-02-18-02) 연산자
	- 사칙연산자 ( +, -, /, * )
	- 나머지 값은 MOD()와 REMAINDER() 함수로 제공
	- 관계연산자 ( >, >=, <, <=, =, !=(<>) )
	- 논리연산자 ( AND, OR, NOT )
1. 기타연산자
	1) IN 연산자
		- 주어진 값 중 어느 하나와 일치하면 전체가 참 ( TRUE ) 가 되는 연산자
		- OR 연산자로 바꾸어 쓸 수 있다.

		사용 형식
			컬럼명 IN ( 값1, 값2, ..., 값n )

		. WHERE 절의 조건 구성에 사용

		사용 예)
			사원 테이블에서 부서가 60, 40, 20 번 부서에 속한 사원정보를 조회하시오.
			Alias는 사원번호, 사원명, 부서번호, 입사일이다.

				SELECT EMPLOYEE_ID AS 사원번호,
						EMP_NAME AS 사원명,
						DEPARTMENT_ID AS 부서번호,
						HIRE_DATE AS 입사일
					FROM EMPLOYEES
--					WHERE DEPARTMENT_ID IN (60, 40, 20)
					WHERE DEPARTMENT_ID = 60
						OR DEPARTMENT_ID = 40
						OR DEPARTMENT_ID = 20
					ORDER BY 3;

	2) ANY ( SOME ) 연산자
		- 기능은 IN 연산자와 동일함

		사용 형식
			컬럼명 관계연산자ANY|SOME (값1, 값2, ..., 값n)

		사용 예)
			사원 테이블에서 부서가 60, 40, 20 번 부서에 속한 사원정보를 조회하시오.
			Alias는 사원번호, 사원명, 부서번호, 입사일이다.

				SELECT EMPLOYEE_ID AS 사원번호,
						EMP_NAME AS 사원명,
						DEPARTMENT_ID AS 부서번호,
						HIRE_DATE AS 입사일
					FROM EMPLOYEES
--					WHERE DEPARTMENT_ID = ANY (60, 40, 20)
					WHERE DEPARTMENT_ID = SOME (60, 40, 20)
					ORDER BY 3;

	3) BETWEEN 연산자
		- 범위를 지정하여 비교할 때 사용
		- AND 연산자로 변환 가능

		사용 형식
			컬럼명 BETWEEN A AND B

		. 컬럼에 저장된 값의 범위가 A ~ B 사이 값이면 참 ( TRUE ) 반환

		예)
			매입테이블 ( BUYPROD ) 에서 2005년 2월 5일부터 16일 사이에 입고된 상품정보를 조회하시오.
			Alias는 날짜, 상품코드, 수량, 단가, 금액이다.
				SELECT BUY_DATE AS 날짜,
						BUY_PROD AS 상품코드,
						BUY_QTY AS 수량,
						BUY_COST AS 단가,
						BUY_QTY * BUY_COST AS 금액
					FROM BUYPROD
					WHERE BUY_DATE BETWEEN '20050205' AND '20050216';

		문제]
			회원테이블에서 40대 여성회원의 보유 마일리지를 조회하시오.
				SELECT MEM_ID AS 회원번호,
						MEM_NAME AS 이름,
						MEM_BIR AS 생일,
						TO_NUMBER(SUBSTR(TO_CHAR(SYSDATE), 1, 4)) - (1900 + TO_NUMBER(SUBSTR(MEM_REGNO1, 1, 2))) + 1 AS 나이,
						MEM_MILEAGE AS 마일리지
					FROM MEMBER
					WHERE SUBSTR(MEM_REGNO2, 1, 1) = ANY (2, 4)
						AND TO_NUMBER(SUBSTR(TO_CHAR(SYSDATE), 1, 4)) - (1900 + TO_NUMBER(SUBSTR(MEM_REGNO1, 1, 2))) + 1 BETWEEN 40 AND 49;