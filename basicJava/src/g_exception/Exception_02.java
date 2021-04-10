package g_exception;

public class Exception_02 {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		for (int i = 0; i < 10; i++) { 
			try {
				result = number / (int) (Math.random() * 5);
				System.out.println(result);
			} catch(ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다");
			}
		}
	}
}
