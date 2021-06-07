package z_exam;

public class Exam_03 {
	public static void main(String[] args) {
		
		/*
		[3-1] 다음 중 형변환을 생략할 수 있는 것은? ( 모두 고르시오 )
		
			byte b = 10;
			char ch = 'A';
			int in = 100;
			long lo = 1000L;
			
			(1) b = (byte)in;
			(2) ch = (char)b;
			(3) short s = (short) ch;
			(4) float f = (float) lo;
			(5) in = (int) ch;
		*/
		
		byte b_3_1 = 10;
		char ch_3_1 = 'A';
		int in_3_1 = 100;
		long lo_3_1 = 1000L;
		
		b_3_1 = (byte)in_3_1;
//			long을 byte로 변환하기 때문에 생략 불가
		ch_3_1 = (char)b_3_1;
//			byte를 char로 변환하기 때문에 생략 불가
		short s_3_1 = (short) ch_3_1;
//			char를 short로 변환하기 때문에 생략 불가
		float f_3_1 = (float) lo_3_1;
//			* long을 float로 변환하기 때문에 생략 가능
		in_3_1 = (int) ch_3_1;
//			* char를 int로 변환하기 때문에 생략 가능 

		/*
		[3-2] 다음 연산의 결과를 적으시오.
		
			int x = 2;
			int y = 5;
			char c = 'A';	// 'A'의 문자코드는 65
			System.out.println(1 + 3 << 33);
			System.out.println(y >= 5 || x < 0 && x > 2);
			System.out.println(y += 10 - x++);
			System.out.println(x += 2);
			System.out.println(!('A' <= c && c <='Z'));
			System.out.println('C'-c);
			System.out.println('5'-'0');
			System.out.println(c+1);
			System.out.println(++c);
			System.out.println(c++);
			System.out.println(c);
		*/
		
		int x_3_2 = 2;
		int y_3_2 = 5;
		char c_3_2 = 'A';
//			'A'의 문자코드는 65
		System.out.println(1 + x_3_2 << 33);
//			(1 + x)를 33번 왼쪽으로 shift.
//			int를 32번 왼쪽으로 shift하면 처음 값과 동일한 값이 됨.
//			따라서 3를 1번 왼쪽으로 shift한 3 * 2^1 = 6과 같음.
//			출력 값 : 6
		System.out.println(y_3_2 >= 5 || x_3_2 < 0 && x_3_2 > 2);
//			y는 5보다 크거나 같으므로 true.
//			x는 0보다 작지 않으므로 false.
//			x는 2보다 크지 않으므로 false.
//			연산 순서상 &&가 ||보다 우선 연산되므로
//			true || false && false => true || false => true
//			출력 값 : true
		System.out.println(y_3_2 += 10 - x_3_2++);
//			10 - x = 8
//			계산 후 x는 1 증가되어 3이 됨
//			y += 8이므로 y에 8이 더해진 값이 y에 입력 됨.
//			y = 5 + 8 = 13
//			출력 값 : 13
		System.out.println(x_3_2 += 2);
//			x에 2가 더해진 값이 x에 입력 됨
//			x = 3 + 2 = 5
//			출력 값 : 5
		System.out.println(!('A' <= c_3_2 && c_3_2 <='Z'));	
//			char c를 int로 전환하면 65
//			'A'를 int로 변환한 65는 65보다 작거나 같으므로 true.
//			'Z'를 int로 변환한 90은 65보다 크거나 같으므로 true.
//			true && true => true
//			!true => false
//			출력 값 : false
		System.out.println('C'- c_3_2);
//			char - int => int - int
//			'C' - 'A' => 67 - 65 = 2
//			출력 값 : 2
		System.out.println('5'-'0');
//			char - char => int - int
//			'5' - '0' => 53 - 48 = 5
//			출력 값 : 5
		System.out.println(c_3_2+1);
//			char + int => int + int
//			'A' + 1 => 65 + 1 = 66
//			출력 값 : 66
		System.out.println(++c_3_2);
//			c를 1 증가시킨 후 그 값을 출력
//			c = ++'A' => 'B'
//			출력 값 : 'B'
		System.out.println(c_3_2++);
//			c를 출력한 후 1 증가
//			출력 값 : 'B'
//			c = 'B'++ => 'C'
		System.out.println(c_3_2);
//			출력되는 값 : 'C'
		
		/*
		[3-3] 아래는 변수 num의 값에 따라 "양수, "음수", "0"을 출력하는 코드이다. 삼항 연산자를 이용해서 (1)에 알맞은 코드를 넣으시오.
		
			int num = 10;
			String result = /* (1) * /;
			System.out.println(result);
			
		  - 결과
		  	양수
		*/
		
//		3항 연산자 => (조건식) ? 참 : 거짓
//		(num이 0보다 클 경우)? "양수" : ((num이 0일 경우)? "0" : "음수")
		
		int num_3_3 = 10;
		String result_3_3 = num_3_3 > 0 ? "양수" : num_3_3 == 0 ? "0" : "음수";
		System.out.println(result_3_3);
		
		/*		
		[3-4]아래의 코드는 사과를 담는데 필요한 바구니 ( 버켓 ) 의 수를 구하는 코드이다.
			만일 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면, 13개의 바구니가 필요할 것이다.
			(1)에 알맞은 코드를 넣으시오.
			
			int apples = 123;									// 사과의 개수
			int bucket = 10;									// 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
			int numOfBucket = ( /* (1) * / );					// 모든 사과를 담는데 필요한 바구니의 수
			System.out.println("필요한 바구니의 수 :" + numOfBucket);
		  
		  - 결과
			필요한 바구니의 수 : 13
		*/
		
		int apples_3_4 = 123;
//			사과의 개수
		int bucket_3_4 = 10;
//			바구니의 크기(바구니에 담을 수 있는 사과의 개수)
		int numOfBucket_3_4 = ( apples_3_4 + bucket_3_4 - 1 ) / bucket_3_4;
//		int numOfBucket_3_4 = apples_3_4 % bucket_3_4 ? apples_3_4 / bucket_3_4 + 1 : apples_3_4 % bucket_3_4;
//		int numOfBucket_3_4 = apples_3_4 / bucket_3_4 + apples_3_4 % bucket_3_4 ? 1 : 0;
//			모든 사과를 담는데 필요한 바구니의 수
		System.out.println( "필요한 바구니의 수 :" + numOfBucket_3_4 );
		
		
		/*		
		[3-5] 아래의 코드는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다.
			만일 변수 num의 값이 '456'이라면 '400'이 되고, '111'이라면 '100'이 된다.
			(1)에 알맞은 코드를 넣으시오.
			
			int num = 456;
			int result = /* (1) * /;
			System.out.println(result);
			
		  - 결과
			400
		*/
		int num_3_5 = 456;
			// 100의 자리 이하를 버리기만 하면 되기 때문에 100으로 나눈 후 다시 100으로 곱함. 
		int result_3_5 = num_3_5 / 100 * 100;
//		int result_3_5 = num_3_5 - num_3_5 % 100; 
		System.out.println(result_3_5);
		
		
		/*		
		[3-6] 아래 코드의 문제점을 수정해서 실행 결과와 같은 결과를 얻도록 하시오.
			
			byte b = 20;
			byte c = a + b;
			char ch = 'A';
			ch = ch + 2;
			float f = 3 / 2;
			long l = 3000 * 3000 * 3000;
			float f2 = 0.1f;
			double d = 0.1;
			boolean result = d == f2;
			System.out.println("C="+c);
			System.out.println("ch="+ch);
			System.out.println("f="+f);
			System.out.println("l="+l);
			System.out.println("result="+result);
			
		  - 결과
			c = 30
			ch = c
			f = 1.5
			l = 27000000000
			result = true
		*/
		byte a_3_6 = 10;
//			a가 정의되지 않아 정의함.
//			byte c = a + b 이며, 출력 결과 상 30이고,
//			byte b가 20으로 정의되어 있어 a는 10임.
		byte b_3_6 = 20;
		byte c_3_6 = (byte)(a_3_6 + b_3_6);
//			byte + byte => int + int => int
//			int형은 byte에 대입 불가하기에 형변환 필요
		char ch_3_6 = 'A';
		ch_3_6 = (char) (ch_3_6 + 34);
//			'A'와 'c'의 차이는 34
//			char + int => int + int => int
//			char에 int를 대입하기 위해 형변환 필요
		float f_3_6 = 3 / 2F;
//			float f_3_6 = (float)3 / 2 ;
//			int / int => int가 되기 때문에 소수점이 발생하지 않음.
//			두 수중 하나를 float형으로 변환하여 풀어야 계산 가능
		long l_3_6 = 3000 * 3000 * 3000L;
//			long l_3_6 = (long)3000 * 3000 * 3000;
//			3000 * 3000 * 3000은 27억으로,
//			int의 한계치인 약 21억을 초과하기 때문에 문자형을 long으로 변경하여 계산
		float f2_3_6 = 0.1f;  
		double d_3_6 = 0.1f;
		boolean result_3_6 = d_3_6 == f2_3_6;
//			f2는 float형, d는 double형이기 때문에 불일치 발생
//			double을 float에 넣을 수 없기에 double에 float형 삽입
		System.out.println( "C=" + c_3_6 );
		System.out.println( "ch=" + ch_3_6 );
		System.out.println( "f=" + f_3_6 );
		System.out.println( "l=" + l_3_6 );
		System.out.println( "result=" + result_3_6 );
		
		/*		
		[3-7] 아래는 변수 num의 값보다 크면서도 가장 가까운 10의 배수에서 변수 num의 값을 뺀 나머지를 구하는 코드이다.
			예를 들어, 24의 크면서도 가장 가까운 10의 배수는 30이다.
			19의 경우 20이고, 81의 경우 90이 된다.
			30에서 24를 뺀 나머지는 6이기 때문에 변수 num의 값이 24라면 6을 결과로 얻어야 한다.
			(1)에 알맞은 코드를 넣으시오.
			
			int num = 24;
			int result = /* (1) * /;
			System.out.println("result : " + result);
			
		  - 결과
			Result : 6
		*/
		
		int num_3_7 = 24;
//			num에 가장 가까우면서 10으로 나누어 떨어지는 값을 구하기 위해
//			num을 10으로 나눈 후 다시 10을 곱하고 여기에 10을 더하여 
//			num보다 크면서도 가장 가까운 10의 배수를 구한 후,
//			구해진 수에서 num을 빼서 그 차이를 result에 저장 후 출력한다.
		int result_3_7 = num_3_7 / 10 * 10 + 10 - num_3_7;
//		int result_3_7 = (num_3_7 / 10 + 1) * 10 - num_3_7;
//		int result_3_7 = num_3_7 - n_3_7 % 10 + 10 - num_3_7;
//		int result_3_7 = 10 - n_3_7 % 10;
		System.out.println( "result : " + result_3_7 );

		/*		
		[3-8] 아래는 화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드이다.
			변환공식이 'C = 5 / 9 × ( F - 32 )'라고 할 때, (1)과 (2)에 알맞은 코드를 넣으시오.
			단, 변환 결과값은 소수 셋째자리에서 반올림해야 한다.
			
			int fahrenheit = 100;							// 화씨
			float formula = ( /* (1) * / );					// 변환공식 활용
			float celcius = ( /* (2) * / );					// formula 소수점 셋째자리에서 반올림
			System.out.println("Fahrenheit:"+fahrenheit);
			System.out.println("Celcius:"+celcius);
		*/
		
		int fahrenheit_3_8 = 100;
//			화씨
		float formula_3_8 = ( float )5 / 9 * ( fahrenheit_3_8 - 32 );
//			변환공식 활용
//		float celcius_3_8 = (int)(formula_3_8 * 100 + 0.5)/100.0F;
		float celcius_3_8 = Math.round(formula_3_8 * 100)/100.0F;
//			formula 소수점 셋째자리에서 반올림
		System.out.println( "Fahrenheit:" + fahrenheit_3_8 );
		System.out.println( "Celcius:" + celcius_3_8 );
		
		
		
	}
}
