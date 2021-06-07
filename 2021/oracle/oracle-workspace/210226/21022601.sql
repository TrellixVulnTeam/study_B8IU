2021-02-26-01)

-- 제약조건
	PRIMARY KEY 제약
	UNIQUE 제약
		해당 컬럼에 중복된 값이 올 수 없다.
		단, NULL값은 들어갈 수 있다.
			NOT NULL

-- 전체 직원의 수
	SELECT DEPTNO,
			COUNT(*)
		FROM EMP
		GROUP BY DEPTNO;

-- 그룹함수 정리
	그룹함수 종류
		SUM, COUNT, AVG, MAX, MIN

	유의점
		GROUP BY 절에 나온 컬럼 이외의 컬럼이 그룹함수에 적용되지 않은 채로 SELECT 절에 올 수 없다.

	그룹함수의 연산에서 NULL 값은 제외된다.

	WHERE 절 ( 행을 제한하는 조건 ) 에는 GROUP 함수를 적용할 수 없다.
		HAVING 절에 기술

	테이블의 모든 행에 대해 그룹핑을 할 경우, GROUP BY 기술하지 않는다.

-- 단, 상수 값은 추가 가능
	SELECT DEPTNO,
			1,
			'TEST',
			COUNT(*)
		FROM EMP
		GROUP BY DEPTNO;

GRP]
	EMP 테이블을 이용하여 다음을 구하시오.
		직원 중 가장 높은 급여
		직원 중 가장 낮은 급여
		직원의 급여 평균 ( 소수점 두 자리까지 나오도록 반올림 )
		직원의 급여 합
		직원 중 급여가 있는 직원의 수 ( NULL 제외 )
		직원 중 상급자가 있는 직원의 수 ( NULL 제외 )
		모든 직원의 수
			SELECT MAX(SAL) AS MAX_SAL,
					MIN(SAL) AS MIN_SAL,
					ROUND(AVG(SAL), 2) AS AVG_SAL,
					SUM(SAL) AS SUM_SAL,
					COUNT(SAL) AS COUNT_SAL,
					COUNT(MGR) AS COUNT_MGR,
					COUNT(*) AS COUNT_ALL
				FROM EMP;

GRP2]
	EMP 테이블을 이용하여 다음을 구하시오
		부서 기준 직원 중 가장 높은 급여
		부서 기준 직원 중 가장 낮은 급여
		부서 기준 직원의 급여 평균 ( 소수점 2자리까지 )
		부서 기준 직원의 급여 합
		부서의 직원 중 급여가 있는 직원의 수 ( NULL 제외 )
		부서의 직원 중 상급자가 있는 직원의 수 ( NULL 제외)
		부서의 직원의 수
			SELECT DEPTNO,
					MAX(SAL) AS MAX_SAL,
					MIN(SAL) AS MIN_SAL,
					ROUND(AVG(SAL), 2) AS AVG_SAL,
					SUM(SAL) AS SUM_SAL,
					COUNT(SAL) AS COUNT_SAL,
					COUNT(MGR) AS COUNT_MGR,
					COUNT(*) AS COUNT_ALL
				FROM EMP
				GROUP BY DEPTNO
				ORDER BY DEPTNO;

GRP4]
	EMP 테이블을 이용하여 다음을 구하시오.
		직원의 입사 년월별로 몇 명의 직원이 입사했는지 조회하는 쿼리를 작성하시오.
			SELECT TO_CHAR(HIREDATE, 'YYYYMM') AS HIRE_YYYYMM,
					COUNT(*) AS CNT
				FROM EMP
				GROUP BY TO_CHAR(HIREDATE, 'YYYYMM')
				ORDER BY TO_CHAR(HIREDATE, 'YYYYMM');

GRP5]
	EMP 테이블을 이용하여 다음을 구하시오.
		직원의 입사 년별로 몇 명의 직원이 입사했는지 조회하는 쿼리를 작성하시오.
			SELECT TO_CHAR(HIREDATE, 'YYYY') AS HIRE_YYYY,
					COUNT(*) AS CNT
				FROM EMP
				GROUP BY TO_CHAR(HIREDATE, 'YYYY')
				ORDER BY TO_CHAR(HIREDATE, 'YYYY');

1]
	햄버거 프렌자이즈 별 매장 건수
	프렌차이즈 명, 매장 건수
		SELECT STORECATEGORY AS 프렌차이즈명,
				COUNT(*) AS 건수
			FROM BURGERSTORE
			GROUP BY STORECATEGORY
			ORDER BY COUNT(*) DESC;

