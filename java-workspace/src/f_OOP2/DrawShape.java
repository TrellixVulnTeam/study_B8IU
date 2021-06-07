package f_OOP2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class DrawShape extends Frame {
	public static void main(String[] args) {
		DrawShape ds = new DrawShape();
//		ds.paint 메서드를 자동 호출
		System.out.println(ds.toString());
	}
	
	DrawShape() {
		super("밥신청하세요");
		setSize(500, 500);
		setBackground(Color.MAGENTA);
		setVisible(true);
		setResizable(false);
	}
	
	@Override
	public void paint(Graphics g) {
//		1. 매개변수가 두 개인 생성자를 이용하여 원을 만들어주세요. c
//			(50, 50), 25
		Point p0 = new Point(100, 100);
		Circle c = new Circle(100, p0);
		
//		2. g.drawOval()를 이용하여 원을 그려주세요.
		g.drawOval(c.p.x, c.p.y, c.r * 2, c.r * 2);
		
//		3. 매개변수가 하나인 생성자를 이용하여 삼각형을 만들어주세요. p
//		 (100, 100), (200, 200), (100, 200)
		Point p1 = new Point(100, 100);
		Point p2 = new Point(200, 200);
		Point p3 = new Point(100, 200);
		Point[] points = new Point[]{p1, p2, p3}; 
		Triangle p = new Triangle(points);
		
//		4. g.drawLine() 3개를 이용하여 삼각형을 그려주세요.
		g.drawLine(p.p[0].x, p.p[0].y, p.p[1].x, p.p[1].y);
		g.drawLine(p.p[1].x, p.p[1].y, p.p[2].x, p.p[2].y);
		g.drawLine(p.p[2].x, p.p[2].y, p.p[0].x, p.p[0].y);
	}
}

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	} 
}

class Circle {
//	1. 반지름(정수)를 저장할 수 있는 변수  r을 선언해주세요.
	int r;
	
//	2. 중심점을 저장할 수 있는 변수 p를 선언해주세요.
	Point p;
	
//	3. 매개변수가 두 개인 생성자를 만들어주세요.
	Circle(int r, Point p) {
		this.r = r;
		this.p = p;
	}
	
//	4. 기본생성자를 만들어주세요.
//		단, 매개변수가 두 개인 생성자를 이용하여 (100, 100), 반지름 50으로 초기화해주세요.
	Circle(){
		this(50, new Point(100, 100));
	}
}

class Triangle {
//	1. 점 3개를 저장할 수 있는 변수 p를 선언해주세요.
	Point[] p;
	
//	2. 매개변수가 한 개인 생성자를 만들어주세요.
	Triangle(Point[] p){
		this.p = p;
	}
	
//	3. 매개변수가 세 개인 생성자를 만들어주세요.
	Triangle(Point p1, Point p2, Point p3){
		p = new Point[] {p1, p2, p3};
	}
}
