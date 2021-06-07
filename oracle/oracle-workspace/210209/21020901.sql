--2021-02-09-01)DDL(Data Definition Language)-테이블 생성

예)
	1)
		tb_mem 테이블 생성
			CREATE TABLE tb_mem (
				mem_id CHAR(5),
				mem_name VARCHAR2(30) NOT NULL,
				mem_addr VARCHAR2(100),
				mem_tel_no VARCHAR2(20),

				CONSTRAINT pk_tb_mem PRIMARY KEY(mem_id)
			);

	2)
		상품테이블(tb_goods) 생성
				CREATE TABLE tb_goods (
					good_id CHAR(6), -- PRIMARY KEY ( NOT NULL이 불필요 )
					good_name VARCHAR(50) NOT NULL,
					good_price NUMBER(7) DEFAULT 0,

					CONSTRAINT pk_tb_goods PRIMARY KEY(good_id)
				);

	3)
		주문테이블(orders) 생성
			CREATE TABLE orders (
				order_id NUMBER(5), -- PRIMARY KEY
				order_date DATE DEFAULT SYSDATE,
				order_amt NUMBER(8),
				order_flag CHAR(1),
				mem_id char(5), -- FOREIGN KEY

				CONSTRAINT pk_orders PRIMARY KEY(order_id),
				CONSTRAINT fk_orders_tb_mem FOREIGN KEY(mem_id) REFERENCES tb_mem(mem_id)
			);

	4)
		주문상품 테이블 (orders_goods) 생성
			CREATE TABLE orders_goods (
				order_id NUMBER(5), -- PRIMARY KEY & FOREIGN KEY
				good_id CHAR(6), -- PRIMARY KEY & FOREIGN KEY
				qty NUMBER(3) DEFAULT 0,

				CONSTRAINT pk_orders_goods PRIMARY KEY (order_id, good_id),
				CONSTRAINT fk_orders_goods_orders FOREIGN KEY (order_id) REFERENCES orders(order_id),
				CONSTRAINT fk_orders_goods_tb_goods FOREIGN KEY (good_id) REFERENCES tb_goods(good_id)
			);