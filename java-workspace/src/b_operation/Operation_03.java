package b_operation;

public class Operation_03 {

	public static void main(String[] args) {
		/*
		1. 산술 연산자
			- 사칙 연산자 ( +, -, *, / ), 나머지 연산자 ( % ), 쉬프트 연산자 ( <<, >>, >>>)
				피 연산자 두 개를 필요로 하기 때문에, 이항 연산자로 불린다.
		*/
		
		/*
		2. 사칙연산자 ( +, -, *, / )
			- 두 개의 피 연산자 중 자료형의 표현 범위가 큰 쪽에 맞춰서 형변환 후 연산을 수행한다.
				: int + float => float + float => float
			- 두 개의 피 연산자 모두 4 byte보다 크기가 작을 때는 4 byte인 int형으로 형변환 후 연산을 수행한다.
				: byte + char => int + int => int
			- 0으로 나누는 것은 금지되어 있다.
		*/
		
//		1. byte형 변수 b1을 선언하고 80의 값으로 초기화 하여라.
		byte b1 = 80;
		
//		2. byte형 변수 b2를 선언하고 100의 값으로 초기화 하여라.
		byte b2 = 100;
		
//		3. long형 변수 lo1을 선언하고 642의 값으로 초기화 하여라.
		long lo1 = 642;
		
//		4. lo1과 b1의 합을 변수 result1에 저장 하여라.
		long result1 = lo1 + b1;
		
//		5. result1의 값을 출력 하여라. ( 결과 첫 번째 줄 )
		System.out.println(result1);
		
//		6. b1과 b2의 합을 변수 result2에 저장 하여라.
		int result2 = b1 + b2;
		
//		7. result2의 값을 출력 하여라. ( 결과 두 번째 줄 )
		System.out.println(result2);
		
//		8. byte형 변수 result3을 선언하고 b1과 b2의 합으로 초기화 하여라.
		byte result3 = (byte)(b1+b2);
		
//		9. result3의 값을 출력 하여라. ( 결과 세 번째 줄 )
		System.out.println(result3);
		
//		10. 변수 lo2를 선언하고 60000과 80000의 곱을 저장 하여라.
		long lo2 = (long)60000*80000;
		
//		11. 변수 lo2에 저장된 값을 출력 하여라. ( 결과 네 번째 줄 )
		System.out.println(lo2);
		
		/*
		3. 나머지 연산자 ( % )
			- 왼 쪽의 피 연산자를 오른쪽의 피 연산자로 나누고 난 나머지 값을 돌려준다.
			- boolean형에는 사용할 수 없다. 
		*/
		
		int num1 = 22;
		int num2 = 7;
		
//		몫
		int share = num1 / num2;
		int remain = num1 % num2;
		
//		num1을 num2로 나눈 몫은 share이고, 나머지는 remain이다.
		System.out.println(num1 + "(을)를 " + num2 + "로 나눈 몫은 " + share + "이고, "
				+ "나머지는 " + remain + "이다.");
		
		/*
		4. 쉬프트 연산자 ( <<, >>, >>> )
			- 정수형 변수에만 사용할 수 있다.
			- 연산 속도가 매우 빠르기 때문에 사용한다.
			- x << n : x * ( 2 ^ n )
			- x >> n : x / ( 2 ^ n )
			
				10		0 0 0 0 1 0 1 0
				10 << 2	0 0 1 0 1 0 0 0	10*(2**2)	오버 플로우가 발생할 수 있음.
				10 >> 2	0 0 0 0 0 0 1 0	10/(2**2)	0에 수렴
		*/
		int i4 = 10;
		int result4 = i4 << 4;
		System.out.println("i4 << 4 : " + result4);
		System.out.println("i4 >> 2 : " + (i4 >> 2));
		
		/*
		5. 비교 연산자
			- 두 개의 변수 또는 리터럴을 비교하는 데 사용된다.
			- 주로 조건문과 반복문의 조건식에 사용되며, 연산 결과로는 true, false의 값을 가진다.
			- 이항 연산자이다.
		*/
		
		/*
		6. 대소 비교 연산자 ( <, >, <=, >= )
			- 기본형 중에서 boolean을 제외한 나머지 자료형에 사용 가능하다.
		
				    수식	│			연산결과
			    ────────┼────────────────────────────────────────────
				 x > y	│	x가 y보다 클 때만 true, 그 외에는 false.
				 x < y	│	x가 y보다 작을 때만 true, 그 외에는 false.
				 x >= y	│	x가 y보다 크거나 같을 때만 true, 그 외에는 false.
				 x <= y	│	x가 y보다 작거나 같을 때만 true, 그 외에는 false.
		*/
		
		/*
		7. 등가 비교 연산자 ( ==, != )
			- 모든 자료형에 사용이 가능하다.
			
				    수식	│			연산결과
			    ────────┼──────────────────────────────────────
				 x == y	│	x가 y와 같을 때만 true, 그 외에는 false.
				 x != y	│	x가 y와 다를 때만 true, 그 외에는 false.
		*/
		
		boolean result6 = 5 < 10;
		
		System.out.println(result6);
		
		System.out.println(10 == 10.0f);
		
		System.out.println('0' == 0);
		
		System.out.println(0.1 == 0.1f);
		
		System.out.println(0.5 == 0.5f);
		
		/* 
		8. 비트연산자 ( &, |, ^ )
			- 이진 비트의 연산 수행
			- 실수형을 제외한 모든 기본형에 사용할 수 있다.
			
				| ( OR 연산 )		: 피 연산자 중 어느 한 쪽의 값이 1이면, 1의 결과를 가져온다.	
				& ( AND 연산 )	: 피 연산자가 둘 다 1이면, 1의 결과를 가져온다.
				^ ( XOR 연산)	: 피 연산자가 서로 다르면, 1의 결과를 가져온다.
			
					3 -> 00000011
					5 -> 00000101
				3 | 5 -> 00000111
				3 & 5 -> 00000001
				3 ^ 5 -> 00000110
		*/
		
		/* 
		9. 논리 연산자 ( &&, || )
			- 피 연산자로 boolean형 값 또는 boolean형을 결과로 하는 조건식 만을 허용한다.
			- || 연산이 &&보다 연산 우선순위가 낮다.
			
				|| ( OR 결합 )	: 피 연산자 중 어느 한 쪽만 true이면, true의 결과를 가져온다.
				&& ( AND 결합 )	: 피 연산자 양 쪽 모두 true이면, true의 결과를 가져온다.
		*/
		
		int input = 17;
		
//		3 < input <= 15
//		3 < input && input <= 15
		boolean result = 3 < input && input <= 15;
		System.out.println(result);
		
//		1. 변수 ch01을 선언하고 원하는 문자로 초기화하여라.
		char ch01 = 'z';
		
//		2. 변수 ch01의 값이 영어 대문자일 때 true인 조건식을 작성 하여라.
		System.out.println('A'<=ch01 && ch01 <='Z');
		
//		3. 변수 ch01의 값이 영어 소문자일 때 true인 조건식을 작성 하여라.
		System.out.println('a'<=ch01 && ch01 <='z');
		
//		4. 변수 ch01의 값이 영문자일 때 true인 조건식을 작성 하여라.
		System.out.println('A'<=ch01 && ch01 <='Z' || 'a'<=ch01 && ch01 <='z');
		
//		5. 변수 ch01의 값이 ASCII값 숫자 때 true인 조건식을 작성 하여라.
		System.out.println('0'<=ch01 && ch01 <='9');
		
//		6. ch01의 값이 영문자 또는 숫자일 때 true인 조건식을 작성 하여라.
		System.out.println('A'<=ch01 && ch01 <='Z' || 'a'<=ch01 && ch01 <='z' || '0'<=ch01 && ch01 <='9');
	}
}
