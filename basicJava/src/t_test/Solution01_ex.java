package t_test;


public class Solution01_ex {
	public static void main(String[] args) {
		Solution01 sl = new Solution01();
		int result = sl.solution(10);
		System.out.println(result);
	}
}

class Solution01 {
	public int solution(int i) {
		int result = 0;
		for (int j = 2; j <= i; j++) {
			for (int j2 = 2; j2 <= j; j2++) {
				if (j2 != j && j % j2 == 0) {
					break;
				}
				if (j2 * j2 > j) {
					result++;
					break;
				}
			}
		}
		return result;
	}
}