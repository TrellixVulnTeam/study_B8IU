package b_operation;

public class Operation_02 {
	public static void main(String[] args) {
		/*
		1. 증감 연산자 ( ++, -- )
			- 증가 연산자 ( ++ ) : 피 연산자의 값을 1 증가시킨다.
			- 감소 연산자 ( -- ) : 피 연산자의 값을 1 감소시킨다.
		*/
		int i = 3;
		i++;
		System.out.println(i);
		++i;
		System.out.println(i);
		
//		1. 변수 c에 'A'를 저장해주세요.
		char c = 'A';
		c++;
		System.out.println(c);
		
		int i1 = 5;
		int i2 = 10;
		
		int i3 = i1++ + i2;
		System.out.println("i1 : " + i1);
		System.out.println("i3 : " + i3);
		
//		1. int형 변수 number를 선언하고 30의 값으로 초기화하여라.
		int number = 30;
		
//		2. char형 변수 ch를 선언하고 'C'의 값으로 초기화 하여라.
		char ch = 'C';
		
//		3. 다음의 출력결과를 작성하여라.
		int result = number++ +3 + ++ch + ++number;
		System.out.println("number : " + number);
//			결과 : 32
		System.out.println("ch : " + ch);
//			결과 : D
		System.out.println("result : " + result);
//			결과 : 133
		
		/*
		2. 부호연산자 ( +, - )
			- boolean형과 char형에는 사용할 수 없다.
	 	*/
		
		
		/*
		3. 비트 전환 연산자 ( ~ )
			- boolean형과 실수형에는 사용할 수 없다.
			- 컴퓨터가 알아듣는 음수.
			- 피 연산자를 2진수로 표현하였을 때, 0은 1로, 1은 0으로 바꾼다.
				10 :		0 0 0 0 1 0 1 0
				~ 10 :		1 1 1 1 0 1 0 1 ( -11, 10의 1의 보수 )
				~ 10 + 1 :	1 1 1 1 0 1 1 0 ( -10, 10의 2의 보수 )
		*/
		
		int i4 = 10;
		System.out.println(~i4 + 1);
		
		/*
		4. 논리 부정 연산자 ( ! )
			- boolean형에만 사용 가능하다.
			- true -> false, false -> true
		*/

//		1. 변수 power를 false의 값으로 초기화하여라.
		boolean power = false;
		
//		2. power의 값을 부정하여 power에 저장하여라.
		power = !power;
		
		System.out.println(!!!power);
	}
}
