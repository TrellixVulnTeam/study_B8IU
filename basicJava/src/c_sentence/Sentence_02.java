package c_sentence;

import java.util.Scanner;

public class Sentence_02 {
	public static void main(String[] args) {
		/*
		 * 1. 반복문(for, while, do-while) - 어떤 작업을 반복적으로 수행되도록 할 떄 사용된다. - 반복문은
		 * 주어진 조건을 만족하는 동안 주어진 문장을 반복적으로 수행함으로 조건식을 포함한다. - for문은 반복 횟수를 알 때,
		 * while문은 반복 횟수를 모를 때 사용한다.
		 */

		/*
		 * 2. for문 - 기본 구조 for(초기화; 조건식; 증감식){ 조건식이 만족할 때 수행될 문장 }
		 * 
		 * 초기화 -> 조건식 -> 조건식이 만족할 때 수행될 문장 -> 증감식 -> 조건식 -> ... -> 조건식을 만족하지 않을
		 * 경우 종료
		 */

		// 시작 : 0; 끝 : 10; 증가량 : 1
		// 수행 문장 : System.out.println(??);
		// for(int count = 0; count <= 100; count++){
		// System.out.println(count);
		// }

		for (int i = 0; i <= 100; i++) {
			System.out.println(i);
		}

		// Hello Java를 3번 출력해주세요.

		for (int i = 0; i < 3; i++) {
			System.out.println("Hello Java");
		}

		// 1. 5에서 17까지의 합을 구하여라.

		int sum = 0;
		sum += 5;
		sum += 6;
		sum += 7;
		sum += 8;
		sum += 9;
		sum += 10;
		sum += 11;
		sum += 12;
		sum += 13;
		sum += 14;
		sum += 15;
		sum += 16;
		sum += 17;
		System.out.println(sum);

		// 시작 : 5, 끝 : 17, 증가량 : 1
		// 수행 문장 : sum += ??;
		sum = 0;
		for (int i = 5; i <= 17; i++) {
			sum += i;
		}
		System.out.println(sum);

		// 1. 0이상 5이하에서 정수를 결과와 같이 출력 하여라.
		// 시작 : 0, 끝 : 5, 증가량 : 1
		// 수행 문장 : System.out.print(?? + " ");
		System.out.print("1) ");
		for (int i = 0; i <= 5; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 2. 0이상 5이하에서 정수를 결과와 같이 출력 하여라.
		// 시작 : 5, 끝 : 0, 증가량 : -1
		// 수행 문장 : System.out.print(?? + " ");
		System.out.print("2) ");
		for (int i = 5; i >= 0; i--) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 3. 2이상 10이하에서 정수를 합계를 구하여라.
		// 시작 : 2, 끝 : 10, 증가량 : 1
		// 수행 문장 : sum += ??;
		sum = 0;
		for (int i = 2; i <= 10; i++) {
			sum += i;
		}
		System.out.println("3) " + sum);

		// 4. 5이상 15미만에서 정수의 곱을 구하여라. ( overflow를 고려하여라.)
		// 시작 : 5, 끝 : 14, 증가량 : 1
		// 수행 문장 : times *= ??;
		long times = 1;
		for (int i = 5; i < 15;) {
			times *= i++;
		}
		System.out.println("4) " + times);

		// 5. 3이상 4462이하에서 짝수인 정수의 합을 구하여라.
		// 시작 : 3, 끝 : 4462, 증가량 : 1
		// 수행 문장 : sum += ??;
		sum = 0;
		for (int i = 3; i <= 4462; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("5) " + sum);

		// 시작 : 4, 끝 : 4462, 증가량 : 2
		// 수행 문장 : sum += ??;
		sum = 0;
		for (int i = 4; i <= 4462; i += 2) {
			sum += i;
		}
		System.out.println("5) " + sum);

		// 6. 7초과 57미만에서 2또는 3의 배수인 정수의 합을 구하여라.
		// 시작 : 8, 끝 : 56, 증가량 : 1
		// 수행 문장 :
		sum = 0;
		for (int i = 8; i < 57; i++) {
			if (i % 3 == 0 || i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("6) " + sum);

		// 구구단 출력
		// 2 * 1 = 2

		// System.out.println(2 + " * " + 1 + " = " + 2 * 1);
		// System.out.println(2 + " * " + 2 + " = " + 2 * 2);
		// System.out.println(2 + " * " + 3 + " = " + 2 * 3);
		// System.out.println(2 + " * " + 4 + " = " + 2 * 4);
		// System.out.println(2 + " * " + 5 + " = " + 2 * 5);
		// System.out.println(2 + " * " + 6 + " = " + 2 * 6);
		// System.out.println(2 + " * " + 7 + " = " + 2 * 7);
		// System.out.println(2 + " * " + 8 + " = " + 2 * 8);
		// System.out.println(2 + " * " + 9 + " = " + 2 * 9);

		// 시작 : 1, 끝 : 9, 증가량 : 1
		// 반복구문 : System.out.println(2 + " * " + ?? + " = " + 2 * ??);
		for (int gob = 1; gob < 10; gob++) {
			System.out.println(2 + " * " + gob + " = " + 2 * gob);
		}

		// System.out.println(3 + " * " + 1 + " = " + 3 * 1);
		// System.out.println(3 + " * " + 2 + " = " + 3 * 2);
		// System.out.println(3 + " * " + 3 + " = " + 3 * 3);
		// System.out.println(3 + " * " + 4 + " = " + 3 * 4);
		// System.out.println(3 + " * " + 5 + " = " + 3 * 5);
		// System.out.println(3 + " * " + 6 + " = " + 3 * 6);
		// System.out.println(3 + " * " + 7 + " = " + 3 * 7);
		// System.out.println(3 + " * " + 8 + " = " + 3 * 8);
		// System.out.println(3 + " * " + 9 + " = " + 3 * 9);

		// 시작 : 2, 끝 : 9, 증가량 : 1
		// 반복구문
		// for (int gob = 1; gob < 10; gob++){
		// System.out.println(?? + " * " + gob + " = " + ?? * gob);
		// }
		for (int dan = 2; dan < 10; dan += 2) {
			for (int gob = 1; gob < 10; gob += 2) {
				System.out.println(dan + " * " + gob + " = " + dan * gob);
			}
		}
		
		for (int dan = 2; dan < 10; dan++) {
			for (int gob = 1; gob < 10; gob++) {
				if(dan % 2 == 0 && gob % 2 == 1){
					System.out.println(dan + " * " + gob + " = " + dan * gob);					
				}
				
			}
		}
		
		/*
		3. while문
			- 조건식과 수행해야 할 블럭{}만으로 구성되어 있다.
			- 기본 구조
				while(조건식){
					조건식이 true일 때 수행될 문장.
				}
		*/
//		1. 0 ~ 10까지 출력하여라.
		for(int count = 0; count < 11; count++){
			System.out.println(count);
		}
		
//		초기화
//		while(조건식){
//			수행문장
//			증감식
//		}
		
		int count = 0;
		while(count < 11){
			System.out.println(count);
			count++;
		}
		
//		1. 5 ~ 15까지의 합을 구해주세요. - while
		sum = 0;
		for(count = 5; count < 16; count++){
			sum += count;
		}
		System.out.println(sum);
		
		count = 5;
		sum = 0;
		while (count < 16){
			sum += count;
			count++;
		}
		System.out.println(sum);
		
//		2. 구구단을 while문으로만 만들어주세요.
		int dan = 2;
		while(dan < 10){
			int gob = 1;
			while (gob < 10){
				System.out.println(dan + " * " + gob + " = " + dan * gob);
				gob++;
			}
			dan++;
		}
		
		dan = 2;
		while(dan < 10){
			int gob = 1;
			while (gob < 10){
				if(dan%2==0 && gob%2==1){
					System.out.println(dan + " * " + gob + " = " + dan * gob);
				}
				gob++;
			}
			dan++;
		}
			
		dan = 2;
		while(dan < 10){
			int gob = 1;
			while (gob < 10){
				System.out.println(dan + " * " + gob + " = " + dan * gob);
				gob += 2;
			}
			dan += 2;
		}
		
//		1. 7 ~ ? 합이 200이상이 될 때 ?의 값은?
		int num = 7;
		sum = 0;
		while(true){
			sum += num;
//			sum이 200 이상이면 나가
			if(sum >= 200){
				break;
			}
			num++;
		}
		System.out.println(num);
		
		num = 6;
		sum = 0;
		while(sum<200){
			num++;
			sum += num;
		}
		System.out.println(num);
		
		/*
		4. do-while
			- 최초 1회는 반복문을 수행한다.
			- 구조
				do{
					실행문장
				} while(조건문);
		*/
		
//		1. 사용자로부터 문자를 입력받는다.
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력해주세요. 단, exit를 입력 시 종료됩니다.");		
		
		String input;
		do{
			input = sc.next();
//			2. 입력받은 문자를 출력한다.
			System.out.println(input);
//		3. 단, 입력받은 문자가 "exit"이면 반복을 멈춘다.
		}while(!"exit".equals(input));
		
		for (int i = 1; i < 100; i++) {
			if(i % 2 == 0){
				System.out.println(i);
			}
		}
		for (int i = 1; i < 100; i++) {
			if(i % 2 != 0){
				continue;
			}
			System.out.println(i);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
