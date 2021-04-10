2021-02-24-03) 그룹 함수
	- 복수개의 행을 대상으로 연산
	- SUM, AVG, COUNT, MAX, MIN
	- 그룹함수와 일반컬럼이 SELECT 절에 사용되면, 반드시 GROUP BY 절이 WHERE 절 다음에 기술되어야 함.

	사용 형식
		SELECT [컬럼명1, ...],
				SUM(컬럼명)|AVG(컬럼명)|COUNT(컬럼명)|MAX(컬럼명)|MIN(컬럼명)
			FROM 테이블명
			[WHERE 조건]
			[GROUP BY 컬럼명[, 컬럼명, ...]]
			[HAVING 조건]
			[ORDER BY 컬럼명|컬럼인덱스 [[ASC]|DESC], ...];

1. SUM(col)
	- 자료를 그룹으로 묶고 그 그룹 내의 컬럼에 대한 합계를 구함
	- SELECT 절에 일반 컬럼 없이 SUM 함수만 사용되면 테이블 전체가 하나의 그룹으로 간주.
		GROUP BY 절 생략

	사용 예)
		회원 테이블에서 모든 회원들의 마일리지 합계를 구하시오.
			SELECT SUM(MEM_MILEAGE)
				FROM MEMBER;

	사용 예)
		회원 테이블에서 회원들의 거주지 별 마일리지 합계를 구하시오.
			SELECT SUBSTR(MEM_ADD1, 1, 2) AS 거주지,
					SUM(MEM_MILEAGE) AS "마일리지 합계"
				FROM MEMBER
				GROUP BY SUBSTR(MEM_ADD1, 1, 2);

	사용 예)
		사원 테이블에서 부서 별 급여 합계를 조회하시오.
		단, 합계가 30000 이상인 부서만 조회
			SELECT DEPARTMENT_ID AS 부서코드,
					SUM(SALARY) AS 급여합계
				FROM EMPLOYEES
				GROUP BY DEPARTMENT_ID
				HAVING SUM(SALARY) >= 30000
				ORDER BY DEPARTMENT_ID;