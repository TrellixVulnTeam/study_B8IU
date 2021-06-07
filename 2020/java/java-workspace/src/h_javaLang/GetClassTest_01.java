package h_javaLang;

import java.util.Arrays;

public class GetClassTest_01 {
	public static void main(String[] args) throws ClassNotFoundException {
		// 1. 클래스 객체로부터 얻는 방법
		Class ca1 = new Point(100, 100).getClass();
		System.out.println(ca1.getName());
		System.out.println(Arrays.toString(ca1.getInterfaces()));
		
		// 2. 클래스 리터럴로부터 얻는 방법
		Class ca2 = Point.class;
		System.out.println(ca2.getName());
		System.out.println(Arrays.toString(ca2.getInterfaces()));
		
		// 3. 클래스의 이름으로부터 얻는 방법
		Class ca3 = Class.forName("h_javaLang.Point");
		System.out.println(ca3.getName());
		System.out.println(Arrays.toString(ca3.getInterfaces()));
	}
}
