2021-03-11-01)
2. case문
	- 다중 분기기능 제공
	- java의 switch ~ case 와 유사
	- 표준 SQL에서는 SELECT 문에서 사용하나, PL/SQL에서는 BEGIN BLOCK에서 분기 목적으로 사용

	사용 형식
		CASE
			WHEN 표현식
				THEN 명령문;
			WHEN 표현식
				THEN 명령문;
					:
			ELSE 명령문;
		END CASE

	사용 형식
		CASE 표현식 
			WHEN 결과
				THEN 명령문;
			WHEN 결과
				THEN 명령문;
					:
			ELSE 명령문;
		END CASE

	사용 예)
		수도 요금 계산
		입력 자료
			사용량(톤)
		요금
			1 ~ 10
				톤 당 250원
			11 ~ 20
				톤 당 350원
			21 ~ 30
				톤 당 500원
			그 이상
				톤 당 750원
		예를 들어 25톤을 사용하면
			처음 10톤
				10 * 250 = 2500
			다음 10톤
				10 * 350 = 3500
			나머지 5톤
				5 * 500 = 2500
		------------------------------
							8500원
		물 이용 분담금 ( 하수구 사용료 )
				25 * 150 = 3750
		------------------------------
		합계					12250원
		------------------------------
			ACCEPT P_WATER PROMPT '물 사용량'
			DECLARE
				V_RES NUMBER := 0;
			BEGIN
				SELECT CASE
							WHEN '&P_WATER' > 30
								THEN 10 * 250 + 10 * 350 + 10 * 500 + ('&P_WATER' - 30) * 750 + '&P_WATER' * 150
							WHEN '&P_WATER' > 20
								THEN 10 * 250 + 10 * 350 + ('&P_WATER' - 20) * 500 + '&P_WATER' * 150
							WHEN '&P_WATER' > 10
								THEN 10 * 250 + ('&P_WATER' - 10) * 350 + '&P_WATER' * 150
							ELSE '&P_WATER' * 250 + '&P_WATER' * 150
						END CASE
					INTO V_RES
					FROM DUAL;
					DBMS_OUTPUT.PUT_LINE(V_RES);
			END;

			ACCEPT P_AMT PROMPT '수도 사용량 ( 톤 ) : '
			DECLARE
				V_AMT NUMBER := TO_NUMBER('&P_AMT');	-- 수도 사용량
				V_HAP NUMBER := 0;						-- 요금
			BEGIN
				CASE
					WHEN V_AMT <= 10
						THEN V_HAP := V_AMT * 250;
					WHEN V_AMT <= 20
						THEN V_HAP := 10 * 250 + (V_AMT - 10) * 350;
					WHEN V_AMT <= 30
						THEN V_HAP := 10 * 250 + 10 * 350 + (V_AMT - 20) * 500;
					ELSE V_HAP := 10 * 250 + 10 * 350 + 10 * 500 + (V_AMT - 30) * 750;
				END CASE;
				V_HAP := V_HAP + V_AMT * 150;

				DBMS_OUTPUT.PUT_LINE('물 사용량		' || V_HAP);
				DBMS_OUTPUT.PUT_LINE('수도 요금		' || V_HAP);
			END;