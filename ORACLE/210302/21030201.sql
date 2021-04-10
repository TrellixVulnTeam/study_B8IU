2021-03-02-01)
테이블 조인
	- 관계형 데이터베이스의 핵심
	- 여러 테이블에 분산되어 저장된 자료들을 관계 ( Relationshipo ) 를 이용하여 추출하는 연산
	- 종류
		1) 내부주인, 외부조인
		2) 일반조인, ANSI조인
		3) Cartesian Product, Equi Join, Non-Equi Join, Self Join, etc ...

1. 내부조인 ( Inner Join )
	- 조인조건을 만족하는 데이터만 연산의 결과로 반환되고, 조인조건에 맞지 않는 자료는 무시 됨

	사용 형식 ( 일반 조인 )
		SELECT 컬럼1, 컬럼2, ...
			FROM 테이블명1 [테이블별칭1], 테이블명2 [테이블별칭2], [, 테이블명3 [테이블별칭3], ...]
			WHERE 조인조건
				[AND 조인조건, ...]
				[AND 일반조건, ...]
		. 사용되는 테이블의 갯수가 n개일때 조인 조건은 적어도 n - 1개 이상이어야 함
		. 조인 조건에 사용되는 컬럼은 두 테이블에 존재하는 같은 자료를 저장하고 있는 컬럼 ( 보통 외래키 관계 활용 )
		. 조인 조건과 실행 조건의 기술 순서는 상관 없음

	사용 형식 ( ANSI - 일반 조인 )
		SELECT 컬럼1, 컬럼2, ...
			FROM 테이블명1 [테이블별칭1]
				INNER JOIN 테이블명2[ 테이블별칭2] ON(조인조건[ AND 일반조건])
				[INNER JOIN 테이블명3[ 테이블별칭3] ON(조인조건[ AND 일반조건])
			[WHERE 일반조건, ...]

	예)
		장바구니 테이블을 이용하여 2005년 6월 회원별 매출현황을 조회하시오.
		Alias는 회원번호, 회원명, 구매수량합계이다.
			SELECT A.CART_MEMBER AS 회원번호,
					B.MEM_NAME AS 회원명,
					SUM(CART_QTY) AS 구매수량합계
				FROM CART A, MEMBER B
				WHERE A.CART_MEMBER = B.MEM_ID
					AND CART_NO LIKE '200506%'
				GROUP BY A.CART_MEMBER,
					B.MEM_NAME
				ORDER BY A.CART_MEMBER,
					B.MEM_NAME;

			SELECT A.CART_MEMBER AS 회원번호,
					B.MEM_NAME AS 회원명,
					SUM(CART_QTY) AS 구매수량합계
				FROM CART A
					INNER JOIN MEMBER B
					ON(A.CART_MEMBER = B.MEM_ID)
				WHERE CART_NO LIKE '200506%'
				GROUP BY A.CART_MEMBER,
					B.MEM_NAME
				ORDER BY A.CART_MEMBER,
					B.MEM_NAME;

2. Cartesian Product ( ANSI 에서 CROSS JOIN이라고 함 )
	- 모든 가능 행들의 조합
	- 조인에 참여한 테이블의 행의 곱과 열의 합을 결과로 반환
	- 반드시 필요한 경우가 아니면 사용 자제
	- 조인 조건을 생략하거나, 잘못된 조인 조건을 지정하면 발생

	사용 예)
		SELECT COUNT(*) AS "행의 수" -- 74 * 209
			FROM CART,
				PROD;

