2021-03-04-01)

3. SELF JOIN
	- 하나의 테이블에 2 개 이상의 테이블 병칭을 부여하여 서로 다른 테이블로 간주하여 JOIN 연산 수행

	사용 예)
		회원 테이블에서 직업이 '주부'인 회원들의 평균 마일리지보다 많은 마일리지를 보유한 회원을 조회하시오.
		Alias는 회원번호, 회원명, 직업, 마일리지
			SELECT A.MEM_ID AS 회원번호,
					A.MEM_NAME AS 회원명,
					A.MEM_JOB AS 직업,
					C.JUBUMILEAGE AS 주부마일리지,
					A.MEM_MILEAGE AS 마일리지
				FROM MEMBER A,
					(
						SELECT AVG(B.MEM_MILEAGE) AS JUBUMILEAGE
							FROM MEMBER B
							WHERE MEM_JOB = '주부'
					) C
				WHERE A.MEM_MILEAGE >= C.JUBUMILEAGE;

	사용 예)
		사원 테이블에서 직책이 영업관리자 ( SA_MAN )인 145번 사원보다 보다 급여를 많이 받는 사원을 조회하시오.
		Alias는 사원번호, 사원명, 입사일, 직책코드, 급여
			SELECT A.EMPLOYEE_ID AS 사원번호,
					A.EMP_NAME AS 사원명,
					A.HIRE_DATE AS 입사일,
					A.JOB_ID AS 직책코드,
					A.SALARY AS 급여
				FROM EMPLOYEES A,
					(
						SELECT B.SALARY AS SA_MAN_145_SALARY
							FROM EMPLOYEES B
							WHERE JOB_ID = 'SA_MAN'
								AND B.EMPLOYEE_ID = 145
					) C
				WHERE A.SALARY > C.SA_MAN_145_SALARY
				ORDER BY A.EMPLOYEE_ID;