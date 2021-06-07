package e_oop;

public class PrintCallTest {
	public static void main(String[] args) {
//		9. 3번의 add메서드를 호출하여라.
		int result09 = MyAdd.add(3);
		System.out.println(result09);
		
//		10. 4번의 add메서드를 호출하여라.
		MyAdd myAdd = new MyAdd();
		int result10 = myAdd.add(4,  10);
		System.out.println(result10);
		
//		11. 5번의 add메서드를 호출하여라.
		long result11 = myAdd.add(5, 11L);
		System.out.println(result11);
		
//		12. 6번의 add메서드를 호출하여라.
		float result12 = myAdd.add('F', 12.6F);
		System.out.println(result12);
		
//		13. 8번의 add를 호출하여라.
		float result13 = MyAdd.add(8, 13L, 13.8F);
		System.out.println(result13);
	}
}


class MyAdd{
//	1. 클래스변수 a를 선언하고 20의 값으로 초기화 하여라.
	static int a = 20;
	
//	2. 인스턴스변수 b를 선언하고 15의 값으로 초기화 하여라.
	int b = 15;
	
//	3. int타입의 매개변수가 하나이며 변수 a와 합을 반환하는 클래스메서드를 add를 작성
//		하여라.
	static int add(int b){
		int result = a + b;
//		int + int → int;
		return result;
	}
	
//	4. int타입의 매개변수가 두개이고 매개변수의 합을 반환하는 인스턴스메서드를 add를
//		작성 하여라.
	int add(int a, int b){
		int result = a + b;
//		int + int → int;
		return result;
	}
	
//	5. int타입, long타입 각 한 개의 매개변수, 매개변수의 합을 반환하는 인스턴스
//		메서드 add를 작성 하여라.
	long add(int a, long b){
		long result = a + b;
//		int + long → long
		return result;
	}
	
//	6 char타입, float타입 각 한 개의 매개변수, 매개변수의 합을 반환하는 인스턴스
//		메서드 add를 작성 하여라.
	float add(char a, float b){
		float result = a + b;
//		char + float → float;
		return result;
	}
	
//	7. int 타입의 매개변수가 두 개이고, 매개변수의 합을 반환하는 반환 타입이 long인
//		인스턴스 메서드 add를 작성하여라.
	/*
//		문제에서 반환 타입을 지정하고 있어 long으로 반환
	long add(int a, int b){
		result = a + b;
//		int + int → int
 		return result;
	}
	*/
//	7-1. 안되는 이유를 서술하여라.
//		Method Overload는 Method명이 동일하고,
//		매개변수의 갯수 또는 타입이 다른 경우에만 가능하다.
	
//	8. int, long, float 타입 각 한 개의 매개변수, 매개변수의 합을 반환하는
//		클래스 메서드 add를 작성하여라.
	static float add(int a, long b, float c) {
		float result = a + b + c;
//		int + long → long;
//		long + float → float;
		return result;
	}
}