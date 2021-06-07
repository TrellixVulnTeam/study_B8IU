2021-02-24-02) 날짜 변환 함수

1. TO_DATE(c[, fmt])
	- 날짜형식의 문자열 c에 저장된 자료를 날짜형으로 변환
	- 'fmt'는 TO_CHAR함수와 동일

	예)
		SELECT TO_DATE('20051001')
			FROM DUAL;

		SELECT TO_DATE('2005-10-01')
			FROM DUAL;

		SELECT TO_DATE('2005년 10월 01일', 'YYYY"년" MM"월" DD"일"')
			FROM DUAL;

		SELECT TO_DATE('2021-02-24 10:10:34', 'YYYY-MM-DD HH:MI:SS')
			FROM DUAL;