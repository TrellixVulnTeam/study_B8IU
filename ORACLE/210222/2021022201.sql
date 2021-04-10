2021-02-22-01) 문자열 함수 ..cont
	6) SUBSTR
		- 원본 문자열에서 정의된 길이만큼의 부분문자열을 추출함
		- 결과도 문자열임

		사용 형식
			SUBSTR(c, n[, len])

		. 주어진 문자열 c 중 n번째에서 len의 갯수만큼 문자열을 추출하여 반환
		. n이 0 또는 1이면 첫 번째 글자부터 처리
		. n이 음수이면 뒷자리부터 처리
		. len이 생략되면 n자리 이후 모든 문자열 반환

		사용 예)
			장바구니 테이블에서 2005년 7월 판매자료를 조회하시오.
			Alias는 판매일자, 구매자, 상품명, 수량
				SELECT TO_DATE(SUBSTR(C.CART_NO, 1, 8)) AS 판매일자,
						M.MEM_NAME AS 구매자,
						P.PROD_NAME AS 상품명,
						C.CART_QTY AS 수량
					FROM CART C, MEMBER M, PROD P
					WHERE C.CART_PROD = P.PROD_ID
						AND C.CART_MEMBER = M.MEM_ID
						AND SUBSTR(C.CART_NO, 1, 6) = '200507';

		사용 예)
			사원테이블 ( EMPLOYEES ) 에서 판매관련 직책 ( SALES)을 부여받은 사원정보를 조회하시오.
			Alias는 사원번호, 사원명, 부서명, 직책코드, 급여이다.
				SELECT E.EMPLOYEE_ID AS 사원번호,
						E.EMP_NAME AS 사원명,
						D.DEPARTMENT_NAME AS 부서명,
						E.JOB_ID AS 직책코드,
						E.SALARY AS 급여
					FROM EMPLOYEES E, DEPARTMENTS D
					WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
						AND SUBSTR(JOB_ID, 1, 2) = 'SA'
					ORDER BY E.SALARY DESC;

		문제 1)
			회원 테이블에서 김씨 성을 가진 회원정보를 출력하시오.
			Alias는 회원번호, 회원명, 성별, 마일리지이다.
			SELECT MEM_ID AS 회원번호,
					MEM_NAME AS 회원명,
					CASE
						WHEN SUBSTR(MEM_REGNO2, 1, 1) IN('1', '3')
							THEN '남성회원'
						ELSE '여성회원'
					END AS 성별,
					MEM_MILEAGE AS 마일리지
				FROM MEMBER
				WHERE SUBSTR(MEM_NAME, 1, 1) = '김';
--				WHERE MEM_NAME LIKE '김%';

	7) REPLACE
		- 특정 문자열을 찾아 다른 문자열로 대치시킴

		사용 형식
			REPLACE(c1, c2[, c3])

		. 주어진 문자열 c1에서 c2 문자열을 모두 찾아 c3 문자열로 대치
		. c3가 생략되면 찾은 문자열을 제거 함 ( 문자열 내부의 공백 제거에 사용 )

		사용 예)
			SELECT ' ILPOSTINO BOYHOOD' AS NORMAL,
					TRIM(' ILPOSTINO BOYHOOD') AS TRIM,
					REPLACE(' ILPOSTINO BOYHOOD', ' ') AS REPLACE,
					REPLACE(' ILPOSTINO BOYHOOD', ' ', '*') AS REPLACE
				FROM DUAL;

		문제)
			사원 테이블에서 전화번호를 xxx-xxx-xxxx 형식으로 출력하시오.
			단, 2005년 이후 입사한 사원을 대상으로 한다.
			Alias는 사원번호, 사원명, 전화번호, 비고이다.
			비고는 '재직중', '퇴직' 중 하나를 출력할 것
				SELECT EMPLOYEE_ID AS 사원번호,
						EMP_NAME AS 사원명,
						REPLACE(PHONE_NUMBER, '.', '-') AS 전화번호,
						CASE
							WHEN RETIRE_DATE IS NULL
								THEN '재직중'
							ELSE '퇴직'
						END AS 비고
					FROM EMPLOYEES
					WHERE HIRE_DATE >= TO_DATE('20050101')
--					WHERE EXTRACT(YEAR FROM HIRE_DATE) >= 2005
					ORDER BY HIRE_DATE;
--					ORDER BY EMPLOYEE_ID;

	8) INSTR
		- 문자열에서 특정 문자열의 위치값 ( INDEX ) 을 반환

		사용 형식
			INSTR(c1, c2[, m[, n]])

		. 주어진 문자열 c1에서 c2 문자열이 처음 출현한 위치 반환
		. m은 검사할 특정 위치를 지정할 때 사용되는 INDEX
		. n은 반복되어 표현된 문자열 중 반복된 횟수를 특정하여 검색할 때 사용

		사용 예)
			SELECT EMP_NAME,
					INSTR(EMP_NAME, 'o'),
					INSTR(EMP_NAME, 'o', 3),
					INSTR(EMP_NAME, 'o', 2, 2)
				FROM  EMPLOYEES
				WHERE DEPARTMENT_ID = 50;

	9) LENGTH, LENGTHB
		- 문자열의 길이나 문자열 내의 문자의 수를 반환

		사용 형식
			LENGTH(c), LENGTHB(c)

		. LENGTH(c) : c 문자열 내의 문자의 수
		. LENGTHB(c) : c 문자열의 길이 ( byte 수 )
		. 한글 한 글자는 3byte로 표현 됨