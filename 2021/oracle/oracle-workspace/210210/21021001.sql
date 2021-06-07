2021-02-10-01)
2. update문
	- 해당 자료가 테이블에 존재
	- 필요한 컬럼의 값을 변경

	사용 형식
		UPDATE 테이블명
			SET 컬럼명1=값[,]
				[컬럼명2=값,
					:
				컬럼명n = 값n]
			[WHERE 조건];

	.'WHERE 조건'절이 생략되면 모든 행의 값을 변경함

	예) 사원 테이블(EMPLOYEES)에서 부서번호가 50번 부서에 속한 사원의 급여를 20% 추가하여 저장하시오.
		SELECT * FROM EMPLOYEES;
		
		SELECT EMP_NAME AS 사원명,
				DEPARTMENT_ID AS 부서번호,
				SALARY AS 급여,
				SALARY*1.2 AS 인상된급여
			FROM EMPLOYEES
			WHERE DEPARTMENT_ID = 50;

	데이터 변경
		UPDATE EMPLOYEES
			SET SALARY = SALARY * 1.2
			WHERE DEPARTMENT_ID = 50;

		ROLLBACK;

	사용 예)
		회원테이블( MEMBER ) 에서 회원번호 'f001'회원의 주민등록번호 ( MEM_REGNO1, MEM_REGNO2 ) 와
		생년월일 ( MEMBER_BIR ) 을 다음 자료로 변경하시오.
		
		1)
			주민번호 1 : 751228 → 021228
			주민번호 2 : 1459919 → 3459919
		2)
			생년월일 : 1972/11/04 → 2002/12/18

		SELECT *
			FROM MEMBER
			WHERE MEM_REGNO1 = '751228';

		SELECT *
			FROM MEMBER
			WHERE MEM_REGNO1 = '021228';

		UPDATE MEMBER
			SET MEM_REGNO1 = '021228',
				MEM_REGNO2 = '3459919',
				MEM_BIR = TO_DATE('2022/12/18')
			WHERE MEM_REGNO1 = '751228';

		COMMIT;

3. DELETE문
	- 테이블에 저장된 자료를 삭제
	- WHERE 절이 생략되면 해당 테이블의 모든 행을 삭제 → 빈 테이블을 만듬

	사용 형식
		DELETE 테이블명
			[WHERE 조건];

	.DELETE 문은 ROLLBACK의 대상임.

	사용 예)
		회원 테이블에서 '오철희' 회원 자료를 삭제하시오.
			DELETE MEMBER;

			SELECT *
				FROM MEMBER;

	사용 예)
		장바구니 테이블 ( CART ) 에서 'k001' 회원자료를 삭제하시오.
		DELETE CART;

		SELECT *
			FROM CART
			WHERE CART_MEMBER = 'k001';

		DELETE CART
			WHERE CART_MEMBER = 'k001';

		ROLLBACK;