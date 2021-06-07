2021-03-09-01)
VIEW 객체
	- 가상의 테이블
	- SELECT 문의 결과로 생성되는 독립적 객체
	- 특정자료의 접근을 제한할 때 ( 보안 )
		복수개의 테이블에 분산된 자료를 빈번히 JOIN한 결과를 사용할 때
		소수의 컬럼이나 행만 필요할 때 주로 사용
	
	사용 형식
		CREATE[ OR REPLACE] VIEW 뷰이름[(컬럼명1, ...)]
		AS
			SELECT 문
			[WITH CHECK OPTION]
			[WITH READ ONLY];

	. '컬럼명1, ...'
		생성되는 뷰에 부여되는 컬럼 명
		생략되면 원본 테이블의 컬럼명이 적용 됨
	. 'WITH CHECK OPTION'
		뷰를 생성에하는 SELECT 문에서 조건이 사용된 경우,
		그 조건에 부합하지 않는 DML 명령 ( INSERT, UPDATE )을 사용하지 못함.
	. 'WITH READ ONLY'
		뷰의 결과를 수정하면 원본 테이블도 함께 수정 됨
		이를 허용하지 않을 때 사용하는 옵션

	사용 예)
		2005년 2월 제품 별 매입 현황을 뷰로 작성하시오.
		뷰는 상품코드, 상품명, 매입수량으로 구성
			CREATE OR REPLACE VIEW V_BUYPROD
			AS
				SELECT A.BUY_PROD AS 상품코드,
						B.PROD_NAME AS 상품명,
						A.BUY_QTY AS 매입수량
					FROM BUYPROD A,
						PROD B
					WHERE A.BUY_PROD = B.PROD_ID
						AND TO_CHAR(A.BUY_DATE, 'YYYYMM') = '200502'
					ORDER BY A.BUY_PROD;
			SELECT *
				FROM V_BUYPROD;
			SELECT *
				FROM BUYPROD
				WHERE BUY_PROD = 'P102000006'
					AND TO_CHAR(BUY_DATE, 'YYYYMM') = '200502';

			VIEW 내용 변경
				상품코드가 'P102000006'인 상품의 매입 수량을 50으로 변경
					UPDATE V_BUYPROD
						SET 매입수량 = 50
						WHERE 상품코드 = 'P102000006';

			BUYPROD ( 원본 테이블 ) 내용 변경
				상품코드가 'P102000006'인 상품의 매입 수량을 10으로 변경
					UPDATE BUYPROD
						SET BUY_QTY = 10
						WHERE BUY_PROD = 'P102000006'
							AND TO_CHAR(BUY_DATE, 'YYYYMM') = '200502';

	사용 예
		회원 테이블에서 마일리지가 5000이상인 회원 정보를 조회하고 뷰를 생성하시오
			CREATE OR REPLACE VIEW V_MEM(MID, MNAME,MILEAGE)
			AS
				SELECT MEM_ID,
						MEM_NAME,
						MEM_MILEAGE
					FROM MEMBER
					WHERE MEM_MILEAGE >= 5000
					WITH CHECK OPTION;


			VIEW 내용 확인
				SELECT *
					FROM V_MEM;

--			V_MEM 뷰에서 구길동 회원의 마일리지를 4300으로 변경
			UPDATE V_MEM
				SET MILEAGE = 4300
				WHERE MID = '1001';

--			원본 테이블에서 'a001' 회원의 마일리지를 6000에서 2000으로 변경
			UPDATE MEMBER
				SET MEM_MILEAGE = 2000
				WHERE MEM_ID = 'a001';

			CREATE OR REPLACE VIEW V_MEM(MID, MNAME, MILEAGE)
			AS
				SELECT MEM_ID,
						MEM_NAME,
						MEM_MILEAGE
					FROM MEMBER
					WHERE MEM_MILEAGE >= 5000
					WITH READ ONLY;
				
			SELECT *
				FROM V_MEM;
			
--			VIEW ( V_MEM ) 에서 'e001' 마일리지를 6500에서 3500으로 변경
			UPDATE V_MEM
				SET MILEAGE = 3500
				WHERE MID='e001';