package c_sentence;

public class Sentence_01 {
	public static void main(String[] args) {
		/*
		1. 조건문
		  if-else
		  switch-case
		  - 조건식과 문장을 포함하는 블럭{}으로 구성되어 있다.
		  - 조건식의 결과에 따라서 프로그램의 실행 흐름을 변경할 수 있다.
		*/
		
		/*
		2. if문
		  - 구조
			(1) 기본
				if(조건식){
					조건식의 결과가 true일 때 수행될 문장.
				}
			(2) 1단 변형
				if(조건식){
					조건식의 결과가 true일 때 수행될 문장.
				} else {
					조건식의 결과가 false일 때 수행될 문장.
				}
			(3) 2단 변형
				if(조건식1){
					조건식1의 결과가 true일 때 수행될 문장.
				} else if(조건식2){
					조건식1의 결과가 false이고 조건식 2의 결과가 true일 때 수행될 문장.
				} else {
					조건식 1과 조건식 2가 모두 false일 때 수행될 문장.
				}
		
		
		*/
		int num = -10;
		if(num>0){
			System.out.println("양수이다.");
		} else if(num==0){
			System.out.println("0이다.");
		} else {
			System.out.println("음수이다.");
		}
		
		
//		1. 변수 score를 선언하고 0이상 100이하의 정수 중에 임의의 값으로 초기화 하여라.
		int score = (int)(Math.random()*101);
		System.out.println(score);
//		2. score의 값이 90 이상이면 "A"를 출력, 80점 이상 90점 미만이면 "B"를 출력,
//			70점 이상 80점 미만이면 "C"를 출력, 60점 이상 70점 미만이면 "D"를 출력
//			60점 미만이면 "F"를 출력 하여라. (if-else if문을 이용 하여라.)
		if (score>=90){
			System.out.print("A");
			if(score>=95){
				System.out.println("+");
			} else {
				System.out.println("-");
			}
		} else if(score>=80){
			System.out.print("B");
			if(score>=85){
				System.out.println("+");
			}else{
				System.out.println("-");
			}
		} else if(score>=70){
			System.out.print("C");
			if(score>=75){
				System.out.println("+");
			}else{
				System.out.println("-");
			}
		} else if(score>=60){
			System.out.print("D");
			if(score>=65){
				System.out.println("+");
			}else{
				System.out.println("-");
			}
		} else {
			System.out.println("F");
		}
		
		/*
		3. switch문
			- 조건의 경우의 수가 많을 때는 if문보다는 switch문을 사용한다.
			- 간결해서 알아보기가 쉽다.
			- 조건의 결과값으로 int형 범위의 정수값을 허용한다.
			- 구조
				switch(조건식){
					case 값1:
						조건식과 값1이 같을 때 수행될 문장
						break;
						
					case 값2:
						조건식과 값1이 같을 때 수행될 문장
						break;
					
					case 값3:
						조건식과 값1이 같을 때 수행될 문장
						break;
					default:
						조건식에 만족하는 case가 없을 때 수행될 문장
				}
		
		*/
		
//		1. 변수 random을 선언하고 1이상 5이하의 임의의 정수로 초기화 하여라.
		int random = (int)(Math.random()*5)+1;
//		2. ramdom의 값이 1이면 "32평 아파트 당첨"을, 2이면 "자동차 당첨",
//			3이면 "노트북 당첨, 4이면 "자전거 당첨", 5이면 "다음 기회에"
//			를 출력 하여라.
		switch(random){
			case 1:
				System.out.println("32평 아파트 당첨");
				break;
			case 2:
				System.out.println("자동차 당첨");
				break;
			case 3:
				System.out.println("노트북 당첨");
				break;
			case 4:
				System.out.println("자전거 당첨");
				break;
			default:
				System.out.println("다음 기회에");
		}
		
//		1. 변수 score을 선언하고 0이상 100이하의 임의의 정수로 초기화 하여라.
		int switchScore = (int)(Math.random()*101);
//		2. score의 값이 90 이상이면 "A"를 출력, 80점 이상 90점 미만이면 "B"를 출력,
//			70점 이상 80점 미만이면 "C"를 출력, 60점 이상 70점 미만이면 "D"를 출력
//			60점 미만이면 "F"를 출력 하여라.
//			단, swtich문을 이용 하고 case는 6개만 이용하여라.
		switch(switchScore/10){
			case 10: case 9:
				System.out.println("A");
				break;
			case 8:
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
				break;
			case 6:
				System.out.println("D");
				break;
			default:
				System.out.println("F");
		}
		
//		1. season 변수를 선언하고 1 ~ 12 사이의 임의의 정수값으로 초기화 하여라.
		int season = (int)(Math.random()*12 + 1);
//		2. season의 값이 12, 1, 2의 경우에는 "겨울" 출력
//			3, 4, 5의 경우에는 "봄"을 출력
//			6, 7, 8의 경우 "여름"을 출력
//			9, 10, 11의 경우 "가을"을 출력해주세요.
		switch(season / 3){
			case 1:
				System.out.println("봄");
				break;
			case 2:
				System.out.println("여름");
				break;
			case 3:
				System.out.println("가을");
				break;
			default :
				System.out.println("겨울");
		}
		/*
		
		
		*/
		
		/*
		
		
		*/
		/*
		2. 반복문
			for
			while
			do-while
		
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
