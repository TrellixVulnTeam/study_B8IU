2021-02-23-02) 날짜 함수

1. SYSDATE
	- SYSTEM에서 제공하는 날짜 ( 년, 월, 일 ) 및 시간 ( 시, 분, 초 ) 정보를 반환
	- 덧셈과 뺄셈 계산의 대상이 됨
		연산 결과는 날짜의 수

	사용 예)
		SELECT SYSDATE,
				SYSDATE + 25,
				SYSDATE - 25,
				SYSDATE - TO_DATE('20200223'),
				TRUNC(SYSDATE) - TO_DATE('20200223')
			FROM DUAL;

2. ADD_MONTHS(d, n)
	- 주어진 날자데이터  d에 n개월을 더한 날짜 반환

	예)
		SELECT ADD_MONTHS(SYSDATE, 10) + 10
			FROM DUAL;

3. NEXT_DAY(d, c)
	- 주어진 날짜 데이터 d 이후 첫 번째 c요일의 날짜 변환.
	- c는 '월요일' 또는 '월' 등으로 기술 ( 현재의 환경설정에서 MONDAY 등은 사용 불가 )

예)
	SELECT NEXT_DAY(SYSDATE, '월'),
			NEXT_DAY(SYSDATE, '일요일'),
			NEXT_DAY(SYSDATE, '화'),
			NEXT_DAY(SYSDATE, '금요일')
		FROM DUAL;

4. LAST_DAY(d)
	- 주어진 날자 데이터 d에서 해당 월의 마지막 날짜 반환

	사용 예)
		SELECT LAST_DAY(TO_DATE('20070210'))
			FROM DUAL;

5. EXTRTACT(fmt FROM d)
	- 주어진 날짜 데이터 d에서 fmt로 정의된 결과를 반환
	- fmt는 YEAR, MONTH, DAY, HOUR, MINUTE, SECOND이며, 숫자로 취급

	사용 예)
		회원 테이블에서 회원들의 생년월일을 기준으로 하여 생일에 축하 문자를 전송하려 한다.
		오늘 보내야 할 회원목록을 출력하시오.
		Alias는 회원번호, 회원명, 생일, 핸드폰번호, 이메일주소
			SELECT MEM_ID AS 회원번호,
					MEM_NAME AS 회원명,
					MEM_BIR AS 생일,
					MEM_HP AS 핸드폰번호,
					MEM_MAIL AS 이메일주소
				FROM MEMBER
				WHERE EXTRACT(MONTH FROM SYSDATE) = EXTRACT(MONTH FROM MEM_BIR)
					AND EXTRACT(DAY FROM SYSDATE) = EXTRACT(DAY FROM MEM_BIR);

			SELECT MEM_ID AS 회원번호,
					MEM_NAME AS 회원명,
					MEM_BIR AS 생일,
					MEM_HP AS 핸드폰번호,
					MEM_MAIL AS 이메일주소
				FROM MEMBER
				WHERE TO_CHAR(MEM_BIR, 'MMDD') = TO_CHAR(SYSDATE + 7, 'MMDD');

			SELECT MEM_ID AS 회원번호,
					MEM_NAME AS 회원명,
					MEM_BIR AS 생일,
					MEM_HP AS 핸드폰번호,
					MEM_MAIL AS 이메일주소
				FROM MEMBER
				WHERE EXTRACT(MONTH FROM SYSDATE + 7) = EXTRACT(MONTH FROM MEM_BIR)
					AND EXTRACT(DAY FROM SYSDATE + 7) = EXTRACT(DAY FROM MEM_BIR);

	사용 예)
		회원 테이블에서 회원들의 생년월일을 기준으로 하여 생일에 축하 문자를 전송하려 한다.
		Alias는 회원번호, 회원명, 생일, 핸드폰번호, 이메일주소
			SELECT MEM_ID AS 회원번호,
					MEM_NAME AS 회원명,
					MEM_BIR AS 생일,
					MEM_HP AS 핸드폰번호,
					MEM_MAIL AS 이메일주소
				FROM MEMBER
				WHERE EXTRACT(MONTH FROM SYSDATE) = EXTRACT(MONTH FROM MEM_BIR);

UPDATE MEMBER
	SET MEM_BIR = TO_CHAR(EXTRACT(YEAR FROM MEM_BIR))
		|| TO_CHAR(EXTRACT(MONTH FROM SYSDATE))
		|| TO_CHAR(EXTRACT(DAY FROM SYSDATE));

SELECT TO_CHAR(EXTRACT(YEAR FROM MEM_BIR))
		|| TRIM(TO_CHAR(EXTRACT(MONTH FROM SYSDATE), '00'))
		|| TRIM(TO_CHAR(EXTRACT(DAY FROM SYSDATE), '00'))
	FROM MEMBER;