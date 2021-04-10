package z_exam;

public class Exam_02 {
	public static void main(String[] args) {
		/*
		[2-1] 다음 표의 빈 칸에 8개의 기본형(primitive type)을 알맞은 자리에 넣으시오.
				┌──────┬──────────┬──────────┬──────────┬──────────┐
				│  \크기│          │          │          │          │
				│   \  │  1 byte  │  2 byte  │  4 byte  │  8 byte  │
				│ 종류\ │          │          │          │          │
				├──────┼──────────┼──────────┼──────────┼──────────┤
				│ 논리형 │ boolean  │          │          │          │
				├──────┼──────────┼──────────┼──────────┼──────────┤
				│ 문자형 │          │   char   │          │          │
				├──────┼──────────┼──────────┼──────────┼──────────┤
				│ 정수형 │   byte   │  short   │   int    │   long   │
				├──────┼──────────┼──────────┼──────────┼──────────┤
				│ 실수형 │          │          │  float   │  double  │
				└──────┴──────────┴──────────┴──────────┴──────────┘
		*/
		
		
		/*
		[2-2] 다음의 문자에서 리터럴, 변수, 상수, 키워드를 적으시오.
			int i = 100;
			long l = 100L;
			final float PI = 3.14f;
			- 리터럴 : 100, 100L, 3.14f
			- 변수 : i, l
			- 키워드 : int, long, float, final
			- 상수 : PI
		*/
		
		
		/*
		[2-3] 다음 중 기본형(primitive type)이 아닌 것은?
			1. int
			*2. Byte	// byte가 기본형이며, Java는 대소문자를 구분하는 언어.
			3. double
			4. boolean
		*/
		
		
		/*
		[2-4] 다음 문장들의 출력 결과를 적으세요. 오류가 있는 문장의 경우, 괄호 안에 '오류'라고 적어주세요.
			System.out.println("1"+"2");		// String + String => String "12"
			System.out.println(true + "");		// boolean + String => String "true"
			System.out.println('A' + 'B');		// char + char => int + int
												// 'A' + 'B' => 65 + 66 = 131
			System.out.println('1' + 2);		// char + int => int + int
												// 49 + 2 => 51
			System.out.println('1' + '2');		// char + char => int + int
												// '1' + '2' => 49 + 50 = 99
			System.out.println(4 + 24.3715F);	// int + float => float + float => 4 + 24.3715 = 28.3715
			System.out.println('A' + 3.14);		// char + double => double + double => 65 + 3.14 = 68.14
			System.out.println('J' + "ava");	// char + String => String + String => String "Java"
			System.out.println(true + null);	// boolean + null_type => error
		*/
		System.out.println("1"+"2");
		System.out.println(true + "");
		System.out.println('A' + 'B');
		System.out.println('1' + 2);
		System.out.println('1' + '2');
		System.out.println(4 + 24.3715F);
		System.out.println('A' + 3.14);
		System.out.println('J' + "ava");
//		System.out.println(true + null);

		/*
		[2-5] 다음 중 키워드가 아닌 것은?(모두 고르시오)
			1. if
			*2. True
//				'참'을 뜻하는 키워드는 true
			*3. NULL
//				'아무것도 없음'을 뜻하는 키워드는 null
			*4. Class
//				'클래스'의 키워드는 class
			*5. System
//				클래스의 하나
		*/
		
		/*
		[2-6] 다음 중 변수의 이름으로 사용할 수 있는 것은? (모두 고르시오)
			*1. $ystem
			2. channel#5
//				변수의 이름에는 $, _를 제외한 특수문자를 사용할 수 없다.
			3. 7eleven
//				변수의 이름은 숫자로 시작할 수 없다.
			*4. If
			*5. 자바
			6. new
//				사용중인 키워드
			*7. $MAX_NUM
			8. hello@com
//				변수의 이름에는 $, _를 제외한 특수문자를 사용할 수 없다.
		*/
		
		
		/*
		[2-7] 참조형 변수(reference type)와 같은 크기의 기본형(primitive type)은? (모두 고르시오)
			[Hint] 참조형 변수의 크기는 4byte이다.
			*1. int		// 4byte
			2. long		// 8byte
			3. short	// 2byte
			*4. float	// 4byte
			5. double	// 8byte
		*/
		
		
		/*
		[2-8] 다음 중 형변환을 생략할 수 있는 것은? (모두 고르시오)
			byte b = 10;
			char ch = 'A';
			int i = 100;
			long l = 1000L;
			
			1. b = (byte)i;
			2. ch = (char)b;
			3. short s = (short)ch;
			*4. float f = (float)l;
//				float는 long보다 더 많은 수를 표현할 수 있어 형변환을 생략하고 대입 가능
			*5. i = (int)ch;
//				char는 byte 수가 int보다 작아 형변환을 생략하고 대입 가능
			
			* byte → small → int → long
		*/
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;
		
		float f = l;
		i = ch;
		System.out.println(f);
		System.out.println(l);
		
		/*
		[2-9] char 타입의 변수에 저장될 수 있는 정수 값의 범위는?
			char 타입은 음수를 표현하지 않아 0 ~ 2**16-1의 숫자를 표현할 수 있다.
			0 ~ 65535
		*/
		
		
		/*
		[2-10] 다음 중 변수를 잘못 초기화 한 것은? (모두 고르시오)
			*1. byte b = 256;
//				byte는 1byte 자료형이며, 8bit로 구성되어있다.
//				음수 확인을 위한 1bit를 제외한 7bit로 숫자를 표현하기 때문에
//				-(2**7) ~ 2**7-1 의 숫자를 입력할 수 있다.
			2. char c = '';
			*3. char answer = 'no';
//				char에는 1개의 문자만을 입력할 수 있다.
			*4. float f = 3.14
//				Java에서 기본 숫자 표현 형태는 double이기에
//				숫자 맨 뒤에 f 또는 F를 붙여야 한다.
			5. double d = 1.4e3f;
		*/
	}
}
