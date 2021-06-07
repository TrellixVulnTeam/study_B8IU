2021-03-09-02)
SEQUENCE 객체
	- 순차적으로 증가하는 정수를 발생
	- 다른 DBMS ( MYSQL, SQL_SERVER 등 ) 에서는 AUTO INCREMENT로 제공
	- 테이블에 독립적으로 사용
	- 기본키로 설정하기에 적합한 컬럼이 없는 경우
		순차적 순번이 필요한 경우 ( 게시판의 글번호 등 ) 에 주로 사용

	사용 형식
		CREATE SEQUENCE 시퀀스명
			[START WITH n]
			[INCREMENT BY n]
			[MAXVALUE n | NOMAXVALUE]
			[MINVALUE n | NOMINVALUE]
			[CYCLE | NOCYCLE]
			[CACHE | NOCACHE]
			[ORDER | NOORDER]

	. START WITH n
		시작값
	. INCREMENT BY n
		증감량
	. MAXVALUE n
		최대값 ( default는 10^27 ), 'NOMAXVALUE'가 기본
	. MINVALUE n
		최소값 ( default는 1 ), 'NOMINVALUE'가 기본
	. CYCLE
		최대 또는 최소값 도달 후 다시 시작 ( DEFAULT는 'NOCYCLE' )
	. CACHE
		메모리에 미리 생성하여 할당할 지 여부 ( DEFAULT는 CACHE 20 )
	. ORDER
		요청한 순서대로 생성을 보증 ( DEFAULT는 NOORDER )

	* 시퀀스의 사용
	--------------------------------------------------
	의사 컬럼 ( Pseudo Column )	의미
	--------------------------------------------------
	시퀀스명.NEXTVAL				시퀀스 객체의 다음 값 반환
	시퀀스명.CURRVAL				시퀀스 객체의 현재 값 반환
	--------------------------------------------------
	
	** 시퀀스가 생성된 후 첫 번째 명령은 해당 세션에서 시퀀스명.NEXTVAL가 최초로 수행된 후에만 참조될 수 있음

	사용 예)
		상품분류테이블(LPROD)에 다음 자료를 추가하시오
		단, 순번(LPROD_ID)은 SEQUENCE를 생성하여 사용하시오
			--------------------
			분류코드		분류명
			--------------------
			'p501'		'임산물'
			'p502'		'수산물'
			'p503'		'농산물'
			--------------------
        
	SELECT MAX(LPROD_ID) FROM LPROD;
	
	시퀀스 생성
	CREATE SEQUENCE SEQ_LPROD
		START WITH 10;

	INSERT INTO LPROD
		VALUES(SEQ_LPROD.NEXTVAL, 'P501', '임산물');
	
	INSERT INTO LPROD
		VALUES(SEQ_LPROD.NEXTVAL, 'P502', '임산물');

	INSERT INTO LPROD
		VALUES(SEQ_LPROD.NEXTVAL, 'p503', '농산물');

	SELECT *
		FROM LPROD;

	SELECT SEQ_LPROD.CURRVAL
		FROM DUAL;