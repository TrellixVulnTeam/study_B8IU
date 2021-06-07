2021-02-19-02) 함수 ( FUNCTION )

	- 미리 구성하여 컴파일한 실행가능한 모듈
	- 함수는 중첩 사용이 가능
	- 단일행 함수
		테이블에 저장된 개별 행을 대상으로 함수를 적용하여 하나의 결과를 반환
	- 복수행 함수
		여러 행을 그룹화하여 결과를 처리한 후 하나의 결과를 반환하는 함수.
		그룹함수 ( SUM, AVG, COUNT, MIN, MAX 등 )

1. 문자열 함수
	1) 문자열 결합 연산자
		- '||' ( 자바의 문자열 결합연산자 '+'와 동일 기능 )
		- 문자열 결합 함수 CONCAT()와 같은 기능

		사용 형식
			문자열 || 문자열

		사용 예)
			회원 테이블에서 남성회원이면서 마일리지가 2000 이상 보유한 회원을 조회하시오.
			단, 주민번호는 'XXXXXX-XXXXXXX'형식으로 출력하시오.
			Alias는 회원번호, 회원명, 주민번호, 마일리지
				SELECT MEM_ID AS 회원번호,
						MEM_NAME AS 회원명,
						MEM_REGNO1 || '-' || MEM_REGNO2 AS 주민번호,
						MEM_MILEAGE AS 마일리지
					FROM MEMBER
					WHERE SUBSTR(MEM_REGNO2, 1, 1) IN ('1', '3')
						AND MEM_MILEAGE >= 2000;

	2) CONCAT
		- 주어진 두 문자열을 결합하여 하나의 문자열을 반환
		- '||'와 같은 기능

		사용 형식
			CONCAT(S1, S2)

		사용 예)
			회원 테이블에서 남성회원이면서 마일리지가 2000 이상 보유한 회원을 조회하시오.
			단, 주민번호는 'XXXXXX-XXXXXXX'형식으로 출력하시오.
			Alias는 회원번호, 회원명, 주민번호, 마일리지
				SELECT MEM_ID AS 회원번호,
						MEM_NAME AS 회원명,
						CONCAT(CONCAT(MEM_REGNO1, '-'), MEM_REGNO2) AS 주민번호,
						MEM_MILEAGE AS 마일리지
					FROM MEMBER
					WHERE SUBSTR(MEM_REGNO2, 1, 1) IN ('1', '3')
						AND MEM_MILEAGE >= 2000;

	3) LOWER, UPPER, INITCAP
		- 'LOWER' : 주어진 문자열 내의 자료 중 대문자를 모두 소문자로 변환
		- 'UPPER' : 주어진 문자열 내의 자료 중 소문자를 모두 대문자로 변환
		- 'INITCAP' : 주어진 문자열 내의 자료 중 단어의 첫 글자만 대문자로 변환

		사용 예)
			상품테이블 ( PROD ) 에서 분류코드가 'p201'에 속한 자료를 조회하시오.
			Alias는 상품코드, 상품명, 분류코드, 판매가격
				SELECT PROD_ID AS 상품코드,
						PROD_NAME AS 상품명,
						PROD_LGU AS 분류코드,
						PROD_SALE AS 판매가격
					FROM PROD
					WHERE LOWER(PROD_LGU) = 'p201';
--					WHERE PROD_LGU = UPPER('p201');

		사용 예)
			사원 테이블에서 EMAIL 컬럼의 값을 소문자로 변환하시오
			SELECT EMPLOYEE_ID,
					EMP_NAME,
					LOWER(EMAIL),
					INITCAP(EMAIL)
				FROM EMPLOYEES;

	4) LPAD(c1, n[, c2]), RPAD(c1, n[, c2])
		- 지정된 길이 n만큼 확보하여 c1을 채우고 남는 공간 ( 왼쪽 : LPAD, 오른쪽 : RPAD ) 을 c2로 채움
		- c2가 생략되면 공백으로 채움

		사용 예)
			상품 테이블에서 상품명을 30바이트로 출력하되 남는 기억간(오른쪽)에 '^' 문자를 삽입하여 출력하시오.
				SELECT PROD_ID,
						RPAD(PROD_NAME, 30, '^') AS 상품명1,
						LPAD(PROD_NAME, 30, '^') AS 상품명2
					FROM PROD
					WHERE ROWNUM <= 10;

		사용 예)
			상품테이블에서 분류코드 'p101'에 속한 상품 정보를 출력하시오.
			단, 금액은 3자리마다 자리점 ( ',' ) 을 삽입하고 15자리에 출력할 것
			Alias는 상품명, 매입가격, 매출가격, 거래처코드
				SELECT PROD_NAME AS 상품명,
						LPAD(TO_CHAR(PROD_COST, '9,999,999'), 15) AS 매입가격,
						TO_CHAR(PROD_PRICE, '999,999,999') AS 매출가격,
						PROD_BUYER AS 거래처코드
					FROM PROD
					WHERE LOWER(PROD_LGU) = 'p101';

	5) LTRIM(c1 [, c2]), RTRIM(c1 [, c2]), TRIM(c1)
		- 주어진 문자열 자료 c1에서 왼쪽에서 ( LTRIM ) 또는 오른쪽에서 ( RTRIM ) c2를 찾아 삭제
		- c2가 생략되면 공백을 찾아 삭제
		- TRIM은 양쪽의 공백을 모두 삭제
		- 단, 단어 내부 ( 문자열 내부 ) 의 공백은 삭제할 수 없음 ( REPLACE 함수 사용 )

		예)
			사원테이블에서 사원명 ( EMP_NAME ) 의 데이터 타입을 VARCHAR2에서 CHAR로 변경하시오.
			ALTER TABLE EMPLOYEES
					MODIFY(EMP_NAME CHAR(80));
					SELECT EMP_NAME
				FROM EMPLOYEES;

			SELECT RTRIM(EMP_NAME)
				FROM EMPLOYEES;

			ALTER TABLE EMPLOYEES
				MODIFY(EMP_NAME VARCHAR(80));

			UPDATE EMPLOYEES
				SET EMP_NAME = TRIM(EMP_NAME);

			COMMIT;

		사용 예)
			상품 테이블에서 상품명 중 '여성'이라는 문자열을 왼쪽에서 찾아 삭제하시오.
				SELECT PROD_ID AS 상품코드,
						PROD_NAME AS 상품명,
						LTRIM(PROD_NAME, '여성') AS 상품명2,
						LTRIM(LTRIM(PROD_NAME, '여성')) AS 상품명3,
						RTRIM(PROD_NAME, '자켓 1') AS 상품명4
					FROM PROD;