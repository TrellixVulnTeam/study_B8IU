2021-02-24-01)

	** 숫자 변환 문자열
		----------------------------------------------------------------------------------------
		형식문자열			의미
		----------------------------------------------------------------------------------------
		9				대응되는 데이터가 유효숫자이면 원본 자료를 출력하고,
						대응되는 데이터가 무효의 0이면 공백처리
		0				대응되는 데이터가 유효숫자이면 원본 자료를 출력하고,
						대응되는 데이터가 무효의 0이면 '0'을 출력
		$, L(1)			화폐 기호를 출력
		MI				데이터가 음수인 경우 우측에 '-' 부호 출력
						반드시 형식문자열 맨 우측에 기술
		PR				데이터가 음수인 경우 '-' 부호 대신 '< >'로 묶어 출력
		, ( comma )		3 자리 마다 자리점 출력
		. ( dot )		소숫점 출력
		----------------------------------------------------------------------------------------

		SELECT TO_CHAR(12345, '999,999,999'),
				TO_CHAR(12345, '000,000,000'),
				TO_CHAR(12345, '$999,999,999'),
				TO_CHAR(12345, 'L999,999,999'),
				TO_CHAR(-12345, '999,999,999MI'),
				TO_CHAR(-12345, '999,999,999PR'),
				TO_CHAR(123.45, '999,999,999.999')
			FROM DUAL;

	사용 예)
		우리나라 대도시별 대출잔액테이블 ( KOR_LOAN_STATUS ) 에서
		2013년 11월 정보를 조회하시오.
		Alias는 시도, 대출구분, 대출잔액이며, 대출잔액은 3자리마다 자리점과 소숫점을 삽입하여 출력하시오.
			SELECT REGION AS 시도,
					GUBUN AS 대출구분,
					TO_CHAR(LOAN_JAN_AMT, '9,999,999.99') AS 대출잔액,
					TO_CHAR(LOAN_JAN_AMT, 'L0,000,000.99') AS 대출잔액,
					TO_CHAR(LOAN_JAN_AMT, 'L9,999,999.99') AS 대출잔액
				FROM KOR_LOAN_STATUS
				WHERE PERIOD = 201311
				ORDER BY REGION;

	** 상품 테이블에서 제조번호 'P102000001'과 'P102000002' 제품의 할인판매가를 매입가격의 90%로 조정하시오.
		UPDATE PROD
			SET PROD_SALE = PROD_COST * 0.9
			WHERE PROD_ID IN('P102000001', 'P102000002');

		COMMIT;

		ROLLBACK;

		SELECT PROD_COST, PROD_SALE
			FROM PROD
			WHERE PROD_ID IN('P102000001', 'P102000002');

	사용 예)
		상품테이블에서 거래처가 대우전자 ( P10201 ) 인 제품정보를 조회하시오.
		할인판매이익은 할인판매가 - 매입가이고,
		음수인 경우, < > 안에 출력하시오.
		Alias는 상품명, 매입가, 판매가, 할인판매가, 할인판매이익
			SELECT PROD_NAME AS 상품명,
					TO_CHAR(PROD_COST, '9,999,999') AS 매입가,
					TO_CHAR(PROD_PRICE, '9,999,999') AS 판매가,
					TO_CHAR(PROD_SALE, '9,999,999') AS 할인판매가,
					TO_CHAR(PROD_SALE - PROD_COST, '9,999,999PR') AS 할인판매이익
				FROM PROD
				WHERE UPPER(PROD_BUYER)= 'P10201';

