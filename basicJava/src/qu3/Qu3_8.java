package qu3;

public class Qu3_8 {
	public static void main(String[] args) {
		//7. 3번의 add메서드를 호출하여라.
		int result1 = MyAdd.add(10);
		System.out.println(result1);
		
		//8. 4번의 add메서드를 호출하여라.
		MyAdd myAdd = new MyAdd();
		int result2 = myAdd.add(10, 20);
		System.out.println(result2);
		
		//9. 5번의 add메서드를 호출하여라.
		long result3 = myAdd.add(1, 2L);
		System.out.println(result3);
		
		//10. 6번의 add메서드를 호출하여라.
		float result4 = myAdd.add('A', 1F);
		System.out.println(result4);
	}
}

class MyAdd {
	//1. 클래스변수 a를 선언하고 20의 값으로 초기화 하여라.
	static int a = 20;
	
	//2. 인스턴스변수 b를 선언하고 15의 값으로 초기화 하여라.
	int b = 15;
	
	//3. int타입의 매개변수가 하나이며 변수 a와 합을 반환하는 클래스메서드를 add를 작성
	// 하여라.
	static int add(int num1) {
		int result = a + num1;
		return result;
	}
	
	//4. int타입의 매개변수가 두개이고 매개변수의 합을 반환하는 인스턴스메서드를 add를
	// 작성 하여라.
	int add(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	
	//5. int타입, long타입 각 한 개의 매개변수, 매개변수의 합을 반환하는 인스턴스
	// 메서드 add를 작성 하여라.
	long add(int num1, long num2) {
		long result = num1 + num2;
		return result;
	}
	
	//6 char타입, float타입 각 한 개의 매개변수, 매개변수의 합을 반환하는 인스턴스
	// 메서드 add를 작성 하여라.
	float add(char char1, float float1) {
		float result = char1 + float1;
		return result;
	}
}