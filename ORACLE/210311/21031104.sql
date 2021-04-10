2021-03-11-04)
	3) FOR 문
		. 반복 횟수를 알고 있거나, 반복 횟수가 중요한 역할을 수행할 때 사용.
		
		사용 형식
			FOR 인덱스 IN[ REVERSE] 초기값 .. 최종값
			LOOP
				반복처리문;
			END LOOP;
		
		- '인덱스'는 시스템에서 자동 설정해 줌 ( 선언하지 않음 )
		- 역순으로 처리할 대눈 'REVERSE'만 추가 기술
			초기, 최종값 기술 위치 변동 없음

		사용 예)
			구구단 4단 출력
				DECLARE
					V_BASE NUMBER := 4;
				BEGIN
					FOR CNT IN 1..9 LOOP
						DBMS_OUTPUT.PUT_LINE(V_BASE || ' * ' || CNT || ' = ' || V_BASE * CNT);
					END LOOP;
				END;

		사용 형식
			FOR 레코드 IN 커서명[(값LIST)] LOOP
				반복처리문;
			END LOOP;

		- 커서의 컬럼들을 참조할 때는 '레코드명.컬럼명'으로 참조.
		- OPEN, FETCH, CLOSE문 생략;

		사용 예)
			LOOP로 구성한 CURSOR문을 FOR로 재구성하시오.
				DECLARE
					CURSOR CUR_BUYPROD02
					IS
						SELECT BUY_PROD,
								PROD_NAME,
								SUM(BUY_QTY) AS SQTY,
								SUM(BUY_QTY * PROD_COST) AS SAMT
							FROM BUYPROD, PROD
							WHERE PROD_ID = BUY_PROD
								AND TO_CHAR(BUY_DATE, 'YYYYMM') = '200503'
							GROUP BY BUY_PROD,
								PROD_NAME;
				BEGIN
					DBMS_OUTPUT.PUT_LINE('--------------------');
					FOR REC_BUY01 IN CUR_BUYPROD02 LOOP
						DBMS_OUTPUT.PUT_LINE('순번		' || CUR_BUYPROD02 % ROWCOUNT);
						DBMS_OUTPUT.PUT_LINE('제품번호	' || REC_BUY01.BUY_PROD);
						DBMS_OUTPUT.PUT_LINE('제품명	' || REC_BUY01.PROD_NAME);
						DBMS_OUTPUT.PUT_LINE('매입수량	' || REC_BUY01.SQTY);
						DBMS_OUTPUT.PUT_LINE('매입금액	' || REC_BUY01.SAMT);
						DBMS_OUTPUT.PUT_LINE('--------------------');
					END LOOP;
				END;