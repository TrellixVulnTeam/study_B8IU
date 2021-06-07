package day210210;

import java.util.Calendar;

public class EllapsedTest {
	public static void main(String[] args) {
		long now1 = Calendar.getInstance().getTimeInMillis();
		long now2 = Calendar.getInstance().getTimeInMillis();
		long ellapse = now2 - now1;
		System.out.println("now1 : " + now1);
		System.out.println("now2 : " + now2);
		System.out.println("ellapse : " + ellapse);
	}
}
