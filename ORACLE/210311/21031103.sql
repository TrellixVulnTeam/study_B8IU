2021-03-11-03)
	2)
		WHILE문
			. 응용 프로그램 개발언어의 WHILE과 유사

			사용 형식
				WHILE 조건 LOOP
					반복처리문;
				END LOOP; 
			- '조건'의 결과가 FALSE인 경우, 반복을 벗어남

			사용 예)
				구구단의 4단을 출력하시오.
				DECLARE
					V_CNT NUMBER := 0;
				BEGIN
					WHILE V_CNT < 9 LOOP
						V_CNT := V_CNT + 1;
						DBMS_OUTPUT.PUT_LINE('4 * ' || V_CNT || ' = ' || 4 * V_CNT);
					END LOOP;
				END;

			사용 예)
				LOOP로 구성한 CURSOR문을 WHILE로 재구성하시오.
					DECLARE
						V_ID PROD.PROD_ID % TYPE;
						V_NAME PROD.PROD_NAME % TYPE;
						V_AQTY NUMBER := 0;
						V_AMON NUMBER := 0;
						CURSOR CUR_BUYPROD02
						IS
							SELECT BUY_PROD,
									PROD_NAME,
									SUM(BUY_QTY),
									SUM(BUY_QTY * PROD_COST)
								FROM BUYPROD, PROD
								WHERE PROD_ID = BUY_PROD
									AND TO_CHAR(BUY_DATE, 'YYYYMM') = '200503'
								GROUP BY BUY_PROD,
									PROD_NAME;
					BEGIN
						DBMS_OUTPUT.PUT_LINE('--------------------');

						OPEN CUR_BUYPROD02;
						FETCH CUR_BUYPROD02
							INTO V_ID,
								V_NAME,
								V_AQTY,
								V_AMON;

						WHILE CUR_BUYPROD02 % FOUND LOOP
							DBMS_OUTPUT.PUT_LINE('순번		' || CUR_BUYPROD02 % ROWCOUNT);
							DBMS_OUTPUT.PUT_LINE('제품번호	' || V_ID);
							DBMS_OUTPUT.PUT_LINE('제품명	' || V_NAME);
							DBMS_OUTPUT.PUT_LINE('매입수량	' || V_AQTY);
							DBMS_OUTPUT.PUT_LINE('매입금액	' || V_AMON);
							DBMS_OUTPUT.PUT_LINE('--------------------');
							
							FETCH CUR_BUYPROD02
								INTO V_ID,
									V_NAME,
									V_AQTY,
									V_AMON;
						END LOOP;
						CLOSE CUR_BUYPROD02;
					END;

			숙제]
				첫날에 100원, 두 번째 날 부터는 전날의 2배씩 저축을 하려 한다.
				최초로 100만원을 넘는 날은 몇일재이고, 그 날까지 저축한 액수를 구하시오.
				LOOP와 WHILE문으로 구성할 것
					DECLARE
						V_DAY NUMBER := 0;
						V_MONEY NUMBER := 0;
					BEGIN
						LOOP
							V_DAY := V_DAY + 1;
							V_MONEY := V_MONEY + POWER(2, V_DAY - 1) * 100;
							DBMS_OUTPUT.PUT_LINE(V_DAY || '일차');
							DBMS_OUTPUT.PUT_LINE(POWER(2, V_DAY - 1) * 100 || '원 저축.');
							DBMS_OUTPUT.PUT_LINE('오늘까지 ' || V_MONEY || '원.');
							DBMS_OUTPUT.PUT_LINE('--------------------');
							EXIT WHEN V_MONEY > 1000000;
						END LOOP;

						DBMS_OUTPUT.PUT_LINE('최초로 100만원을 넘은 날은 ' || V_DAY || '일 째 되는 날이고, ' || V_MONEY || '원을 모았습니다.');
					END;

					DECLARE
						V_DAY NUMBER := 0;
						V_MONEY NUMBER := 0;
					BEGIN
						WHILE V_MONEY <= 1000000 LOOP
							V_DAY := V_DAY + 1;
							V_MONEY := V_MONEY + POWER(2, V_DAY - 1) * 100;
							DBMS_OUTPUT.PUT_LINE(V_DAY || '일차');
							DBMS_OUTPUT.PUT_LINE(POWER(2, V_DAY - 1) * 100 || '원 저축.');
							DBMS_OUTPUT.PUT_LINE('오늘까지 ' || V_MONEY || '원.');
							DBMS_OUTPUT.PUT_LINE('--------------------');
						END LOOP;

						DBMS_OUTPUT.PUT_LINE('최초로 100만원을 넘은 날은 ' || V_DAY || '일 째 되는 날이고, ' || V_MONEY || '원을 모았습니다.');
					END;