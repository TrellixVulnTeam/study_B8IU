package h_javaLang;

import static java.lang.Math.*;

public class MathTest_01 {
	public static void main(String[] args) {
		double d = 3.1415926535;

		//반올림
		System.out.println(round(d * 100) / 100f);

		//올림
		System.out.println(ceil(d));

		//버림
		System.out.println(floor(d));

		//제곱
		System.out.println(pow(3, 2));

		//루트
		System.out.println(sqrt(4));
		System.out.println(pow(4, 0.5));

		//Point2 클래스의 getDistance 메서드를 호출하여 두 점 사이의 거리를 구해주세요.
		Point2 p1 = new Point2(100, 100);
		Point2 p2 = new Point2(200, 200);
		double result = p1.getDistance(p2);
		System.out.println(result);
	}
}

class Point2 {
	int x;
	int y;

	Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point2 [x=" + x + ", y=" + y + "]";
	}

	double getDistance(Point2 point) {
		return round(sqrt(pow((x - point.x), 2) + pow((y - point.y), 2)) * 1000) / 1000.0;
	}
}
