package e_oop;

import java.util.Scanner;

public class CalcTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calc calc = new Calc();
		while (true) {
//			5. 사용자로부터 정수를 입력 받아 변수 firstNum에 저장 하여라.
			System.out.println("정수를 입력하세요.");
			int firstNum = sc.nextInt();
			
			while (true) {
//				6. 사용자로부터 부호를 입력 받아 변수 buho에 저장 하여라.
				System.out.println("부호를 입력하세요.");
				String buho = sc.next();
				if ("C".equals(buho) || "c".equals(buho)){
					System.out.println(buho + " 입력 됨. 초기화.");
					break;
				} else if (!"+".equals(buho) && !"-".equals(buho) && !"*".equals(buho) && !"/".equals(buho)){
					System.out.println(buho + "(은)는 올바른 계산부호가 아닙니다.");
					System.exit(0);
				}
				
//				7. 사용자로부터 정수를 입력 받아 변수 secondNum에 저장 하여라.
				System.out.println("정수를 입력하세요.");
				int secondNum = sc.nextInt();
				
//				8. buho에 저장된 값이 '+'이면 add메서드, '-'이면 substract메서드
//					'*'이면 multiply메서드, '/'이면 divide메서드를 호출하고 결과를 출력하여라.
//					단. buho의 저장된 값이 위의 4가지 경우가 아니라면 '연산종료'를 출력하여라.
				System.out.println(firstNum + " " + buho + " " + secondNum + " = ");
				
				if ("/".equals(buho)) {
					if (secondNum == 0) {
						System.out.println("0으로 나눌 수 없습니다.");
						System.exit(0);
					}
					float result02 = calc.divide(firstNum, secondNum);
					firstNum = (int)result02;
					if (result02 == firstNum){
						System.out.println(firstNum);
					} else {
						System.out.println(result02);
					}
				} else {
					if ("+".equals(buho)) {
						firstNum = calc.add(firstNum, secondNum);
					} else if ("-".equals(buho)) {
						firstNum = calc.substract(firstNum, secondNum);
					} else if ("*".equals(buho)) {
						firstNum = calc.multiply(firstNum, secondNum);
					}
					System.out.println(firstNum);
				}
			}
		}
	}
}

class Calc{
//	1. 두 개의 int타입 입력받아 두 인자의 합의 결과를 반환하는 인스턴스메서드
//		add를 구현 하여라.
	int add(int num1, int num2){
		return num1 + num2;
	}
	
//	2. 두 개의 int타입 입력받아 앞의 인자에서 뒤의 인자를 뺀 결과를 반환하는
//		인스턴스메서드 substract를 구현 하여라.
	int substract(int num1, int num2){
		return num1 - num2;
	}
	
//	3. 두 개의 int타입 입력받아 두 인자의 곱의 결과를 반환하는 인스턴스메서드
//		multiply를 구현 하여라.
//		단. overflow를 고려하여라.
	int multiply(int num1, int num2){
		if ((long)num1 * num2 < Integer.MIN_VALUE || Integer.MAX_VALUE < (long)num1 * num2){
			System.out.println("Overflow 발생");
			System.exit(0);
		}
		return num1 * num2;
	}
	
//	4. 두 개의 int타입 입력받아 앞의 인자를 뒤의 인자로 나누기한 결과를 반환하는
//		인스턴스메서드 divide를 구현 하여라.
//		단. 결과는 소수점 두 번째 자리에서 반올림하여 젓 번째 자리까지 표현 하여라.
	float divide(int a, int b){
		return Math.round((float)a / b * 10) / 10f;
	}
}
