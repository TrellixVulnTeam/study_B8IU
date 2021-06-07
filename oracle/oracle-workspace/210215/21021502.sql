2021-02-15-02)
4. 기타 자료형
	- 2진 자료를 저장하기 위한 자료형
	- RAW, LONG RAW, BLOB, BFILE
	1) RAW
		. 상대적으로 작은 2진 자료 저장
		. 인덱스 처리 가능
		. 최대 2000 BYTE 처리 가능
		. 오라클에서 해석이나 변환작업이 수행되지 않음
		. 16진수와 2진수로 저장

		사용 형식
			컬럼명 RAW(크기);

	2) BFILE
		. 2진 자료 저장
		. 대상이 되는 2진 자료는 데이터베이스 외부에 저장
		. 경로 정보 ( DIRECTORY 객체 ) 와 파일명만 테이블에 저장
		. 4GB까지 저장 가능

		사용 형식
			컬럼명 BFILE;

		** 그림 파일 저장 순서
			(1)
				그림 파일이 저장된 경로와 파일 확인
			(2)
				디렉토리 객체 생성
					CREATE OR REPLACE DIRECTORY 디렉토리명 AS 절대주소
			(3)
				테이블 생성
			(4)
				그림파일 삽입

		사용 예)
			(1)
				그림 파일이 저장된 경로와 파일 확인
				그림 경로
					'D:\A_TeachingMaterial\2.Oracle\workspace\210215'
				파일 명
					'SAMPLE01.png'
			(2)
				디렉토리 객체 생성
					CREATE OR REPLACE DIRECTORY TEST_DIR AS 'D:\A_TeachingMaterial\2.Oracle\workspace\210215';
			(3)
				테이블 생성
					CREATE TABLE TEMP07 (
						COL1 BFILE
					);
			(4)
				그림 삽입
					INSERT INTO TEMP07
						VALUES (BFILENAME('TEST_DIR', 'SAMPLE01.png'));

					SELECT *
						FROM TEMP07;

	3) BLOB
		. 2진 자료를 데이터베이스 내부에 저장
		. 4GB까지 저장 가능
		. 해석 및 변환되지 않음

		사용 형식
			컬럼명 BLOB;

		** 그림 파일 저장 순서
			(1)
				그림 파일이 저장된 경로와 파일 확인
			(2)
				디렉토리 객체 생성
					CREATE OR REPLACE DIRECTORY 디렉토리명 AS 절대주소
			(3)
				테이블 생성
					CREATE TABLE TEMP08 (
						COL1 BLOB
					);

			(4)
				그림파일 삽입 - PROCEDURE 이용
					CREATE OR REPLACE PROCEDURE PROC_IMG_INSERT (P_DIR IN VARCHAR2, P_FILENAME VARCHAR2)
					IS
						V_DEPT BLOB;
						V_SOURCE BFILE;
						V_LENGTH NUMBER:=0;
					BEGIN
						V_SOURCE:=BFILENAME(P_DIR, P_FILENAME);                
						DBMS_LOB.FILEOPEN(V_SOURCE, DBMS_LOB.FILE_READONLY);
						V_LENGTH:= DBMS_LOB.GETLENGTH(V_SOURCE);
						DBMS_LOB.LOADFROMFILE(V_DEPT, V_SOURCE, V_LENGTH);
						DBMS_LOB.FILECLOSE(V_SOURCE);
						INSERT INTO TEMP08 VALUES (V_DEPT);
						COMMIT;
					END;

			*** 그림 파일 저장 BLOCK 생성
				DECLARE
				BEGIN
					PROC_IMG_INSERT('TEST_DIR', 'SAMPLE01.png');
					PROC_IMG_INSERT('TEST_DIR', 'SAMPLE02.png');
					PROC_IMG_INSERT('TEST_DIR', 'SAMPLE03.png');
				END;

				SELECT *
					FROM TEMP08;