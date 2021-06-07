2021-02-19-01)
				SELECT MEM_ID AS 회원번호,
						MEM_NAME AS 회원이름,
						EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) - 1 AS 나이,
						MEM_MILEAGE AS 마일리지
					FROM MEMBER
					WHERE SUBSTR(MEM_REGNO2, 1, 1) IN('2', '4')
						AND EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) - 1 BETWEEN 40 AND 49;

	4) LIKE 연산자
		- 패턴 비교시 사용
		- 문자열 자료 비교에 사용되는 연산자
		- 와일드카드 '%'와 '_' 사용\
		- '%'는 사용된 위치에서 모든 문자열과 대응

		ex)
			'박%' : '박'으로 시작하는 모든 문자열과 대응
			'%도' : '도'로 끝나는 모든 문자열과 대응
			- '_'는 사용된 위치에서 한 글자와 대응

		ex)
			'박_' : '박'으로 시작하고 2글자로 구성된 문자열로 두 번째 글자는 모든 문자 허용
			'_도' : '도'로 끝나고 2글자로 구성된 문자열로 두 번째 글자는 모든 문자 허용

		예)
			거래처 테이블 ( BUYER ) 에서 주소지가 서울인 거래처를 조회하시오.
			Alias는 거래처코드, 거래처명, 주소, 담당자
				SELECT BUYER_ID AS 거래처코드,
						BUYER_NAME AS 거래처명,
						BUYER_ADD1 || ' ' || BUYER_ADD2 AS 주소,
						BUYER_BANKNAME AS 담당자
					FROM BUYER
					WHERE SUBSTR(BUYER_ADD1, 1, 2) = '서울';

				SELECT BUYER_ID AS 거래처코드,
						BUYER_NAME AS 거래처명,
						BUYER_ADD1 || ' ' || BUYER_ADD2 AS 주소,
						BUYER_BANKNAME AS 담당자
					FROM BUYER
					WHERE BUYER_ADD1 LIKE '서울%';

		예)
			장바구니 테이블 ( CART ) 에서 2005년 5월 판매현황을 조회하시오.
			Alias는 날짜, 제품코드, 판매수량이다.
				SELECT SUBSTR(CART_NO, 1, 8) AS 날짜,
						CART_PROD AS 제품코드,
						CART_QTY AS 판매수량
					FROM CART
					WHERE SUBSTR(CART_NO, 1, 8) = '200505%'
					ORDER BY CART_NO;

				SELECT SUBSTR(CART_NO, 1, 8) AS 날짜,
						CART_PROD AS 제품코드,
						CART_QTY AS 판매수량
					FROM CART
					WHERE CART_NO LIKE '200505%'

		문제]
			2005년 3월 제품매입 현황을 조회하시오.
			Alias는 날짜, 제품코드, 매입수량이다.
				SELECT BUY_DATE AS 날짜,
						BUY_PROD AS 제품코드,
						BUY_QTY AS 매입수량
					FROM BUYPROD
--					WHERE EXTRACT(YEAR FROM BUY_DATE) = 2005
--					AND EXTRACT(MONTH FROM BUY_DATE) = 3
--					WHERE TO_CHAR(BUY_DATE, 'YYYYMM') = '200503'
--					WHERE TO_CHAR(BUY_DATE) LIKE '2005/03%'
					WHERE BUY_DATE BETWEEN '20050301' AND '20050331'
					ORDER BY BUY_DATE;

		** 234567 * 12345 의 값을 구하시오.
			SELECT 234567 * 12345
			FROM DUAL;

			SELECT SYSDATE
			FROM DUAL;