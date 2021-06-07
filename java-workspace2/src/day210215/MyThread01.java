package day210215;

public class MyThread01 {
	public static void showText() {
		for (int i = 0; i < 100000; i++) {
			if (i % 100 == 0) System.out.println();
			System.out.print((char)(i) + " ");
		}
	}
	
	public static void showNumber() {
		for (int i = 0; i < 100000; i++) {
			if (i % 100 == 0) System.out.println();
			System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		showNumber();
		showText();
	}
}
