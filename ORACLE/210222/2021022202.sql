2021-02-22-02) 숫자형 함수

1. 수학적 함수 ( ABS, SIGN, POWER, SQRT, ... 등 )
	. ABS(n) : n의 절대값
	. SIGN(n) : n의 부호 ( 음수 : -1, 양수 : 1, 0 : 0 )
	. POWER(n, e) : n의 e승
	. SQRT(n) : n의 평방근 ( root 값 )

	사용 예)
		SELECT ABS(-100),
				ABS(0.000001),
				SIGN(10000000),
				SIGN(-10000000),
				SIGN(0.0000001),
				SIGN(-0.0000001),
				SIGN(0),
				POWER(2, 10),
				SQRT(1024)
			FROM DUAL;

2. GREATEST, LEAST
	. 주어진 자료 중 최대값과 최소값을 구함

	사용 형식
		GREATEST(n1, n2, ...) : n1, n2, ... 중 최댓값 반환
		LEAST(n1, n2, ...) : n1, n2, ... 중 최솟값 반환

	예)
		SELECT GREATEST(20, 40, 5, 70),
		LEAST(20, 40, 5, 70)
		FROM DUAL;

	예)
		회원 테이블에서 회원들이 보유한 마일리지를 조회하여 1000 미만인 회원들의 마일리지를 1000으로 만드시오.
		Alias는 회원번호, 회원명, 보유 마일리지, 수정 마일리지
			SELECT MEM_ID AS 회원번호,
					MEM_NAME AS 회원명,
					MEM_MILEAGE AS "보유 마일리지",
					GREATEST(MEM_MILEAGE, 1000) AS "수정 마일리지"
				FROM MEMBER;

	** 회원 테이블에서 최대 마일리지를 구하시오.

		SELECT MEM_NAME,
				MEM_MILEAGE
			FROM MEMBER
			WHERE MEM_MILEAGE = (
						SELECT MAX(MEM_MILEAGE) FROM MEMBER
					);

		SELECT MEM_NAME AS 회원명,
				MEM_MILEAGE AS 마일리지
			FROM (
					SELECT MAX(MEM_MILEAGE) AS MILE_MAX FROM MEMBER
				) A,
				MEMBER B
			WHERE A.MILE_MAX = B.MEM_MILEAGE;

3. ROUND, TRUNC
	. 주어진 숫자자료를 반올림 ( ROUND ) 또는 자리버림 ( TRUNC ) 연산 후 결과값 반환

	사용 형식
		ROUND(n[, i])
			i가 양수이면 주어진 자료 n에서 소숫점 이하 i + 1번째 자리에서 반올림하여 i번재 수까지 반환
			i가 음수이면 주어진 자료 n에서 정수부의 i번째 자리에서 반올림하여 결과 반환
			i가 생략되면 0으로 간주
		TRUNC(n[, i])
			i가 양수이면 주어진 자료 n에서 소숫점 이하 i + 1번째 자리에서 버림하여 i번째 수까지 반환
			i가 음수이면 주어진 자료 n에서 정수부의 i번째 자리에서 버림하여 결과 반환
			i가 생략되면 0으로 간주

	예)
		사원 테이블의 자료를 이용하여 이번 달 급여를 조회하시오.
			. 이번 달에 보너스를 지급 함
			. 보너스 = 급여 * 0.13
			. 지급액 = 본봉 + 보너스
		Alias는 사원번호, 사원명, 본봉, 보너스, 지급액이다.
		단, 보너스 및 지급액은 소수 첫 자리까지 나타내시오. ( 소숫점 이하 2번째 자리에서 반올림 )
			SELECT EMPLOYEE_ID AS 사원번호,
					EMP_NAME AS 사원명,
					SALARY AS 본봉,
					SALARY * 0.13 AS 보너스1,
					ROUND(SALARY * 0.13, 1) AS 보너스2,
					ROUND(SALARY * 1.13, 1) AS 지급액
				FROM EMPLOYEES;

	예)
		사원 테이블의 자료를 이용하여 이번 달 급여를 조회하시오.
			. 이번 달에 보너스를 지급 함
			. 보너스 = 급여 * 0.13
			. 지급액 = 본봉 + 보너스
		Alias는 사원번호, 사원명, 본봉, 보너스, 지급액이다.
		단, 보너스 및 지급액은 10의 자리까지 나타내시오. ( 1의 자리에서 반올림 )
			SELECT EMPLOYEE_ID AS 사원번호,
					EMP_NAME AS 사원명,
					SALARY AS 본봉,
					SALARY * 0.13 AS 보너스1,
					ROUND(SALARY * 0.13, -1) AS 보너스2,
					ROUND(SALARY * 1.13, -1) AS 지급액
				FROM EMPLOYEES;

	예)
		사원 테이블의 자료를 이용하여 이번 달 급여를 조회하시오.
			. 이번 달에 보너스를 지급 함
			. 보너스 = 급여 * 0.13
			. 지급액 = 본봉 + 보너스
		Alias는 사원번호, 사원명, 본봉, 보너스, 지급액이다.
		단, 보너스 및 지급액은 소수 첫 자리까지 나타내시오. ( 소숫점 이하 2번째 자리에서 절삭 )
			SELECT EMPLOYEE_ID AS 사원번호,
					EMP_NAME AS 사원명,
					SALARY AS 본봉,
					SALARY * 0.13 AS 보너스1,
					TRUNC(SALARY * 0.13, 1) AS 보너스2,
					TRUNC(SALARY * 1.13, 1) AS 지급액
				FROM EMPLOYEES;

	예)
		사원 테이블의 자료를 이용하여 이번 달 급여를 조회하시오.
			. 이번 달에 보너스를 지급 함
			. 보너스 = 급여 * 0.13
			. 지급액 = 본봉 + 보너스
		Alias는 사원번호, 사원명, 본봉, 보너스, 지급액이다.
		단, 보너스 및 지급액은 10의 자리까지 나타내시오. ( 1의 자리에서 절삭 )
			SELECT EMPLOYEE_ID AS 사원번호,
					EMP_NAME AS 사원명,
					SALARY AS 본봉,
					SALARY * 0.13 AS 보너스1,
					TRUNC(SALARY * 0.13, -1) AS 보너스2,
					TRUNC(SALARY * 1.13, -1) AS 지급액
				FROM EMPLOYEES;

UPDATE EMPLOYEES
	SET SALARY = SALARY * 1.13;

COMMIT;