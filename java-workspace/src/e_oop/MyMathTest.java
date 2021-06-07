package e_oop;  

public class MyMathTest {	
	public static void main(String[] args) {
//		8. MethodTest클래스의 add01메서드를 호출 하여라.
		MethodTest.add01();
		
//		9. MethodTest클래스의 add02메서드를 호출 하여라.
		int result02 = MethodTest.add02(30);
		System.out.println(result02);
		
//		10. MethodTest클래스의 add03메서드를 호출 하여라.
		MethodTest mt = new MethodTest();
		int result03 = mt.add03(60);
		System.out.println(result03);
		
//		11. MethodTest클래스의 add04메서드를 호출 하여라.
		mt.add04();
	}
}

class MethodTest {
   //	1. 클래스변수 a를 선언하고 10의 값으로 초기화 하여라.
	static int a = 10;
	
//	2. 클래스변수 b를 선언하고 20의 값으로 초기화 하여라.
	static int b = 20;
	
//	3. 인스턴스변수 c를 선언하고 50의 값으로 초기화 하여라.
	int c = 50;
	
//	4. 클래스변수 a와 b의 합을 출력하는 클래스메서드 add01를 구현 하여라.
	static void add01(){
		int result = a + b;
		System.out.println(result);
	}
	
//	5. 클래스변수 a, b, int 타입의 매개변수 c의 합을 반환하는 클래스메서드 add02를 구현 하여라.
	static int add02(int c){
		int result = a + b + c; 
		return result;
	}
	
//	6. 인스턴스변수 c와 int 타입의 매개변수 c의 합을 반환하는 인스턴스메서드 add03를 구현 하여라.
	int add03(int c){
		int result = this.c + c;
		return result;
	}
	
//	7. 인스턴스변수 c와 0~100사이의 임의의 정수의 합을 출력하는 인스턴스메서드 add04를 구현 하여라.
	void add04(){
		int random = (int)(Math.random()*101);
		int result = c + random;
		System.out.println(result);
	}
}