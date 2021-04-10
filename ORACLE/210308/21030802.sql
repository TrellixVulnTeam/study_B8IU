2021-03-08-02)
집합연산자
	- 집합이론에서 제공하는 합집합 ( UNION, UNION ALL ),
		교집합 ( INTERSECT ),
		차집합 ( MINUS ) 연산자 제공
	
	사용 형식
		SELECT 컬럼List
			FROM 테이블명
			[WHERE 조건]
		UNION | UNION ALL | INTERSECT | MINUS
            SELECT 컬럼List
                FROM 테이블명
                [WHERE 조건
                    :	]
		[UNION | UNION ALL | INTERSECT | MINUS
            SELECT 컬럼List
                FROM 테이블명
                [WHERE 조건
                    :	]]
	. 각 SELECT 절의 컬럼 개수와 순서 및 TYPE이 같아야 함
	. ORDER BY 절은 맨 마지막 SELECT 문에서만 사용 가능
	. CLOB, BLOB, BFILE 등은 사용 불가
	. 출력의 기준은 첫 번째 SELECT 문임

1. UNION, UNION ALL
	- 합집합의 결과 반환
	- UNION
		중복하지 않은 결과 반환
	- UNION ALL
		중복된 값을 반환

	사용 예)
		2005년 4월과 6월에 판매된 상품정보를 중복하지 않게 조회하시오
		Alias는 상품코드, 상품명, 판매수량합계
			SELECT B.PROD_ID AS 상품코드,
				B.PROD_NAME AS 상품명
				FROM CART A,
					PROD B
				WHERE A.CART_PROD = B.PROD_ID
					AND A.CART_NO LIKE '200504%'
				GROUP BY B.PROD_ID,
					B.PROD_NAME
			UNION
                SELECT B.PROD_ID AS 상품코드,
                    B.PROD_NAME AS 상품명
                    FROM CART A,
                        PROD B
                    WHERE A.CART_PROD = B.PROD_ID
                        AND A.CART_NO LIKE '200506%'
                    GROUP BY B.PROD_ID,
                        B.PROD_NAME;

2. INTERSECT
	- 교집합의 결과 반환

	사용 예)
		2005년 4월과 6월에 모두 판매된 상품정보를 조회하시오
		Alias는 상품코드, 상품명, 판매수량합계
			SELECT B.PROD_ID AS 상품코드,
				B.PROD_NAME AS 상품명
				FROM CART A,
					PROD B
				WHERE A.CART_PROD = B.PROD_ID
					AND A.CART_NO LIKE '200504%'
				GROUP BY B.PROD_ID,
					B.PROD_NAME
			INTERSECT
                SELECT B.PROD_ID AS 상품코드,
                    B.PROD_NAME AS 상품명
                    FROM CART A,
                        PROD B
                    WHERE A.CART_PROD = B.PROD_ID
                        AND A.CART_NO LIKE '200506%'
                    GROUP BY B.PROD_ID,
                        B.PROD_NAME;

3. MINUS ( 차집합 )
	- A MINUS B
		집합 A에서 집합 B에 속한 요소를 제거한 결과 반환
	- B MINUS A
		집합 B에서 집합 A에 속한 요소를 제거한 결과 반환

	사용 예)
		2005년 4월에 판매된 상품 중 6월에 판매되지 않은 상품정보를 조회하시오.
			SELECT B.PROD_ID AS 상품코드,
				B.PROD_NAME AS 상품명
				FROM CART A,
					PROD B
				WHERE A.CART_PROD = B.PROD_ID
					AND A.CART_NO LIKE '200504%'
				GROUP BY B.PROD_ID,
					B.PROD_NAME
			MINUS
                SELECT B.PROD_ID AS 상품코드,
                    B.PROD_NAME AS 상품명
                    FROM CART A,
                        PROD B
                    WHERE A.CART_PROD = B.PROD_ID
                        AND A.CART_NO LIKE '200506%'
                    GROUP BY B.PROD_ID,
                        B.PROD_NAME;

	사용 예)
		2005년 6월에 판매된 상품 중 4월에 판매되지 않은 상품정보를 조회하시오.
			SELECT B.PROD_ID AS 상품코드,
				B.PROD_NAME AS 상품명
				FROM CART A,
					PROD B
				WHERE A.CART_PROD = B.PROD_ID
					AND A.CART_NO LIKE '200506%'
				GROUP BY B.PROD_ID,
					B.PROD_NAME
			MINUS
                SELECT B.PROD_ID AS 상품코드,
                    B.PROD_NAME AS 상품명
                    FROM CART A,
                        PROD B
                    WHERE A.CART_PROD = B.PROD_ID
                        AND A.CART_NO LIKE '200504%'
                    GROUP BY B.PROD_ID,
                        B.PROD_NAME;

**
	SELECT DISTINCT A.CART_PROD AS 상품코드,
			B.PROD_NAME AS 상품명
		FROM CART A, PROD B
		WHERE A.CART_NO LIKE '200506%'
			AND A.CART_PROD = B.PROD_ID
	UNION
		SELECT B.LPROD_GU AS 분류코드,
				B.LPROD_NM AS 분류명
			FROM LPROD B
			ORDER BY 1;