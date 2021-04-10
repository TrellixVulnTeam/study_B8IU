2021-02-23-03) 변환 함수
	- 자료형의 변환을 담당하는 함수
	- CAST, TO_CHAR, TO_NUMBER, TO_DATE가 제공

1. CAST(expr AS type)
	. expr로 표현된 값을 type 형식으로 변환

	예)
		SELECT MEM_ID,
				MEM_NAME,
				MEM_MILEAGE,
				CAST(MEM_MILEAGE AS CHAR(10)) AS CAST
			FROM MEMBER;

		SELECT SUBSTR(CART_NO, 1, 8),
				CAST(SUBSTR(CART_NO, 1, 8) AS DATE),
				CAST(SUBSTR(CART_NO, 9) AS NUMBER),
				CART_PROD,
				CART_QTY
			FROM CART
			WHERE ROWNUM <= 10;

2. TO_CHAR(c|d|n [, fmt])
	- 날짜, 숫자, 문자 자료를 지정된 형식의 문자열 자료로 변환

	형식지정문자열 ( fmt )
		-------------------------------------------------
		형식지정문자					의미
		-------------------------------------------------
		AD, BC, CC				세기
		YYYY, YYY, YY, Y		년도
		MONTH, MON, MM, RM		월
		W, WW, IW				주차
		Q						분기    
		DD, DDD, J				일
		DAY, DY, D				요일
		AM, PM[, A.M, P.M]		오전 / 오후
		HH, HH12, HH24			시간
		MI						분
		SS, SSSSS				초
		"문자열"					사용자 정의 문자열
		-------------------------------------------------

	SELECT TO_CHAR(SYSDATE, 'AD, BC, CC')
		FROM DUAL;

	SELECT TO_CHAR(SYSDATE, 'YYYY, YYY, YY, Y')
		FROM DUAL;

	SELECT TO_CHAR(SYSDATE, 'MONTH, MON, MM, RM')
		FROM DUAL;

	SELECT TO_CHAR(SYSDATE, 'W, WW, IW')
		FROM DUAL;

	SELECT TO_CHAR(SYSDATE, 'Q')
		FROM DUAL;

	SELECT TO_CHAR(SYSDATE, 'DD, DDD, J')
		FROM DUAL;

	SELECT TO_CHAR(SYSDATE, 'AM, PM')
		FROM DUAL;

	SELECT TO_CHAR(SYSDATE, 'HH, HH12, HH24')
		FROM DUAL;

	SELECT TO_CHAR(SYSDATE, 'MI')
		FROM DUAL;

	SELECT TO_CHAR(SYSDATE, 'SS, SSSSS')
		FROM DUAL;