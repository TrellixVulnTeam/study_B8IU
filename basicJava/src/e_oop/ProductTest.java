package e_oop;

public class ProductTest {
	public static void main(String[] args) {
		Init it = new Init(50);
//		명시적 초기화 → 인스턴스 초기화 블럭 → 생성자를 이용한 초기화
		
		System.out.println(it.action2);
		
		System.out.println(Init.action);		
	}
}

class Init{
	static int action;
	
//	명시적 초기화
	int action2 = 11;
	
	static {
		action = 60;
	}
	
	{
		action2 = 90;
	}
	
	Init(int action2){
		this.action2 = action2;
	}
}