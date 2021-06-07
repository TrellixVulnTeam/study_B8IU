package a_variable;
/**
 * 변수공부를 위한 첫 번째 class
 * @author PC16
 * @since 2020. 12. 17.
 */
public class Variable_01 {
	public static void main(String[] args) { //메서드, method
//		한 줄 주석
		
//		한
//		줄
//		주
//		석
		int a; // 여기는 주석
		/*
		 * 여
		 * 러
		 * 줄
		 * 주
		 * 석
		 */
		/*
		여
		러
		줄
		주
		석
		*/
		
		/*
		 * 변수란?
		 * 단 하나의 값을 저장할 수 있는 공간이다.
		 * 
		 */
		/*
		1. 변수의 선언
			- 변수타입, 변수명;
				이	영훈;
				int	a;
		    
    	2. 변수의 초기화
    		- 변수명 = 값;
		
		3. 변수의 선언 및 초기화
			- 변수타입 변수명 = 값;
		*/
		int name;
		
		name = 20;
		
		System.out.println(name);
				
		name = 50;
		
		System.out.println(name);
		
		int name1 = 100;
		
//		boolean name;  => 이러면 프로그램이 멈춰요~
		
		/*
		4. 명명규칙
			- 대소문자를 구분하며 길이의 제한이 없다.
			- 예약어(key word, reserved word)는 사용할 수 없다.
			- 숫자로 시작하면 안된다.
			- 특수문자는 '_', '$' 사용가능하다.
		
		5. 필수는 아니지만 프로그래머로서의 암묵적인 약속들(가독성)
			- class의 명칭은 대문자로 시작해야 한다.
			- 여러 단어로 이루어진 경우 첫 번째 이후 단어의 첫 글자를 대문자로 써야 한다.
				lastIndexOf
			- 상수의 이름은 모두 대문자로 작성한다.
				MAX_VALUE
		  	- 한글은 사용하지 않는다.
		
		*/
		int naMe;
		
		final int k = 50;
	}
}
