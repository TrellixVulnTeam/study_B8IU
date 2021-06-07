package e_oop;

public class FactorialTest {
	public static void main(String[] args) {
		long result = FactorialTest.factorial(49);
		System.out.println(result);
	}
	static long factorial(int number){
		long result = 0;
		if(number == 1){
			result = 1;
		} else {
			result = number * factorial(number - 1);
		}
		return result;
	}
}
