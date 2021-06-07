2020-02-18-01)
SELECT 문
	- 자료 검색 명령
	- SQL에서 가장 많이 사용되는 명령어

	사용 형식
		SELECT [DISTINCT] * | [컬럼명1 [AS ["]컬럼별칭["]]
				[, 컬럼명2 [AS ["]컬럼별칭["]]
							:
				[, 컬럼명n [AS ["]컬럼별칭["]]
			FROM 테이블 명
			[WHERE 조건1
				[AND 조건2]
					:
				[AND 조건n]]
			[GROUP BY 컬럼명1
				[, 컬럼명2]
					:
				[, 컬럼명n]]
			[HAVING 조건1
				[, 조건2]
					:
				[, 조건n]]
			[ORDER BY 컬럼인덱스 | 컬럼명1 [ASC | DESC]
				[, 컬럼인덱스 | 컬럼명2 [ASC | DESC]]
							:
				[, 컬럼인덱스 | 컬럼명n [ASC | DESC]]
			]

1. SELECT 절
	- 검색할 컬럼에 관련된 절
	- 실행되는 순서는 가장 늦게 ( FROM → WHERE → SELECT )

	사용 형식
		SELECT [DISTINCT] * | [컬럼명1 [AS ["]컬럼별칭["]]
			[, 컬럼명2 [AS ["]컬럼별칭["]]
						:
			[, 컬럼명n [AS ["]컬럼별칭["]]

	. [DISTINCT] : 중복된 자료를 배제하여 결과를 출력함
		사용 예)
			회원 테이블에서 회원들의 주소지의 종류를 모두 조회하시오.
			Alias는 거주지 ( 광역시 또는 도 )
				-- DISTINCT 미사용
					SELECT SUBSTR (MEM_ADD1, 1, 2)
						FROM MEMBER;

				-- DISTINCT 사용
					SELECT DISTINCT SUBSTR (MEM_ADD1, 1, 2)
						FROM MEMBER;

		사용 예)
			회원 테이블에서 회원들이 가지고 있는 취미 ( MEM_LIKE ) 들을 조회하시오.
				SELECT DISTINCT MEM_LIKE AS 취미
					FROM MEMBER;

	컬럼 별칭
		. 컬럼에 부여하는 별도의 이름
		. 해당 컬럼의 제목이나 SUBQUERY 사용 시 컬럼의 값을 참조하기 위하여 사용됨
		. 컬럼별칭에 특수문자 ( 공백이나 기호, 예약어 ) 가 사용될 때에는 " "로 묶어 사용해야 함
		. 'AS'는 생략 가능 ( 기술하는 것이 가독성을 위해 권장 됨 )
		. 컬럼별칭은 해당 SELECT 문의 WHERE 절 등에 사용할 수 없음

	사용 예 )
		제목줄로 사용
			사원테이블 ( EMPLOYEES ) 에서 영업실적 ( COMMISSION_PCT ) 가 NULL이 아닌 사원들의영업실적에 따른 보너스를 조회하시오.
			보너스 = 급여 * 영업실적코드
			Alias는 사원번호, 사원명, 영업실적코드, 본봉, 보너스이다.
				SELECT EMPLOYEE_ID AS 사원번호,
						EMP_NAME AS 사원명,
						COMMISSION_PCT AS "영업실적 코드",
						SALARY AS 본봉,
						SALARY * COMMISSION_PCT AS 보너스
					FROM EMPLOYEES
					WHERE COMMISSION_PCT IS NOT NULL
						AND SALARY * COMMISSION_PCT >= 3000
--					ORDER BY 5 DESC
--					ORDER BY 보너스 DESC
					ORDER BY SALARY * COMMISSION_PCT DESC;


	GROUP BY 함수 사용
		사용 예)
			회원 테이블 ( MEMBER ) 에서 성별 마일리지 합계를 조회하시오
				SELECT CASE
							WHEN SUBSTR(MEM_REGNO2, 1, 1)='1' OR SUBSTR(MEM_REGNO2, 1, 1)='3'
								THEN '남성회원'
							ELSE '여성회원'
						END AS 구분,
						SUM(MEM_MILEAGE) AS "마일리지 합계"
					FROM MEMBER
					GROUP BY CASE
							WHEN SUBSTR(MEM_REGNO2, 1, 1)='1' OR SUBSTR(MEM_REGNO2, 1, 1)='3'
								THEN '남성회원'
							ELSE '여성회원'
						END;

		사용 예)
			장바구니테이블 ( CART ) 에서 2005년 6월 회원별 구매액을 조회하되 구매금액이 50만원 이상인 회원정보를 조회하시오.
			Alias는 회원번호, 회원명, 구매액이다.
				SELECT A.CART_MEMBER AS 회원번호,
						B.MEM_NAME AS 회원명,
						SUM(A.CART_QTY * C.PROD_PRICE) AS 구매액
					FROM CART A,
						MEMBER B,
						PROD C
					WHERE A.CART_MEMBER = B.MEM_ID	-- 조인조건
						AND A.CART_PROD = C.PROD_ID	-- 조인조건
						AND A.CART_NO LIKE '200506%'
--						AND SUBSTR(A.CART_NO, 1, 8) >= '20050601' AND SUBSTR(A.CART_NO, 1, 8) <= '20050630'
					GROUP BY A.CART_MEMBER, B.MEM_NAME
					HAVING SUM(A.CART_QTY * C.PROD_PRICE) >= 500000
					ORDER BY 3 DESC;


DROP TABLE ORDERS_GOODS;

DROP TABLE TB_GOODS;

DROP TABLE TB_MEM;

DROP TABLE ORDERS;

DROP TABLE TEMP01;

DROP TABLE TEMP02;

DROP TABLE TEMP03;

DROP TABLE TEMP04;

DROP TABLE TEMP05;

DROP TABLE TEMP06;

DROP TABLE TEMP07;

DROP TABLE TEMP08;