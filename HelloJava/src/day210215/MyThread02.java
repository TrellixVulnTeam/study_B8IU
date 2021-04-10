package day210215;

public class MyThread02 {
	public static void showText() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100000; i++) {
					if (i % 100 == 0)
						System.out.println();
					System.out.print((char) (i) + " ");
				}
			}
		}).start();
	}

	public static void showNumber() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100000; i++) {
					if (i % 100 == 0)
						System.out.println();
					System.out.print(i + " ");
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		showNumber();
		showText();
	}
}
