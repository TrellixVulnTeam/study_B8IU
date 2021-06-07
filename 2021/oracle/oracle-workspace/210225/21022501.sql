2021-02-25-01)
	사용 예 1)
		사원테이블에서 각 부서별 급여 합계를 구하시오.
		Alias는 부서번호, 급여합계
			SELECT DEPARTMENT_ID AS 부서번호,
					SUM(SALARY) AS 급여합계
				FROM EMPLOYEES
				GROUP BY DEPARTMENT_ID
				ORDER BY DEPARTMENT_ID;

	사용 예 2)
		2005년 1 ~ 6월의 월별, 거래처별 매입정보를 조회하시오.
		Alias는 월, 거래처코드, 매입수량합, 매입금액합
			SELECT EXTRACT(MONTH FROM A.BUY_DATE)||'월' AS 월,
					B.PROD_BUYER AS 거래처코드,
					SUM(A.BUY_QTY) AS 매입수량합,
					SUM(A.BUY_QTY * B.PROD_COST) AS 매입금액합
				FROM BUYPROD A,
					PROD B
				WHERE A.BUY_PROD = B.PROD_ID
					AND EXTRACT(YEAR FROM A.BUY_DATE) = 2005
					AND EXTRACT(MONTH FROM A.BUY_DATE) BETWEEN 1 AND 6
				GROUP BY EXTRACT(MONTH FROM A.BUY_DATE),
					B.PROD_BUYER
				ORDER BY EXTRACT(MONTH FROM A.BUY_DATE),
					B.PROD_BUYER;

			SELECT EXTRACT(MONTH FROM A.BUY_DATE)||'월' AS 월,
					B.PROD_BUYER AS 거래처코드,
					SUM(A.BUY_QTY) AS 매입수량합,
					SUM(A.BUY_QTY * B.PROD_COST) AS 매입금액합
				FROM BUYPROD A,
					PROD B,
					BUYER C
				WHERE A.BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050630') -- 일반조건
					AND A.BUY_PROD = B.PROD_ID -- 조인조건
					AND B.PROD_BUYER = C.BUYER_ID -- 조인조건
				GROUP BY EXTRACT(MONTH FROM A.BUY_DATE),
					B.PROD_BUYER
				ORDER BY EXTRACT(MONTH FROM A.BUY_DATE),
					B.PROD_BUYER;

	사용 예 3)
		2005년 5월 회원별 구매정보를 조회하시오.
		단, 판매수량이 20개 이상인 회원만 조회하시오.
		Alias는 회원명, 판매수량합계
			SELECT B.MEM_NAME AS 회원명,
					SUM(A.CART_QTY) AS 판매수량합계
				FROM CART A,
					MEMBER B
				WHERE A.CART_MEMBER = B.MEM_ID -- 조인조건
					AND A.CART_NO LIKE '200505%' -- 일반조건
				GROUP BY B.MEM_NAME
				HAVING SUM(A.CART_QTY) >= 20
				ORDER BY SUM(A.CART_QTY) DESC;

	사용 예 4)
		2005년 5월 일별, 제품별 판매정보를 조회하시오.
		Alias는 일자, 제품코드, 판매수량합계, 판매금액합계
			SELECT TO_DATE(SUBSTR(A.CART_NO, 1, 8)) AS 일자,
				A.CART_PROD AS 제품코드,
				SUM(A.CART_QTY) AS 판매수량합계,
				SUM(B.PROD_SALE * A.CART_QTY) AS 판매금액합계
			FROM CART A,
				PROD B
			WHERE A.CART_PROD = B.PROD_ID
				AND A.CART_NO LIKE '200505%'
			GROUP BY SUBSTR(A.CART_NO, 1, 8),
				A.CART_PROD
			ORDER BY SUBSTR(A.CART_NO, 1, 8),
				A.CART_PROD;

2. AVG(col)
	- col에 저장된 데이터의 평균값을 구하여 반환

	사용 예)
		회원 테이블에서 회원의 성별 평균 마일리지를 조회하시오
			SELECT CASE
						WHEN MOD(SUBSTR(MEM_REGNO2, 1, 1), 2) = 0
							THEN '여성회원'
						ELSE '남성회원'
					END AS 성별,
					TRUNC(AVG(MEM_MILEAGE)) AS "평균 마일리지"
				FROM MEMBER
				GROUP BY CASE
						WHEN MOD(SUBSTR(MEM_REGNO2, 1, 1), 2) = 0
							THEN '여성회원'
						ELSE '남성회원'
					END
				ORDER BY CASE
						WHEN MOD(SUBSTR(MEM_REGNO2, 1, 1), 2) = 0
							THEN '여성회원'
						ELSE '남성회원'
					END;

			SELECT CASE
						WHEN SUBSTR(MEM_REGNO2, 1, 1) IN ('1', '3')
							THEN '남성회원'
						ELSE '여성회원'
					END AS 성별,
					TRUNC(AVG(MEM_MILEAGE)) AS 평균마일리지
				FROM MEMBER
				GROUP BY CASE
						WHEN SUBSTR(MEM_REGNO2, 1, 1) IN ('1', '3')
							THEN '남성회원'
						ELSE '여성회원'
					END
				ORDER BY CASE
						WHEN SUBSTR(MEM_REGNO2, 1, 1) IN ('1', '3')
							THEN '남성회원'
						ELSE '여성회원'
					END;

	숙제)
		회원 테이블에서 회원의 연령대별 평균 마일리지를 구하시오.
		구분에는 '10대', '20대', ... 등의 값을 출력한다.
		Alias는 구분, 평균마일리지
			SELECT TRUNC((EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) + 1) / 10) || '0대' AS 연령대,
					TRUNC(AVG(MEM_MILEAGE)) AS "평균 마일리지"
				FROM MEMBER
				GROUP BY TRUNC((EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) + 1) / 10)
				ORDER BY TRUNC((EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) + 1) / 10);

	사용 예)
		사원테이블에서 직무별 평균 급여를 소숫점 이하 한 자리까지 구하여 출력하시오.
		Alias는 직무명, 평균 급여
			SELECT JOBS.JOB_TITLE AS 직무명,
					ROUND(AVG(EMPLOYEES.SALARY), 1) AS 평균급여
				FROM EMPLOYEES, JOBS
				WHERE EMPLOYEES.JOB_ID = JOBS.JOB_ID
				GROUP BY JOBS.JOB_TITLE
				ORDER BY AVG(EMPLOYEES.SALARY) DESC;

	사용 예)
		대출잔액테이블에서 2013년 지역별 평균 대출 잔액을 조회하되, 평균 대출 잔액이 많은 상위 3개 시도만 출력하시오.
			SELECT A.R1 AS 지역,
					A.LAVG AS "평균 대출 잔액"
				FROM (
						SELECT REGION AS R1,
								TO_CHAR(ROUND(AVG(LOAN_JAN_AMT), 1), '999,999.9') AS LAVG
							FROM KOR_LOAN_STATUS
							WHERE PERIOD LIKE '2013%'
							GROUP BY REGION
							ORDER BY SUM(LOAN_JAN_AMT) DESC
					) A
				WHERE ROWNUM <= 3;

