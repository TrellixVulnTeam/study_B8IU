package d_array;

public class Array_01 {
	public static void main(String[] args) {
		/*
		1. 배열(Array)
			- 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
				int math;
				int eng;
				int soc;
		*/
		
		/*
		2. 배열의 선언
			- 원하는 타입의 변수를 선언하고 변수 또는 타입에 배열임을 의미하는 대괄호[]를 붙이면 된다.
			- 구조
				변수타입[] 변수명;
					ex) int[] score;
				변수타입 변수명[];
					ex) int score[];
		*/
		
		/*
		3. 배열의 생성
			- 배열을 생성하기 위해서는 연산자 'new'와 함께 배열의 타입과 크기를 지정해주어야 한다.
				ex) int[] score = new int[3];
			- 배열은 한 번 생성되면 크기를 변경할 수 없다.
		*/
		
		int[] score = new int[5];
//			{0, 0, 0, 0, 0}
		
/*		System.out.println(score[0]);
		System.out.println(score[1]);
		System.out.println(score[2]);
		System.out.println(score[3]);
		System.out.println(score[4]);
		
		score[0] = 10;
		score[1] = 20;
		score[2] = 30;
		score[3] = 40;
		score[4] = 50;
		
		System.out.println(score[0]);
		System.out.println(score[1]);
		System.out.println(score[2]);
		System.out.println(score[3]);
		System.out.println(score[4]);*/
		
		
		for(int index = 0; index < score.length; index++){
			System.out.println(score[index]);
		}
		
		for(int index = 0; index < score.length; index++){
//			score[index] = (index + 1) * 10;
			score[index] = index * 10 + 10;
		}
		
		for(int index = 0; index < score.length; index++){
			System.out.println(score[index]);
		}

//		2. 배열의 선언과 초기화를 원하는 값으로 하기
//		int[] score2 = new int[]{10, 20, 30, 40, 50};
		int[] score2 = {10, 20, 30, 40, 50};
		
		for(int index = 0; index < score2.length; index++){
			System.out.println(score2[index]);
		}
		
		int[] ss;
		ss = new int[2];
		
		int[] ss2;
		ss2 = new int[]{2, 3, 4};
		
//		int[] ss3;
//		ss3 = {5, 6, 7};
//		동시에만 가능
		
//		3. 변수 names에 같은 팀원의 이름을 저장해주세요.
//		String[] names = {"지훈", "정원", "학재"};
//		System.out.println(names[1].length());
		
		String[] names = {"이영훈", "유은서"};
		
		/*
		이
		영
		훈
		-----
		유
		은
		서
		*/
		
		for(int index = 0; index < names.length; index++){
			for(int length = 0; length < names[index].length(); length++){
				System.out.println(names[index].charAt(length));
			}
			if(index != names.length - 1){
				System.out.println("-----");
			}
		}
	}
}
