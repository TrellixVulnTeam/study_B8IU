package d_array;

public class Array_02 {
	public static void main(String[] args) {
//		1. 정수 7개를 저장할 수 있는 변수 score를 선언 및 생성하여라.
		int[] score = new int[7];
		
//		2. 변수 score의 각 요소를 0이상 100이하인 임의의 정수를 저장하여라.
		for(int index = 0; index < score.length; index++){
			score[index] = (int)(Math.random() * 101);
			System.out.println(score[index]);
		}
		
		
//		3. 변수 score에 저장된 요소들의 합계를 구하여라.
		int sum = 0;
		for(int index = 0; index < score.length; index++){
			sum += score[index];
		}
		System.out.println(sum);
		 
//		4. 변수 score에 저장된 요소들의 평균을 구하여라.
//		 단 소수점 세 번째 자리에서 반올림하여 두 번째 자리까지 표현하여라.
		float avr = (int)((float)sum / score.length * 100 + 0.5F) / 100F;
		System.out.println(avr);
		
//		5. 변수 socre에 저장된 요소에서 최댓값을 구하여라.
		int max = 0;
		for(int index = 0; index < score.length; index++){
			if(score[index] > max){
				max = score[index];
			}
		}
		System.out.println(max);
		
//		6. 변수 socre에 저장된 요소에서 최솟값을 구하여라.
		int min = 101;
		for(int index = 0; index < score.length; index++){
			if(score[index] < min){
				min = score[index];
			}
		}
		System.out.println(min);
//		7. 1~6번의 결과를 이용하여 결과와 같이 출력하여라.
//		 단. 임의의 정수값들의 연산임으로 결과는 다를 수 있음.
		System.out.print("score값 : {");
		for(int index = 0; index < score.length; index++){
			System.out.print(score[index]);
			if(index != score.length - 1){
				System.out.print(", ");				
			}
		}
		System.out.println(" }");
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avr);
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
	}
}
