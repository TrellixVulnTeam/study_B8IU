2021-03-04-02)
외부 조인
	- 내부조인에서는 조인조건을 만족하지 않은 자료 ( 행 ) 을 무시
	- 외부조인에서는 조인조건을 만족하지 않은 테이블에 부족 행만큼
		NULL 값을 갖는 행을 추가 삽입한 후 조인 수행
	- 조인 조건 기술에서 부족한 자료를 갖고 있는 테이블에 속한 컬럼명 뒤에 외부 조인 연산자 ( '(+)' ) 를 기술
	- 두 개 이상의 조인에 외부 조인을 동시에 수행되야 할 경우
		해당되는 조인 조건 모두 외부 조인 연산자 ( '(+)' ) 를 기술
	- 한 번에 한 테이블에 대해서만 외부 조인을 수행할 수 있다.
		즉, A, B, C 테이블이 외부 조인에 참여하는 경우,
			A를 기준으로 B를 외부 조인하고 ( A = B(+) ),
			동시에 C를 기준으로 B를 외부 조인 ( B = C(+) )할 수 없다.
	- (+) 연산자가 붙은 조건에서는 OR 연산자 사용 금지
	- (+) 연산자가 붙은 조건에서는 IN 연산자 사용 금지

	사용 형식
		일반 OUTER JOIN
			SELECT 컬럼LIST
				FROM 테이블LIST
				WHERE 컬럼명1 = 컬럼명2(+)
					[AND 일반조건]

		ANSI OUTER JOIN
			SELECT 컬럼LIST
				FROM 테이블1
					FULL|LEFT|RIGHT OUTER JOIN 테이블명2
						ON (조인조건1[ AND 일반조건])
				WHERE 일반조건

			. LEFT
				테이블명1이 테이블명2보다 더 많은 자료를 갖고 있는 경우 사용
			. RIGHT
				테이블명2가 테이블명1보다 더 많은 자료를 갖고 있는 경우 사용
			. FULL
				테이블명1, 테이블명2 모두 부족한 경우 사용

	예)
		상품 테이블에서 모든 분류별 상품의 수를 조회하시오.
		Alias는 분류코드, 분류명, 상품의 수
			SELECT A.LPROD_GU AS 분류코드,
					A.LPROD_NM AS 분류명,
					NVL(COUNT(B.PROD_ID), 0) AS "상품의 수"
				FROM LPROD A,
					PROD B
				WHERE A.LPROD_GU = B.PROD_LGU(+)
				GROUP BY A.LPROD_GU,
					A.LPROD_NM
				ORDER BY A.LPROD_GU,
					A.LPROD_NM;

			SELECT A.LPROD_GU AS 분류코드,
					A.LPROD_NM AS 분류명,
					COUNT(B.PROD_ID) AS "상품의 수"
				FROM LPROD A
					LEFT OUTER JOIN PROD B
						ON(A.LPROD_GU = B.PROD_LGU)
				GROUP BY A.LPROD_GU,
					A.LPROD_NM
				ORDER BY A.LPROD_GU,
					A.LPROD_NM;

	예)
		2005년 2월 모든 상품 별 매입 현황을 조회하시오.
		Alias는 상품코드, 상품명, 매입수량, 매입금액
			SELECT A.PROD_ID AS 상품코드,
					A.PROD_NAME AS 상품명,
					NVL(SUM(B.BUY_QTY), 0) AS 매입수량,
					NVL(SUM(B.BUY_QTY * A.PROD_COST), 0)매입금액
				FROM PROD A,
					(
						SELECT *
							FROM BUYPROD
							WHERE TO_CHAR(BUY_DATE, 'YYYYMM') = '200502'
					) B
				WHERE A.PROD_ID = B.BUY_PROD(+)
				GROUP BY A.PROD_ID,
					A.PROD_NAME
				ORDER BY A.PROD_ID;

			SELECT A.PROD_ID AS 상품코드,
					A.PROD_NAME AS 상품명,
					NVL(SUM(B.BUY_QTY), 0) AS 매입수량,
					NVL(SUM(B.BUY_QTY * A.PROD_COST), 0)매입금액
				FROM PROD A
					LEFT OUTER JOIN BUYPROD B
						ON(
							A.PROD_ID = B.BUY_PROD
								AND TO_CHAR(BUY_DATE, 'YYYYMM') = '200502'
						)
				GROUP BY A.PROD_ID,
					A.PROD_NAME
				ORDER BY A.PROD_ID;

	예)
		사원 테이블에서 모든 부서별 사원 수를 조회하시오.
		부서코드, 부서명, 사원 수
			SELECT B.DEPARTMENT_ID AS 부서코드,
					B.DEPARTMENT_NAME AS 부서명,
					COUNT(A.EMPLOYEE_ID) AS "사원 수"
				FROM EMPLOYEES A,
					DEPARTMENTS B
				WHERE A.DEPARTMENT_ID(+) = B.DEPARTMENT_ID
				GROUP BY B.DEPARTMENT_ID,
					B.DEPARTMENT_NAME
			UNION
			SELECT B.DEPARTMENT_ID AS 부서코드,
					B.DEPARTMENT_NAME AS 부서명,
					COUNT(A.EMPLOYEE_ID) AS "사원 수"
				FROM EMPLOYEES A,
					DEPARTMENTS B
				WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID(+)
				GROUP BY B.DEPARTMENT_ID,
					B.DEPARTMENT_NAME;

			SELECT B.DEPARTMENT_ID AS 부서코드,
					B.DEPARTMENT_NAME AS 부서명,
					COUNT(A.EMPLOYEE_ID) AS "사원 수"
				FROM EMPLOYEES A
					FULL OUTER JOIN DEPARTMENTS B
						ON(A.DEPARTMENT_ID = B.DEPARTMENT_ID)
				GROUP BY B.DEPARTMENT_ID,
					B.DEPARTMENT_NAME
				ORDER BY B.DEPARTMENT_ID;

	예)
		2005년 7월 모든 회원별 판매현황을 조회하시오.
		Alias는 회원번호, 회원명, 구매수량합계, 구매금액합계
			SELECT A.MEM_ID AS 회원번호,
					A.MEM_NAME AS 회원명,
					NVL(D.SUM_CART_QTY, 0) AS 구매수량합계,
					NVL(D.SUM_CART_QTY_PROD_SALE, 0) AS 구매금액합계
				FROM MEMBER A,
					(
						SELECT B.CART_MEMBER AS CART_CART_MEMBER,
								SUM(B.CART_QTY) AS SUM_CART_QTY,
								SUM(B.CART_QTY * C.PROD_SALE) AS SUM_CART_QTY_PROD_SALE
							FROM CART B,
								PROD C
							WHERE B.CART_PROD = C.PROD_ID
								AND CART_NO LIKE '200507%'
							GROUP BY B.CART_MEMBER
					) D
				WHERE A.MEM_ID = D.CART_CART_MEMBER(+)
				ORDER BY A.MEM_ID;

			SELECT C.MEM_ID AS 회원번호,
					C.MEM_NAME AS 회원명,
					NVL(SUM(A.CART_QTY), 0) AS 구매수량합계,
					NVL(SUM(A.CART_QTY * PROD_SALE), 0) AS 구매금액합계
				FROM CART A
					INNER JOIN PROD B
						ON(
							A.CART_PROD = B.PROD_ID
								AND A.CART_NO LIKE '200507%'
						)
					RIGHT OUTER JOIN MEMBER C
						ON(A.CART_MEMBER = C.MEM_ID)
				GROUP BY C.MEM_ID,
					C.MEM_NAME
				ORDER BY C.MEM_ID;