3. Equi Join
	- 동등 조인으로 조인조건에 '=' 연산자 사용되는 조인
	- ANSI에서는 INNER JOIN이라 함
	
	사용 예)
		사원 테이블에서 다음 형식을 적용하여 사원을 조회하시오.
		Alias는 사원번호, 사원명, 부서코드, 부서명, 직책명, 급여
			SELECT A.EMPLOYEE_ID AS 사원번호,
					A.EMP_NAME AS 사원명,
					A.DEPARTMENT_ID AS 부서코드,
					B.DEPARTMENT_NAME AS 부서명,
					C.JOB_TITLE AS 직책명,
					A.SALARY AS 급여
				FROM EMPLOYEES A, DEPARTMENTS B, JOBS C
				WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID
					AND A.JOB_ID = C.JOB_ID
				ORDER BY A.EMPLOYEE_ID;

			SELECT A.EMPLOYEE_ID AS 사원번호,
					A.EMP_NAME AS 사원명,
					A.DEPARTMENT_ID AS 부서코드,
					B.DEPARTMENT_NAME AS 부서명,
					C.JOB_TITLE AS 직책명,
					A.SALARY AS 급여
				FROM EMPLOYEES A
					INNER JOIN DEPARTMENTS B ON(A.DEPARTMENT_ID = B.DEPARTMENT_ID)
					INNER JOIN JOBS C ON(A.JOB_ID = C.JOB_ID)
				ORDER BY A.EMPLOYEE_ID;

	사용 예)
		상품 테이블에서 각 분류에 속하는 상품의 수를 조회하시오.
		Alias는 분류코드, 분류명, 상품의 수
		SELECT B.LPROD_GU AS 분류코드,
				B.LPROD_NM AS 분류명,
				COUNT(*) AS "상품의 수"
			FROM PROD A,
				LPROD B
			WHERE A.PROD_LGU = B.LPROD_GU
			GROUP BY B.LPROD_GU,
				B.LPROD_NM
			ORDER BY B.LPROD_GU;

		SELECT B.LPROD_GU AS 분류코드,
				B.LPROD_NM AS 분류명,
				COUNT(*) AS "상품의 수"
			FROM PROD A
				INNER JOIN LPROD B ON(A.PROD_LGU = B.LPROD_GU)
			GROUP BY B.LPROD_GU,
				B.LPROD_NM
			ORDER BY B.LPROD_GU;

	문제 1]
		장바구니 테이블에서 2005년 7월 상품별 판매현황을 조회하시오.
		Alias는 상품코드, 상품명, 판매수량, 판매금액
		일반 조인 형식과 ANSI 조인 형식 적용
			SELECT B.PROD_ID AS 상품코드,
					B.PROD_NAME AS 상품명,
					SUM(A.CART_QTY) AS 판매수량,
					SUM(A.CART_QTY * B.PROD_SALE) AS 판매금액
				FROM CART A,
					PROD B
                WHERE CART_NO LIKE '200507%' -- 일반조건
					AND A.CART_PROD = B.PROD_ID -- 조인조건
				GROUP BY B.PROD_ID,
					B.PROD_NAME
				ORDER BY B.PROD_ID;

			SELECT B.PROD_ID AS 상품코드,
					B.PROD_NAME AS 상품명,
					SUM(A.CART_QTY) AS 판매수량,
					SUM(A.CART_QTY * B.PROD_SALE) AS 판매금액
				FROM CART A
					INNER JOIN PROD B ON(A.CART_PROD = B.PROD_ID)
				WHERE CART_NO LIKE '200507%'
				GROUP BY B.PROD_ID,
					B.PROD_NAME
				ORDER BY B.PROD_ID;

	문제 2]
		2005년 2월 거래처별, 상품별 매입현황을 조회하시오.
		Alias는 거래처코드, 거래처명, 상품명, 매입수량, 매입금액
		일반 조인 형식과 ANSI 조인 형식 적용
			SELECT C.BUYER_ID AS 거래처코드,
					C.BUYER_NAME AS 거래처명,
					B.PROD_NAME AS 상품명,
					SUM(A.BUY_QTY) AS 매입수량,
					SUM(A.BUY_QTY * PROD_COST) AS 매입금액
				FROM BUYPROD A,
					PROD B,
					BUYER C
				WHERE A.BUY_PROD = B.PROD_ID
					AND B.PROD_BUYER = C.BUYER_ID
					AND EXTRACT(YEAR FROM A.BUY_DATE) = 2005
					AND EXTRACT(MONTH FROM A.BUY_DATE) = 2
				GROUP BY C.BUYER_ID,
					C.BUYER_NAME,
					B.PROD_NAME
				ORDER BY C.BUYER_ID,
					B.PROD_NAME;
					
			SELECT C.BUYER_ID AS 거래처코드,
					C.BUYER_NAME AS 거래처명,
					B.PROD_NAME AS 상품명,
					SUM(A.BUY_QTY) AS 매입수량,
					SUM(A.BUY_QTY * PROD_COST) AS 매입금액
				FROM BUYPROD A
					INNER JOIN PROD B
						ON
							(
								A.BUY_PROD = B.PROD_ID
								AND EXTRACT(YEAR FROM A.BUY_DATE) = 2005
								AND EXTRACT(MONTH FROM A.BUY_DATE) = 2
							)
					INNER JOIN BUYER C
						ON
							(
								B.PROD_BUYER = C.BUYER_ID
							)
				GROUP BY C.BUYER_ID,
					C.BUYER_NAME,
					B.PROD_NAME
				ORDER BY C.BUYER_ID,
					B.PROD_NAME;

	문제 3]
		2005년 5월 매입, 매출현황을 조회하시오.
		Alias는 상품코드, 상품명, 매입금액합계, 판매금액합계이다.

			SELECT C.PROD_ID AS 상품코드,
					C.PROD_NAME AS 상품명,
					SUM(C.PROD_COST * A.BUY_QTY) AS 매입금액합계,
					SUM(B.CART_QTY * C.PROD_PROCE) AS 판매금액합계
				FROM BUYPROD A, CART B, PROD C
				WHERE A.BUY_PROD = C.PROD_ID
					AND C.PROD_ID = B.CART_PROD
					AND TO_CHAR(A.BUY_DATE, 'YYYYMM') = '200505'
					AND B.CART_NO LIKE '200505%'
				GROUP BY C.PROD_ID,
					C.PROD_NAME
				ORDER BY C.PROD_ID;

			SELECT A.PROD_ID AS 상품코드,
					A.PROD_NAME AS 상품명,
					SUM(A.PROD_COST * B.BUY_QTY) AS 매입금액합계,
					SUM(A.PROD_SALE * C.CART_QTY) AS 판매급액합계
				FROM PROD A,
					(
						SELECT *
							FROM BUYPROD
							WHERE EXTRACT(YEAR FROM BUY_DATE) = 2005
								AND EXTRACT(MONTH FROM BUY_DATE) = 5
					) B,
					(
						SELECT *
							FROM CART
							WHERE CART_NO LIKE '200505%'
					) C
				WHERE A.PROD_ID = B.BUY_PROD(+)
					AND A.PROD_ID = C.CART_PROD(+)
				GROUP BY A.PROD_ID,
					A.PROD_NAME;

			SELECT A.PROD_ID AS 상품코드,
					A.PROD_NAME AS 상품명,
					SUM(A.PROD_COST * B.BUY_QTY) AS 매입금액합계,
					SUM(A.PROD_SALE * C.CART_QTY) AS 판매급액합계
				FROM PROD A
					LEFT OUTER JOIN (
                            SELECT *
                                FROM BUYPROD
                                WHERE EXTRACT(YEAR FROM BUY_DATE) = 2005
                                    AND EXTRACT(MONTH FROM BUY_DATE) = 5
					) B
						ON(A.PROD_ID = B.BUY_PROD)
					LEFT OUTER JOIN (
                            SELECT *
                                FROM CART
                                WHERE CART_NO LIKE '200505%'
					) C
						ON(A.PROD_ID = C.CART_PROD)
				GROUP BY A.PROD_ID,
					A.PROD_NAME
				ORDER BY A.PROD_ID;

			SELECT A.PROD_ID AS 상품코드,
					A.PROD_NAME AS 상품명,
					SUM(A.PROD_COST * B.BUY_QTY) AS 매입금액합계,
					SUM(A.PROD_SALE * C.CART_QTY) AS 판매급액합계
				FROM PROD A
					LEFT OUTER JOIN BUYPROD B
						ON(
							A.PROD_ID = B.BUY_PROD
							AND EXTRACT(YEAR FROM BUY_DATE) = 2005
							AND EXTRACT(MONTH FROM BUY_DATE) = 5
						)
					LEFT OUTER JOIN CART C
						ON(
							A.PROD_ID = C.CART_PROD
							AND CART_NO LIKE '200505%'
						)
				GROUP BY A.PROD_ID,
					A.PROD_NAME
				ORDER BY A.PROD_ID;