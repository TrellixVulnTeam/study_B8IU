2021-02-15-01) 자료형
2. 숫자자료형
	- number 로 제공
	- 실수, 정수 모두 처리 가능

	사용 형식
		NUMBER [(정밀도 |*[, 스케일])]

	. 표현 범위 : 10E-130 ~ 999.9999..9E125
	. 정밀도 : 전체자리수 ( 1 ~ 38 )
	. 스케일 : 소숫점 이하의 자릿수
	. '*'는 38자리 이내에서 사용자가 입력한 데이터를 저장할 수 있도록 시스템이 자리를 확보
	. '스케일'이 생략되면 자동으로 '0'으로 간주
	. 저장은 스케일 + 1번째 자리에서 반올림하여 '스케일' 자리수까지 저장
	. '스케일'이 음수이면 정수부분에서 반올림이 수행

	사용 예)
		1) 정밀도 > 스케일
			. NUMBER;
			. NUMBER(*, 3);
			. NUMBER(10, 3);
			. NUMBER(10);

			----------------------------------------------------------------------
			입력 값			선언				저장 값
			----------------------------------------------------------------------
			12345678.4567	NUMBER(10, 2)	12345678.46
			12345678.4567	NUMBER			12345678.4567
			12345678.8567	NUMBER(10)		12345679
			12345678.4567	NUMBER(*, 2)	12345678.46
			12345678.4567	NUMBER(9, 2)	오류

		2) 정밀도 < 스케일
			. 정밀도는 '0'이 아닌 유효숫자의 갯수
			. [스케일 - 정밀도] : 소숫점이하에서 맨 처음에 존재하는 '0'의 갯수
			. 스케일 : 소숫점이하의 자릿수

			----------------------------------------------------------------------
			입력 값			선언				저장 값
			----------------------------------------------------------------------
			123.4567		NUMBER(2, 4)	오류
			0.23			NUMBER(3, 5)	오류
			0.023			NUMBER(2, 3)	0.023
			0.0023			NUMBER(2, 4)	0.0023
			0.0002345		NUMBER(3, 6)	0.000235

	3. 날짜형
		- 날짜 자료 ( 년, 월, 일, 시, 분, 초 )
		- DATE ( 기본형 ), TIMESTAMP ( TIME ZONE 정보 처리 )
		1) DATE
			. 기본 날짜형
			. '+' 와 '-' 연산이 가능 - 결과는 날짜형으로 반환

			사용 형식
				컬럼명 DATE;
				- SYSDATE : 시스템이 제공하는 날짜데이터를 반환하는 함수

			사용 예)
				CREATE TABLE TEMP05 (
					COL1 DATE,
					COL2 DATE,
					COL3 DATE
				);

				INSERT INTO TEMP05
					VALUES(SYSDATE, SYSDATE - 20, SYSDATE + 20);

				INSERT INTO TEMP05
					VALUES(SYSDATE, '20201223', TO_DATE('20210120102345', 'YYYYMMDDHH24MISS'));

				SELECT *
					FROM TEMP05;

				SELECT TO_CHAR(COL1, 'YYYY-MM-DD HH24:MI:SS') AS COL1,
						TO_CHAR(COL2, 'YYYY-MM-DD HH24:MI:SS') AS COL2,
						TO_CHAR(COL3, 'YYYY-MM-DD HH24:MI:SS') AS COL3
					FROM TEMP05;

		2) TIMESTAMP
			. 시간대 ( TIME ZONE ) 정보와 10억분의 1초 단위의 정교한 시간 정보 저장

			사용 형식
				컬럼명 TIMESTAMP;
					-- 시간대 정보 제공하지 않음
				컬럼명 TIMESTAMP WITH TIME ZONE;
					-- 시간대 정보 ( 대륙명 / 도시명 ) 제공
				컬럼명 TIMESTAMP WITH LOCAL TIME ZONE;
					-- 서버에 설치된 시간대 정보 제공. 보통 TIMESTAMP와 동일

			사용 예)
				CREATE TABLE TEMP06 (
					COL1 DATE,
					COL2 TIMESTAMP,
					COL3 TIMESTAMP WITH TIME ZONE,
					COL4 TIMESTAMP WITH LOCAL TIME ZONE
				);

				INSERT INTO TEMP06
					VALUES (SYSDATE, SYSDATE, SYSDATE, SYSDATE);

				SELECT *
					FROM TEMP06;