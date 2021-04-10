2021-03-05-02)
2. 연관성 있는 서브쿼리
	- 메인 쿼리에 사용되는 테이블과 서브 쿼리에 사용되는 테이블이 JOIN으로 연결된 서브쿼리
	
	예)
		직무 이력 테이블 ( JOB_HISTORY ) 에 존재하는 부서를 조회하시오.
		Alias는 부서코드, 부서명이다.
			EXISTS 사용
				메인쿼리
					부서 테이블에서 부서코드, 부서명 출력
				SELECT A.DEPARTMENT_ID AS 부서코드,
						A.DEPARTMENT_NAME AS 부서명
					FROM DEPARTMENTS A
					WHERE EXISTS(
--							서브쿼리
--								직무이력테이블 ( JOB_HISTORY ) 에서 부서 조회
							SELECT 1
								FROM JOB_HISTORY B
								WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID
						)
					ORDER BY A.DEPARTMENT_ID;

			IN 사용
				SELECT A.DEPARTMENT_ID AS 부서코드,
						A.DEPARTMENT_NAME AS 부서명
					FROM DEPARTMENTS A
					WHERE A.DEPARTMENT_ID IN(
							SELECT B.DEPARTMENT_ID
								FROM JOB_HISTORY B
						)
					ORDER BY A.DEPARTMENT_ID;

			ANY 사용
				SELECT A.DEPARTMENT_ID AS 부서코드,
						A.DEPARTMENT_NAME AS 부서명
					FROM DEPARTMENTS A
					WHERE A.DEPARTMENT_ID = ANY(
							SELECT B.DEPARTMENT_ID
								FROM JOB_HISTORY B
						)
					ORDER BY A.DEPARTMENT_ID;

	예)
		직무 이력 테이블의 자료를 조회하여 다음을 출력하시오.
		Alias 사원번호, 사원명, 부서명, 직무명
			SELECT A.EMPLOYEE_ID AS 사원번호,
					(
						SELECT B.EMP_NAME
							FROM EMPLOYEES B
							WHERE A.EMPLOYEE_ID = B.EMPLOYEE_ID
					) AS 사원명,
					(
						SELECT C.DEPARTMENT_NAME
							FROM DEPARTMENTS C
							WHERE A.DEPARTMENT_ID = C.DEPARTMENT_ID
					) AS 부서명,
					(
						SELECT D.JOB_TITLE
							FROM JOBS D
							WHERE A.JOB_ID = D.JOB_ID
					) AS 직무명
				FROM JOB_HISTORY A
				ORDER BY A.EMPLOYEE_ID;

	예)
		사원 테이블에서 본인이 속한 부서의 평균 급여보다 더 많은 급여를 받는 사원들을 조회하시오.
		사원번호, 사원명, 부서명, 부서평균급여, 사원의급여
			SELECT A.EMPLOYEE_ID AS 사원번호,
					A.EMP_NAME AS 사원명,
					C.DEPARTMENT_ID AS 부서코드,
					C.DEPARTMENT_NAME AS 부서명,
					ROUND(B.AVG_SALARY, 1) AS 부서평균급여,
					A.SALARY AS 사원의급여
				FROM EMPLOYEES A
					INNER JOIN (
							SELECT DEPARTMENT_ID AS EMPLOYEES_DEPARTMENT_ID,
									AVG(SALARY) AS AVG_SALARY
								FROM EMPLOYEES
								GROUP BY DEPARTMENT_ID
						) B ON(
								A.DEPARTMENT_ID IS NULL
										AND B.EMPLOYEES_DEPARTMENT_ID IS NULL
										AND A.SALARY > B.AVG_SALARY
									OR A.DEPARTMENT_ID = B.EMPLOYEES_DEPARTMENT_ID
										AND A.SALARY > B.AVG_SALARY
							)
					LEFT OUTER JOIN DEPARTMENTS C ON(
							A.DEPARTMENT_ID = C.DEPARTMENT_ID
						)
				ORDER BY A.EMPLOYEE_ID;

	예)
		사원들이 속한 부서의 평균 급여보다 더 많은 급여를 받는 사원이 존재하는 부서코드와 부서명을 출력하시오.
			SELECT A.DEPARTMENT_ID AS 부서코드,
					A.DEPARTMENT_NAME AS 부서명
				FROM DEPARTMENTS A
				WHERE EXISTS(
						SELECT 1
							FROM EMPLOYEES B
							WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID
								AND B.SALARY > (
										SELECT AVG(C.SALARY)
											FROM EMPLOYEES C
											WHERE B.DEPARTMENT_ID = C.DEPARTMENT_ID
									)
					)
				ORDER BY A.DEPARTMENT_ID;

연관성 있는 서브쿼리를 이용한 자료 삽입
오늘이 2005년 1월 31이라 가정하고, 장바구니 테이블과 매입 테이블을 참조하여 재고수불이블테을 UPDATE하시오.
UPDATE REMAIN A
	SET (A.REMAIN_I, A.REMAIN_J_99, A.REMAIN_DATE) = (
			SELECT REMAIN_I + SUM(BUY_QTY),
					A.REMAIN_J_99 + SUM(BUY_QTY),
					TO_DATE('20050131')
				FROM BUYPROD B
				WHERE A.REMAIN_PROD = B.BUY_PROD
					AND TO_CHAR(B.BUY_DATE, 'YYYYMM') = '200501'
				GROUP BY B.BUY_PROD
		)
	WHERE A.REMAIN_YEAR = 2005
		AND A.REMAIN_PROD IN(
				SELECT BUY_PROD
					FROM BUYPROD
					WHERE TO_CHAR(BUY_DATE, 'YYYYMM') = '200501'
			);
COMMIT;

ROLLBACK;