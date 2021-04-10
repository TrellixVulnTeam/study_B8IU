package z_exam;

import java.util.Scanner;

public class Exam_04 {
	public static void main(String[] args) {
		/*
		[4-1] 다음의 문장들을 조건식으로 표현하라.
			(1) int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식
				x > 10 && x < 20
			(2) char형 변수 ch가 공백이고 탭이 아닐 때 true인 조건식
				ch == ' ' && ch != '\t'
			(3) char형 변수 ch가 'x' 또는 'X'일 때 true인 조건식
				ch == 'x' || ch == 'X'
			(4) char형 변수 ch가 숫자('0'~'9')일 때 true인 조건식
				ch >= '0' && ch <= '9'
			(5) char형 변수 ch가 영문자(대문자 또는 소문자)일 때 true인 조건식
				ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z'
			(6) boolean형 변수 powerOn가 false일 때 true인 조건식
				poserOn == false
				!powerOn
			(7) 문자열 참조변수 str이 "yes"일 때 true인 조건식
				"yes".equals(str)
		*/
		
		/*
		[4-2] 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오.
		*/
		int sum = 0;
		for(int i = 1; i < 21; i++){
			if(i % 2 != 0 && i % 3 != 0){
//			if(!(a % 2 == 0 || a % 3 == 0)){
				sum +=i;
			}
		}
		System.out.println(sum);
		
		/*
		[4-3] 다음의 for문을 while문으로 변경하시오.
		
		for(int dan=2; dan < 10; dan++){
			for(int gob = 1; gob < 10; gob++){
				System.out.println(dan + " * " + gob + " = " + dan*gob);
			}
		}
		*/
		int dan = 2;
		int gob = 1;
		while (true){
			if (gob > 9){
				dan++;
				gob = 1;
			}
			if (dan > 9){
				break;
			}
			System.out.println(dan + " * " + gob + " = " + dan*gob);
			gob++;
		}
		
		/*
		[4-4] 두 개의 주사위를 던졌을 때, 
			눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오.
		*/
		for(int dice1 = 1; dice1 < 7; dice1++){
			for(int dice2 = 1; dice2 < 7; dice2++){
				if (dice1 + dice2 == 6){
					System.out.println("dice 1 : " + dice1 + ", dice 2 : " + dice2);
				}
			}
		}
		
		/*
		[4-5] 방정식 2x + 4y = 10의 모든 해를 구하시오.
			단, x와 y는 정수이고 각각의 범위는 0<=x<=10, 0<=y<=10 이다.
		*/
		for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				if(x * 2 + y * 4 == 10){
					System.out.println("x : " + x + ", y : " + y);
				}
			}
		}
		
		/*
		[4-6] 사용자로부터 두 개의 정수(시작, 끝)를 입력받아
			시작(포함)에서 끝(포함)까지의 곱을 출력하는 프로그램을 작성하시오.
		*/
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫 번째 숫자 입력해주세요 : ");
		int num1 = sc.nextInt();
		System.out.println("두 번째 숫자 입력해주세요 : ");
		int num2 = sc.nextInt();
		
		if(num1>num2){
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if (num1==num2){
			System.out.println("두 수가 같습니다.");
		}else{
			int times = 1;
			for(int i = num1; i <= num2; i++){
				times *= i;
			}
			System.out.println(num1 + " 부터 " + num2 + " 까지의 곱 : " + times);
		}
		*/
		
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫 번째 정수를 입력해주세요 : ");
		int num1 = sc.nextInt();
		System.out.println("두 번째 정수를 입력해주세요 : ");
		int num2 = sc.nextInt();
		
		if(num1 > num2){
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		if (num1 == num2){
			System.out.println("두 수가 같습니다.");
		} else if(num1 <= 0){
			System.out.println("0 이하의 정수는 입력될 수 없습니다.");
		} else {
			long times = 1;
			for(int i = num1; i <= num2; i++){
				if(times > 0){
					times *= i;					
				} else {
					break;
				}
			}
			if(times > 0){
				System.out.println(num1 + " 부터 " + num2 + " 까지의 곱 : " + times);
			} else {
				System.out.println("Overflow 발생");
			}
		}
		*/
		
		/*
		[4-7-A] 1 + (1+2) + (1+2+3) + (1+2+3+4) + ... + (1+2+3+...+10) 의
			결과를 계산하시오.
		*/
		
		/*
		int sum = 0;
		int total = 0;
		for(int i = 1; i < 11; i++){
			sum += i;
			total += sum;
		}
		System.out.println(total);
		*/
		
		/*
		int sum = 0;
		for(int i = 1; i < 11; i++){
			sum += i * (11 - i);
		}
		System.out.println(sum);
		*/
		
		int sum_4_7_A = 0;
		for(int i = 1; i < 11; i++){
			for(int j = 1; j < i + 1; j++){
				sum_4_7_A += j;
			} 
		}
		System.out.println(sum_4_7_A);
		
		/*
		[4-7-B] 1 + (1+2) + (1+2+3) + (1+2+3+4) + ... + (1+2+3+...+10) 를
			출력하시오.
		*/
		String result_4_7_B = "1";
		for(int i = 2; i <= 10; i++){
			result_4_7_B += " + (";
			for(int j = 1; j<=i; j++){
				if(j!=i){
					result_4_7_B += j+"+";
				}else{
					result_4_7_B += j;
				}
			}
			result_4_7_B += ")";
		}
		System.out.println(result_4_7_B);
		
		/*
		[4-8] 1 + ( - 2 ) + 3 + ( - 4 ) + ... 과 같은 식으로 계속 더해나갔을 때,
			몇까지 더해야 총합이 100 이상이 되는지 구하시오.
		*/
		int sum_4_8 = 0;
		int count = 0;
		while (true){
			if (count %2 == 0){
				sum_4_8 -= count;
			}else{
				sum_4_8 += count;
			}
			if (sum_4_8 >= 100){
				break;
			}
			count++;
		}
		System.out.println(count);
		
		/*
		[4-9-A] 사용자로부터 입력받은 정수의 각 자리의 합을 더한 결과를 출력하는 프로그램을 작성하시오.
			예를 들어 사용자가 53263을 입력했다면 결과는 19가 되어야 한다.
		*/
		/*
		Scanner sc_4_9_A = new Scanner(System.in);
		System.out.println("정수를 입력해 주세요.");
		int input = sc_4_9_A.nextInt();
		int result_4_9_A = 0;
		while (input > 0){
			int rem = input % 10;
			result_4_9_A += rem;
			input /= 10;
		}
		System.out.println("각 자리의 합 : " + result_4_9_A);
		*/
		
		/*
		[4-9-B] 사용자로부터 입력받은 정수가 팰린드롬인지 확인하여 
			true 또는 false를 출력하는 프로그램을 작성하시오.
		*/
		/*
		Scanner sc_4_9_B = new Scanner(System.in);
		System.out.println("정수를 입력해 주세요.");
		int input_4_9_B = sc_4_9_B.nextInt();
		int temp = input_4_9_B;
		String rem = "";
		while (true){
			if(temp == 0){
				break;
			}
			rem = rem + (temp % 10);
			temp /= 10;
		}
		boolean result = (input_4_9_B+"").equals(rem); 
		System.out.println(input_4_9_B);
		System.out.println(rem);
		System.out.println(input_4_9_B + "은 팰린드롬인가? : " + result);
		*/
		
		/*
		Scanner sc_4_9_B = new Scanner(System.in);
		System.out.println("정수를 입력해 주세요.");
		int input = sc_4_9_B.nextInt();
		int output = 0;
		int temp = input;
		while (temp > 0){
			output *= 10;
			output += temp % 10;
			temp /= 10;
		}
		System.out.println(input + "은 팰린드롬인가? : " + (input == output));
		*/
		
		/*
		[4-10] 피보나치(Fibonnaci) 수열(數列)은 앞의 두 수를 더해서 다음 수를 만들어 나가는 수열이다.
			예를 들어 앞의 두 수가 1과 1이라면 그 다음 수는 2가 되고 그 다음 수는 1과 2를 더해서 3이 되어서
			1, 1, 2, 3, 5, 6, 13, 21, ... 과 같은 식으로 진행된다.
			1과 1부터 시작하는 피보나치 수열의 10번째 수는 무엇인지 계산하는 프로그램을 작성하시오.
		*/
		int num1_4_10 = 1;
		int num2_4_10 = 1;
		for(int i = 3; i < 11; i++){
			int temp_4_10 = num1_4_10;
			num1_4_10 = num2_4_10;
			num2_4_10 = num1_4_10 + temp_4_10;
		}
		System.out.println("1과 1부터 시작하는 피보나치 수열의 10번째 수 : " + num2_4_10);
		
		/*
		[4-11] 다음은 주어진 문자열(value)이 숫자인지를 판별하는 프로그램이다.
			(1)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
			
			String value = "12o34"
			char ch = ' ';
			boolean isNumber = true;
//			반복문과 charAt(int i)를 이용해서 문자열의 문자를
//			하나씨 읽어서 검사한다.
			for(int i=0; i < value.length(); i++){
			/*
			(1)
			
			
			
			
			* /
			}
			if(isNumber){
				System.out.println(value+"는 숫자입니다.");
			} else {
				System.out.println(value+"는 숫자가 아닙니다.");
			}
		*/
		
		String value = "12o34";
		char ch_4_11 = ' ';
		boolean isNumber = true;
		for(int i = 0; i < value.length(); i++){
			if('0' > value.charAt(i) || '9' < value.charAt(i)){
				isNumber = false;
				break;
			}
		}
		if(isNumber){
			System.out.println(value+"는 숫자입니다.");
		} else {
			System.out.println(value+"는 숫자가 아닙니다.");
		}
		
	}
}