2. TO_NUMBER(c[, fmt])
	- 주어진 문자열 c ( 숫자형식 ) 를 숫자로 변환
	- fmt는 TO_CHAR 형식과 동일하나, 모두 적용되지는 않음

	사용 예)
		SELECT TO_NUMBER('2021'),
				TO_NUMBER('$1,200','$9,999') + 100,
				TO_NUMBER('<200,000>','999,999PR') / 10,
			FROM DUAL;

	사용 예)
		오늘이 2005년 4월 1일이라고 가정하고,
		오철희 회원 ( 'K001' ) 이 상품을 구입하기 위해 쇼핑몰에 로그인 할 때,
		카트번호를 부여하도록 코딩하시오.
			SELECT MAX(CART_NO) + 1
				FROM CART
				WHERE CART_NO LIKE '20050401%';

--			SELECT TO_CHAR(SYSDATE, 'YYYYMMDD') || TRIM(TO_CHAR(MAX(TO_NUMBER(SUBSTR(CART_NO, 9))) + 1, '00000'))
--				FROM CART
--				WHERE CART_NO LIKE '20210224%';

			CREATE OR REPLACE FUNCTION FN_CART_NO(P_DATE IN DATE) RETURN CHAR
			IS
				V_NUM NUMBER := 0;
				V_COUNT NUMBER := 0;
				V_DAY CHAR(9) := TO_CHAR(P_DATE, 'YYYYMMDD')||'%';
				V_CART_NO CART.CART_NO%TYPE;
			BEGIN
				SELECT COUNT(*) INTO V_COUNT
					FROM CART
					WHERE CART_NO LIKE V_DAY;
				V_NUM := V_COUNT + 1;
				V_CART_NO := TO_CHAR(P_DATE, 'YYYYMMDD') || TRIM(TO_CHAR(V_NUM, '00000'));
				RETURN V_CART_NO;
			END;

			SELECT FN_CART_NO(TO_DATE('20050810')) FROM DUAL;

	사용 예)
		오늘이 2005년 8월 10일이라고 가정하고 다음 자료를 입력하시오.
		구매 회원 : 탁원재 ( 'n001' )
		상품 코드 : 남성 봄 자켓 2 ( 'P202000014' )
		구매 수량 : 2
			INSERT INTO CART(CART_MEMBER, CART_NO, CART_PROD, CART_QTY)
				VALUES('n001', NVL((
					SELECT CART_NO
						FROM CART
						WHERE CART_MEMBER = 'n001'
							AND CART_NO LIKE '20050810%'
							AND ROWNUM <= 1
				), FN_CART_NO(TO_DATE('20050810'))), 'P202000014', 2)

		상품 코드 : 남성 향수 ( 'P302000011' )
		구매 수량 : 5
			INSERT INTO CART(CART_MEMBER, CART_NO, CART_PROD, CART_QTY)
				VALUES('n001', NVL(
						(
							SELECT CART_NO
								FROM CART
								WHERE CART_MEMBER = 'n001'
									AND CART_NO LIKE '20050810%'
									AND ROWNUM <= 1
						), FN_CART_NO(TO_DATE('20050810'))), 'P302000011', 5);

		SELECT *
			FROM CART
			WHERE CART_MEMBER = 'n001'
				AND CART_NO LIKE '20050810%';

		DECLARE
			V_COUNT  NUMBER:=0;
			V_CART_NO NUMBER:=0;
		BEGIN
			SELECT COUNT(*) INTO V_COUNT
				FROM CART
				WHERE SUBSTR(CART_NO,1,8)='20050810'
					AND CART_MEMBER='n001';
			IF V_COUNT = 0 THEN
				INSERT INTO CART
					VALUES('n001',FN_CART_NO(TO_DATE('20050810')),'P302000011',5);
			ELSE
				SELECT CART_NO INTO V_CART_NO
					FROM CART
					WHERE SUBSTR(CART_NO,1,8)='20050810'
						AND CART_MEMBER='n001'; 
			INSERT INTO CART
				VALUES('n001',V_CART_NO,'P302000011',5);
			END IF;
			COMMIT;
		END;

		DELETE CART WHERE CART_NO LIKE '200508%';

		SELECT *  FROM CART WHERE CART_NO LIKE '200508%';