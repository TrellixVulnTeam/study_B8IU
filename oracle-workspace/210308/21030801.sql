2021-03-08-01)
3. 단일 행 서브쿼리
	- 서브쿼리의 결과가 1개의 행으로 구성된 경우
	- 관계연산자가 사용된 경우 ( 조건 )
	
	사용 예)
		회원 테이블에서 회원의 평균 마일리지보다 많은 마일리지를 보유한 회원정보
		Alias는 회원번호, 회원명, 마일리지, 평균마일리지
			SELECT MEM_ID AS 회원번호,
					MEM_NAME AS 회원명,
					MEM_MILEAGE AS 마일리지,
					(
						SELECT ROUND(AVG(MEM_MILEAGE), 1)
							FROM MEMBER
					)AS 평균마일리지
				FROM MEMBER
				WHERE MEM_MILEAGE >= (
						SELECT AVG(MEM_MILEAGE)
							FROM MEMBER
					);

			SELECT A.MEM_ID AS 회원번호,
					A.MEM_NAME AS 회원명,
					A.MEM_MILEAGE AS 마일리지,
					ROUND(B.AVG_MILEAGE, 1) AS 평균마일리지
				FROM MEMBER A,
					(
						SELECT AVG(MEM_MILEAGE) AS AVG_MILEAGE
							FROM MEMBER
					) B
				WHERE A.MEM_MILEAGE >= B.AVG_MILEAGE;

	사용 예)
		2005년 6월 모든 회원 별 구매 현황을 조회하시오.
		Alias는 회원번호, 회원명, 구매수량합계, 구매금액합계
			SELECT C.MEM_ID AS 회원번호,
					C.MEM_NAME AS 회원명,
					NVL(SUM(A.CART_QTY), 0) AS 구매수량합계,
					NVL(SUM(A.CART_QTY * PROD_SALE), 0) AS 구매금액합계
				FROM CART A
					INNER JOIN PROD B
						ON(
						A.CART_PROD = B.PROD_ID
						AND A.CART_NO LIKE '200506%'
						)
					RIGHT OUTER JOIN MEMBER C
						ON(A.CART_MEMBER = C.MEM_ID)
				GROUP BY C.MEM_ID,
					C.MEM_NAME
				ORDER BY C.MEM_ID;

			SELECT B.MEM_ID AS 회원번호,
					B.MEM_NAME AS 회원명,
					NVL(D.SQTY, 0) AS 구매수량합계,
					NVL(D.SAMT, 0) AS 구매금액합계
				FROM MEMBER B,
					(
						SELECT B.CART_MEMBER AS DID,
								SUM(B.CART_QTY) AS SQTY,
								SUM(B.CART_QTY * C.PROD_PRICE) AS SAMT
							FROM CART B,
								PROD C
							WHERE B.CART_PROD = C.PROD_ID
								AND B.CART_NO LIKE '200506%'
							GROUP BY B.CART_MEMBER
					) D
				WHERE B.MEM_ID = D.DID(+)
				ORDER BY B.MEM_ID;

4. 다중 행 서브 쿼리
	- 복수개의 결과를 반환하는 서브쿼리
	- IN, ANY, EXISTS 등의 연산자 결합
	
	사용 예)
		사원 테이블에서 2005년도에 입사한 사원들의 급여보다 더 많은 급여를 받는 사원을 조회하시오.
		Alias는 사원번호, 사원명, 입사일, 급여, 직책명
			SELECT A.EMPLOYEE_ID AS 사원번호,
					A.EMP_NAME AS 사원명,
					A.HIRE_DATE AS 입사일,
					A.SALARY AS 급여,
					B.JOB_TITLE AS 직책명
				FROM EMPLOYEES A,
					JOBS B
				WHERE A.HIRE_DATE >= TO_DATE('20070101')
					AND A.SALARY >= ANY(
							SELECT SALARY
								FROM EMPLOYEES
								WHERE EXTRACT(YEAR FROM HIRE_DATE) = 2004
						)
					AND A.JOB_ID = B.JOB_ID
				ORDER BY A.EMPLOYEE_ID;
				
			SELECT A.EMPLOYEE_ID AS 사원번호,
					A.EMP_NAME AS 사원명,
					A.HIRE_DATE AS 입사일,
					A.SALARY AS 급여,
					B.JOB_TITLE AS 직책명
				FROM EMPLOYEES A,
					JOBS B
				WHERE A.HIRE_DATE >= TO_DATE('20070101')
					AND EXISTS(
							SELECT 1
								FROM EMPLOYEES B
								WHERE EXTRACT	(YEAR FROM B.HIRE_DATE) = 2004
									AND A.SALARY >= B.SALARY
						)
					AND A.JOB_ID = B.JOB_ID
				ORDER BY A.EMPLOYEE_ID;

	문제]
		부서 테이블과 사원 테이블을 이용하여 다음 문제를 해결하시오.
		상위 부서 ( PARENT_ID ) 가 90번 부서인 하위부서의 직원 중 본인이 속한 부서의 평균 급여보다 많은 급여를 받는 사원정보 조회
		Alias는 사원번호, 사원명, 부서번호, 부서명, 평균급여
		단, INLINE SUBQUERY로 작성하시오.
			SELECT A.EMPLOYEE_ID AS 사원번호,
					A.EMP_NAME AS 사원명,
					D.DID AS 부서번호,
					D.DNAME AS 부서명,
					A.SALARY AS 급여,
					D.DSAL AS 평균급여
				FROM EMPLOYEES A,
					(
						SELECT B.DEPARTMENT_ID AS DID,
								B.DEPARTMENT_NAME AS DNAME,
								AVG(C.SALARY) AS DSAL
							FROM DEPARTMENTS B,
								EMPLOYEES C
							WHERE B.DEPARTMENT_ID = C.DEPARTMENT_ID
								AND B.PARENT_ID = 90
							GROUP BY B.DEPARTMENT_ID,
								B.DEPARTMENT_NAME
					) D
				WHERE A.DEPARTMENT_ID = D.DID
					AND A.SALARY >= D.DSAL
				ORDER BY A.EMPLOYEE_ID;