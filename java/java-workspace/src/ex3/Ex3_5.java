package ex3;

public class Ex3_5 {
	public static void main(String[] args) {
		//클래스 메서드 classMethod()를 호출하며 인자로 5를 전달
		Ex.classMethod(5);
		
		//Ex인스턴스를 참조하기 위한 변수 e를 선언하고 Ex인스턴스를 생성 후 저장
		Ex e = new Ex();
		
		//반환값을 저장할 int형 변수 re를 선언하고 인자로 5, 8을 Ex인스턴스의 instanceMethod() 메서드에 전달하고 반환값을 저장
		int re = e.instanceMethod(5, 8);
		
		System.out.println(re); // 5와 7의 곱인 35를 출력
	}
}

class Ex {
	static void classMethod(int a) {
		System.out.println("입력된 값은 " + a + "이다.");
	}

	int instanceMethod(int a, int b) {
		//int형 변수 result를 생성하여 a와 b를 곱한 값을 저장
		int result = a * b;
		
		//result를 반환
		return result;
	}
}