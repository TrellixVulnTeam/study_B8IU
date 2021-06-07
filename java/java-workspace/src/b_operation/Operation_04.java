package b_operation;

import java.util.Scanner;

public class Operation_04 {
	public static void main(String[] args) {
		/*
		1. 삼항 연산자
			- 세 개의 피 연산자를 필요로 하기 때문에 삼항 연산자라고 한다.
			- 삼항 연산자의 조건시에는 연산 결과가 true 또는 false인 식이 사용되어야 한다.
			- 기본구조
				( 조건식 ) ? ( 식1 ) : ( 식2 )
				( if ) ? ( true ) : ( false )
		*/
		
		int x = -10;
		
		int absx = x > 0 ? x : -x;
		System.out.println(absx);
		
//		1. 변수 k를 선언하고 50의 값으로 초기화하여라.
		int k = 0;
		
//		2. 변수 k의 값이 0보다 크면 "양수", 0보다 작으면 "음수", 0이면 "0"을 re에 저장해주세요.
		String re = k > 0 ? "양수" : k < 0 ? "음수" : "0";
		System.out.println(re);
		
		/*
		2. 대입 연산자 ( =, op= )
			- 변수에 값 또는 수식의 연산 결과를 저장하는 데 사용한다.
			- 연산 우선 순위가 가장 낮다.
		*/
		
		int i = 0;
		
		i = i + 3;
//		i += 3;
		
		char c = 'A';
//		c = c + 3;
//		c = (char)(c + 3);
		c += 3;
		System.out.println(c);
		
		
//		1. 반올림
		
//			1. d*1000	=> 3141.592
//			2. +0.2		=> 3142.092
//			3. (int)	=> 3142
//			4. /1000.0f	=> 3.142
		final float PI = 3.141592F;
		System.out.println((int)(PI*1000+0.5)/1000.0F);
//			소수 넷째 자리에서 셋째 자리로 반올림
//			0.5를 더하여 int로 형변환하면 소수점이 사라지며 반올림되므로
//			원하는 자리까지를 정수부분으로 만들면 된다.
//			따라서 1000을 곱하여 소수 셋째 자리까지를 정수부로 만들어주고,
//			이후 0.5를 더하여 int로 형변환한 뒤
//			다시 float형의 1000.0으로 나누어
//			처음 요구한 값을 찾아낸다.
		
		
//		2. Math.random()
//			주사위
//			1 ~ 6
		int dice = (int)(Math.random()*6+1);
		System.out.println(dice);
		
//		1 ~ 25 사이의 임의의 정수값
		int num = (int)(Math.random()*25+1);
		System.out.println(num);
		
//		2-1. 변수 x를 선언하고 0이상 100미만 사이의 임의의 정수 값으로 초기화 하여라.
		int x1 = (int)(Math.random()*100);
		
//		2-2. x에 저장된 값을 출력 하여라.
		System.out.println(x1);
		
//		2-3. 변수 x2를 선언하고 43초과 375미만 사이의 임의의 정수 값으로 초기화 하여라.
		int x2 = (int)(Math.random() * 331 + 44);
		
//		2-4. x2에 저장된 값을 출력 하여라.
		System.out.println(x2);
		
		
//		3. 사용자로부터 입력받기
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("첫 번째 문자 입력해");
//		String input1 = sc.next();
//		System.out.println("두 번째 문자 입력해");
//		String input2 = sc.next();
		
//		System.out.println(input1 + input2);
		
		System.out.println("첫 번째 숫자 입력해주세요 : ");
		int num1 = sc.nextInt();
		System.out.println("두 번째 숫자 입력해주세요 : ");
		int num2 = sc.nextInt();
		
		System.out.println("두 수의 합계는 " + (num1 + num2));
		
		
		
	}
}
