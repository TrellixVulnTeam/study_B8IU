package g_exception;

public class Exception_03 {
	public static void main(String[] args) {
		int a = 3;
		int b = 0;

		System.out.println(a);
		try {
			System.out.println(a / b);
			System.out.println(b);
		} catch (ArithmeticException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {

		}
		System.out.println("완료");
	}
}