2]
	시도, 시군구별 햄버거 프렌차이즈 별 매장 건수
	시도, 시군구, 프렌차이즈명, 건수
		SELECT SIDO AS 시도,
				SIGUNGU AS 시군구,
				STORECATEGORY AS 프렌차이즈명,
			COUNT(*) AS 건수
			FROM BURGERSTORE
			GROUP BY SIDO, SIGUNGU, STORECATEGORY
			ORDER BY COUNT(*) DESC;

3]
	시도별 햄버거 프렌차이즈별 매장건수
	시도, 프렌차이즈명, 건수
		SELECT SIDO AS 시도,
				STORECATEGORY AS 프렌차이즈명,
				COUNT(*) AS 건수
			FROM BURGERSTORE
			GROUP BY SIDO, STORECATEGORY
			ORDER BY COUNT(*) DESC;

4]
	시도, 시군구, 3개 프렌차이즈(KFC, 버거킹, 맥도날드) 매장수 합
	시도 시군구 3개 프렌차이즈의 매장 수
		SELECT SIDO AS 시도,
				SIGUNGU AS 시군구,
				COUNT(*) AS "프렌차이즈 매장 수"
			FROM BURGERSTORE
			WHERE STORECATEGORY IN('BURGER KING', 'MACDONALD', 'KFC')
			GROUP BY SIDO, SIGUNGU
			ORDER BY COUNT(*) DESC;

5]
	도시발전지수 = ( 버거킹 + 맥도날드 + KFC ) / 롯데리아
	시도, 시군구, 도시발전지수
		SELECT SIDO AS 시도,
				SIGUNGU AS 시군구,
				ROUND(
					SUM(
						CASE
							WHEN STORECATEGORY IN ('BURGER KING', 'MACDONALD', 'KFC')
								THEN 1
						END
					)
					/ SUM(
						CASE
							WHEN STORECATEGORY = 'LOTTERIA'
								THEN  1
						END
					), 2
				) AS "도시발전지수"
			FROM BURGERSTORE
			GROUP BY SIDO, SIGUNGU;

SELECT *
	FROM MEMBER;

SELECT MEM_NAME
	FROM MEMBER;

SELECT MEM_NAME,
		LENGTH(MEM_NAME) AS MEM_NAME_LENGTH
	FROM MEMBER;

SELECT LENGTH('김은대')
	FROM DUAL;

SELECT *
	FROM EMP;

SELECT ENAME,
		DEPTNO,
		SAL
	FROM EMP;

SELECT DEPTNO,
		SUM(SAL)
	FROM EMP
	GROUP BY DEPTNO
	ORDER BY DEPTNO;

SELECT *
	FROM EMP
	WHERE EMPNO > 7200
		AND DEPTNO = 10;

SELECT *
	FROM EMP, DEPT;

SELECT *
	FROM DEPT, EMP;

SELECT DEPTNO,
		SUM(SAL),
		ROUND(AVG(SAL), 2),
		COUNT(*), -- 행의 수를 반환
		COUNT(EMPNO), -- 컬럼의 값이 NULL이 아닌 행의 수를 반환
		COUNT(COMM) -- 컬럼의 값이 NULL이 아닌 행의 수를 반환
	FROM EMP
	GROUP BY DEPTNO
	ORDER BY DEPTNO;

SELECT DEPTNO,
		SUM(SAL),
		COUNT(*),
		MIN(SAL),
		MAX(SAL)
	FROM EMP
	GROUP BY DEPTNO;

SELECT DEPTNO,
		COUNT(*)
	FROM EMP
	GROUP BY DEPTNO
	HAVING COUNT(*) >= 4;

SELECT DEPTNO,
		COUNT(*)
	FROM EMP;
	GROUP BY DEPTNO;

SELECT *
	FROM EMP;

SELECT DEPTNO,
		ENAME,
		COUNT(*)
	FROM EMP
	GROUP BY DEPTNO, ENAME;

SELECT 'TEST'
	FROM EMP;

SELECT 100 + NULL,
		DEPTNO,
		NVL(SUM(COMM),0),
		SUM(NVL(COMM, 0))
	FROM EMP
	GROUP BY DEPTNO;
  
SELECT COUNT(*)
	FROM EMP;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS NOW
	FROM DUAL;

SELECT *
	FROM BURGERSTORE;

SELECT COUNT(*)
	FROM BURGERSTORE;