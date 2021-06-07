package h_javaLang;

import java.io.Serializable;
import java.util.Arrays;

public class CloneTest_02 {
	public static void main(String[] args) {
		// 점 3개를 저장해주세요.
		// (100, 100), (200, 200), (100, 200)
		Point p1 = new Point(100, 100);
		Point p2 = new Point(200, 200);
		Point p3 = new Point(100, 100);
		
		Point[] p = new Point[] { p1, p2, p3 };
		Point[] clone = p.clone();
		
		System.out.println(Arrays.toString(p));
		System.out.println(Arrays.toString(clone));
		
		System.out.println();
		System.out.println("=========");
		System.out.println();
		
		p[0].x = 700;
		System.out.println(Arrays.toString(p));
		System.out.println(Arrays.toString(clone));
	}
}

class Point implements Serializable {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}