3. COUNT(* | col)
	- 그룹 내의 자료 ( 행 ) 의 수를 반환
	- '*'나 컬럼명을 기술해도 동일 결과 반환함
	단, 외부조인에 사용할 때 '*'를 사용해서 안됨. 주로 기본키 컬럼명을 사용

	사용 예)
		사원 테이블에서 부서별 사원 수를 조회하시오.
			SELECT DEPARTMENT_ID AS "부서 코드",
					COUNT(*) AS "사원 수",
					COUNT(EMP_NAME) AS "사원 수"
				FROM EMPLOYEES
				GROUP BY DEPARTMENT_ID
				ORDER BY DEPARTMENT_ID;

	사용 예)
		장바구니 테이블에서 회원별 구매횟수를 조회하되,
		구매횟수가 5 이상인 회원만 출력하시오.
			SELECT CART_MEMBER AS 회원번호,
					COUNT(DISTINCT CART_NO) AS 구매횟수
				FROM CART
				GROUP BY CART_MEMBER
				HAVING COUNT(DISTINCT CART_NO) >= 5
				ORDER BY COUNT(DISTINCT CART_NO);

			SELECT A.AMEM AS 회원번호,
					COUNT(*) AS 구매횟수
				FROM (
						SELECT CART_MEMBER AS AMEM,
								CART_NO AS ANO,
								COUNT(*) AS CNT
							FROM CART
							GROUP BY CART_MEMBER,
								CART_NO
					) A
				GROUP BY A.AMEM
				HAVING COUNT(*) >= 5
				ORDER BY COUNT(*);

			SELECT A.CMEM AS 회원번호,
					COUNT(*) AS 구매횟수
				FROM (
						SELECT DISTINCT CART_MEMBER AS CMEM,
								CART_NO
							FROM CART
							ORDER BY CART_MEMBER
					) A
				GROUP BY A.CMEM
				HAVING COUNT(*) >= 5
				ORDER BY COUNT(*);

	사용 예)
		2005년 3월 모든 거래처 별 제품 매입 건수를 조회하시오.
		Alias는 거래처코드, 거래처명, 매입건수
			SELECT D.BUYER_ID AS 거래처코드,
					D.BUYER_NAME AS 거래처명,
					NVL(C.CNT, 0) AS 매입건수
				FROM (
						SELECT B.PROD_BUYER AS BCODE,
								COUNT(A.BUY_PROD) AS CNT
							FROM BUYPROD A,
								PROD B
							WHERE A.BUY_PROD = B.PROD_ID
								AND EXTRACT(YEAR FROM A.BUY_DATE) = 2005
								AND EXTRACT(MONTH FROM A.BUY_DATE) = 3
							GROUP BY B.PROD_BUYER
					) C,
					BUYER D
				WHERE D.BUYER_ID = C.BCODE(+)
				ORDER BY D.BUYER_ID;

			SELECT B.BUYER_ID AS 거래처코드,
					B.BUYER_NAME AS 거래처명,
					COUNT(A.BUY_PROD) AS 매입건수
				FROM BUYPROD A
					RIGHT OUTER JOIN PROD C
						ON(
								C.PROD_ID = A.BUY_PROD
								AND EXTRACT(YEAR FROM A.BUY_DATE) = 2005
								AND EXTRACT(MONTH FROM A.BUY_DATE) = 3
							)
					RIGHT OUTER JOIN BUYER B
						ON(
								B.BUYER_ID = C.PROD_BUYER
							)
				GROUP BY B.BUYER_ID,
					B.BUYER_NAME
				ORDER BY B.BUYER_ID;

			SELECT D.BUYER_ID AS 거래처코드,
					D.BUYER_NAME AS 거래처명,
					NVL(TBLA.CNT, 0) AS 매입건수
				FROM (
						SELECT B.BUYER_ID AS BCODE,
								COUNT(A.BUY_PROD) AS CNT
							FROM BUYPROD A,
								BUYER B,
								PROD C
							WHERE C.PROD_ID = A.BUY_PROD
								AND B.BUYER_ID = C.PROD_BUYER
								AND A.BUY_DATE BETWEEN '20050301' AND '20050331'
							GROUP BY B.BUYER_ID
					) TBLA,
					BUYER D
				WHERE D.BUYER_ID = TBLA.BCODE(+)
				ORDER BY D.BUYER_ID;