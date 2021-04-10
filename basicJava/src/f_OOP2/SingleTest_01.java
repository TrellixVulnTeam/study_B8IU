package f_OOP2;

public class SingleTest_01 {
	public static void main(String[] args) {
		Singleton st1 = Singleton.getInstance();
		Singleton st2 = Singleton.getInstance();
		System.out.println(st1);
		System.out.println(st2);
	}
}

class Singleton {
	static Singleton st;
	
	private Singleton() {
		 
	}
	
	/**
	 * Singleton의 객체를 반환하기 위한 메서드
	 * @return Singleton의 객체
	 * @since 2021. 01. 14.
	 * @author PC16
	 */
	static Singleton getInstance() {
		if(st == null) {
			st = new Singleton();
		}
		return st;
	}
}