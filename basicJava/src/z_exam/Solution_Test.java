package z_exam;

public class Solution_Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		int result1 = s.plus(10, 20);
		System.out.println(result1);
	}
}

class Solution {
	int plus(int number1, int number2) {
		int result = number1 + number2;
		
		return result; 
	}
	
}