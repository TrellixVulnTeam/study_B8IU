2021-02-23-01) 숫자형 함수

4. MOD, REMAINDER
	- 나머지 값을 반환

	1) MOD(c, n)
		. 주어진 수 c를 n으로 나눈 나머지 반환
		. Java 언어의 % 연산자와 같은 기능

		사용 예)
			2000년 2월 23일이 무슨 요일인지 구하시오.
				SELECT CASE MOD(TO_DATE('20000223') - TO_DATE('00010101') - 1, 7)
							WHEN 1
								THEN '월요일'
							WHEN 2
								THEN '화요일'
							WHEN 3
								THEN '수요일'
							WHEN 4
								THEN '목요일'
							WHEN 5
								THEN '금요일'
							WHEN 6
								THEN '토요일'
							ELSE '일요일'
						END AS 요일
					FROM DUAL;

		사용 예)
			오늘이 무슨 요일인지 구하시오.
				SELECT CASE MOD(TRUNC(SYSDATE) - TO_DATE('00010101') - 1, 7)
							WHEN 1
								THEN '월요일'
							WHEN 2
								THEN '화요일'
							WHEN 3
								THEN '수요일'
							WHEN 4
								THEN '목요일'
							WHEN 5
								THEN '금요일'
							WHEN 6
								THEN '토요일'
							ELSE '일요일'
						END AS 요일,
						TRUNC(SYSDATE) - TO_DATE('00010101') AS 일수
					FROM DUAL;

	2) REMAINDER(c, n)
		. c를 n으로 나눈 나머지 반환
		. 내부적으로 MODS와 다른 방법으로 처리하여 다른 결과 반환
		. MOD
			나머지 = c - FLOOR(c / n) * n
		. REMAINDER
			나머지 = c - ROUND(c / n) * n

		예)
			13 / 5의 나머지
			1) MOD
			13 - FLOOR(13 / 5) * 5
			13 - FLOOR(2.6) * 5
			13 - 2 * 5
			3

	2) REMAINDER
		13 - ROUND(13 / 5) * 5
		13 - ROUND(2.6) * 5
		13 - 3 * 5
		-2

		SELECT MOD(13, 5),
				REMAINDER(13, 5)
			FROM DUAL;

		예)
			11 / 5의 나머지

			1) MOD
				11 - FLOOR(11 / 5) * 5
				11 - FLOOR(2.2) * 5
				11 - 2 * 5
				1

			2) REMAINDER
				11 - ROUND(11 / 5) * 5
				11 - ROUND(2.2) * 5
				13 - 2 * 5
				1

			SELECT MOD(11, 5),
					REMAINDER(11, 5)
				FROM DUAL;

5. CEIL(n), FLOOR(n)
	- 주어진 수 n에 가장 근접한 정수를 반환
	- CEIL은 n과 같거나 큰 수 중 가장 작은 정수
	- FLOOR는 n과 같거나 작은 수 중 가장 큰 정수

	ex)
		CEIL(23.56) → 24
		CEIL(-23.56) → -23
		FLOOR(23.56) → 23
		FLOOR(-23.56) → -24

6. WIDTH_BUCKET
	- 주어진 최솟값과 최댓값을 몇 개의 그룹으로 나누고 제시된 값이 어느 그룹에 속하는 지 반환

	사용 형식
		WIDTH_BUCKET(c, min, max, b)
		. c : 주어진 수
		. min : 구간의 하한값
		. max : 구간의 상한값
		. b : 나눌 구간의 개수

	사용 예)
		사원테이블에서 사원의 급여에 따른 등급을 구하여 출력하시오.
		급여를 2000부터 14000까지 6개 등급으로 나누고,
		급여가 많은 사원이 작은 등급을 부여받도록 하시오.
		Alias는 사원번호, 사원명, 급여, 등급
			SELECT EMPLOYEE_ID AS 사원번호,
					EMP_NAME AS 사원명,
					SALARY AS 급여,
					6 - WIDTH_BUCKET(SALARY, 2000, 14000, 6) + 1 || '등급' AS 등급
				FROM EMPLOYEES
				WHERE 2000 <= SALARY
					AND SALARY < 14000;

			SELECT EMPLOYEE_ID AS 사원번호,
					EMP_NAME AS 사원명,
					SALARY AS 급여,
					WIDTH_BUCKET(SALARY, 14000, 2000, 6) || '등급' AS 등급
				FROM EMPLOYEES
				WHERE 2000 < SALARY
					AND SALARY <= 14000;

	예)
		회원테이블에서 회원들의 마일리지를 기준으로 등급을 구하고,
		1 ~ 2등급 회원은 'VIP 회원'
		3 ~ 5등급 회원은 '일반회원'
		그 이하는 '준회원'을 비고란에 출력하시오.
		단, 구간은 마일리지 값을 500에서 8000까지 8개 구간으로 나누고 마일리지가 많은 회원의 등급이 작은 값을 나타내도록 한다.
		Alias는 회원번호, 회원명, 마일리지, 등급, 비고
			SELECT MEM_ID AS 회원번호,
					MEM_NAME AS 회원명,
					MEM_MILEAGE AS 마일리지,
					8 - WIDTH_BUCKET(MEM_MILEAGE, 500, 8000, 8) + 1 AS 등급,
					CASE
						WHEN 8 - WIDTH_BUCKET(MEM_MILEAGE, 500, 8000, 8) + 1 BETWEEN 0 AND 2
							THEN 'VIP 회원'
						WHEN 8 - WIDTH_BUCKET(MEM_MILEAGE, 500, 8000, 8) + 1 BETWEEN 3 AND 5
							THEN '일반회원'
						ELSE '준회원'
					END AS 비고
			FROM MEMBER
			ORDER BY MEM_MILEAGE DESC;