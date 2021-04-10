2021-02-09-02) DML (Data Manipulation Language)
	- 데이터 조작어
	- INSERT, UPDATE, DELETE 명령어 포함

1. INSERT 명령
	. 데이터를 테이블에 신규 등록할 때 사용하는 명령

	사용 형식
		INSERT INTO 테이블명[(컬럼명1, 컬럼명2, ...)]
			VALUES(값1, 값2, ...);

	. (컬럼명1, 컬럼명2, ...)을 생략하는 경우
		→ 테이블 생성 시 만들어진 모든 컬럼에
			생성된 순서에 맞도록 VALUES 절의 값이 ( ) 안에 정의 되어야 함.
	. (컬럼명1, 컬럼명2, ...)을 기술하는 경우
		→ 데이터 입력이 불필요한 컬럼을 생략
			단, 컬럼 제약사항이 NOT NULL인 경우, 생략할 수 없다.
	. 사용 된 '컬럼명'의 수와 '값'의 개수와 순번은 반드시 일치해야 함.

	사용 예)
		다음 자료를 회원 테이블(tb_mem)에 삽입하시오.
			[자료]
				회원번호	이름			주소					전화번호
			------------------------------------------------------------
				M1001	홍길동		대전광역시 중구 대흥동		042-222-8202
				M1002	이길선		서울시 성북구 신장위동		02-7654-0987
				M1003	천상봉		충북 제천시 신월동
				M1004	강감찬
            ------------------------------------------------------------

			INSERT INTO tb_mem
				VALUES ('M1001', '홍길동', '대전광역시 중구 대흥동', '042-222-8202');

			INSERT INTO tb_mem (MEM_ID, MEM_NAME, MEM_ADDR, MEM_TEL_NO)
				VALUES ('M1002', '이길선', '서울시 성북구 신장위동', '02-7654-0987');

			INSERT INTO tb_mem
				VALUES ('M1003', '천상봉', '충북 제천시 신월동', '');

			INSERT INTO tb_mem (MEM_ID, MEM_NAME, MEM_ADDR)
				VALUES ('M1004', '강감찬', NULL);

			SELECT *
				FROM tb_mem;

		문제] 다음 자료를 상품 테이블(tb_goods)에 입력하시오.
				상품코드		상품명			가격
			------------------------------------------------------------
				G11001		마우스			15,000
				G12002		USB ( 64G )	25,000
				G20001		마커펜
				G21001		볼펜
			------------------------------------------------------------

			INSERT INTO TB_GOODS (GOOD_ID, GOOD_NAME, GOOD_PRICE)
				VALUES ('G11001', '마우스', 15000);

			INSERT INTO TB_GOODS (GOOD_ID, GOOD_NAME, GOOD_PRICE)
				VALUES ('G12002', 'USB(64G)', 25000);

			INSERT INTO TB_GOODS (GOOD_ID, GOOD_NAME)
				VALUES ('G20001', '마커펜');

			INSERT INTO TB_GOODS (GOOD_ID, GOOD_NAME)
				VALUES ('G21001', '볼펜');

			SELECT *
				FROM TB_GOODS;

		문제] 다음의 자료를 주문 테이블(ORDERS)에 입력하시오.
			------------------------------------------------------------
				주문번호 : 1
				주문일자 : 오늘
				주문금액 : ?
				상태 : ?
				주문자 : 천상봉
            ------------------------------------------------------------

			INSERT INTO ORDERS(ORDER_ID, MEM_ID)
				VALUES (1, 'M1003');

			SELECT *
				FROM ORDERS;

    사용 예) 다음 자료를 주문 상세 테이블( ORDERS_GOODS ) 에 저장하시오.
			상품코드		주문번호		수량
		---------------------------------------------------------------
			G12002		1			5
			G21001		1			24
			G20001		1			10
		---------------------------------------------------------------
		INSERT INTO ORDERS_GOODS(ORDER_ID, GOOD_ID, QTY)
			VALUES(1, 'G12002', 5);

		INSERT INTO ORDERS_GOODS(ORDER_ID, GOOD_ID, QTY)
			VALUES(1, 'G21001', 24);

		INSERT INTO ORDERS_GOODS(ORDER_ID, GOOD_ID, QTY)
			VALUES(1, 'G20001', 10);

		INSERT INTO ORDERS_GOODS(ORDER_ID, GOOD_ID, QTY)
			VALUES(1, 'G11001', 2);

		UPDATE ORDERS
			SET ORDER_AMT = (
				SELECT SUM(GOOD_PRICE * QTY)
					FROM ORDERS_GOODS A, TB_GOODS B
					WHERE A.GOOD_ID = B.GOOD_ID
				),
				ORDER_FLAG = '2'
			WHERE ORDER_ID = 1;

		SELECT *
			FROM ORDERS_GOODS;
			
		SELECT *
			FROM ORDERS;

		COMMIT;