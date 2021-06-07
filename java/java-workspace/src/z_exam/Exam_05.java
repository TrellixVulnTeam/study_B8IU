package z_exam;

public class Exam_05 {
	public static void main(String[] args) {
		/*
		[5-1] 다음은 배열을 선언하거나 초기화한 것이다. 잘못된 것을 고르고 그 이유를 설명하시오.
		
		① int[] arr[];
		② int[] arr = {1,2,3,};
		③ int[] arr = new int[5];
		④ int[] arr = new int[5]{1,2,3,4,5};
			인덱스의 크기를 지정하지 않아야 함
		⑤ int arr[5];
			arr의 크기는 초기화 시 설정
		⑥ int[] arr[] = new int[3][];
		*/
		
		/*
		[5-2] 다음과 같은 배열이 있을 때,
		    (1) arr[3].length의 값은 얼마인가?
		    (2) arr.length의 값은 얼마인가?
		    (3) System.out.println(arr[4][1])의 출력 결과는 얼마인가?
	    
	    int[][] arr = {
        { 5, 5, 5, 5, 5},
        { 10, 10, 10},
        { 20, 20, 20, 20},
        { 30, 30}
        };

		*/
		
	    int[][] arr_5_2 = {
	            { 5, 5, 5, 5, 5},
	            { 10, 10, 10},
	            { 20, 20, 20, 20},
	            { 30, 30}
	            };
	    
//	    (1) arr[3].length의 값은 얼마인가?
//	    	2
//	    (2) arr.length의 값은 얼마인가?
//	    	4
//	    (3) System.out.println(arr[4][1])의 출력 결과는 얼마인가?
//	    	java.lang.ArrayIndexOutOfBoundsException
		
	    System.out.println(arr_5_2[3].length);
	    System.out.println(arr_5_2.length);
//	    System.out.println(arr_5_2[4][1]);
	    
	    /*
	    [5-3] 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오.
	    
	    class Exercise5_3 {
	    public static void main(String[] args) {
	        int[] arr = {10, 20, 30, 40, 50};
	        int sum = 0;
	        
	        /*
	        (1)
	        * /
	        
	        System.out.println("Sum = "+sum);
		    }
		}
	    */
	    
        int[] arr_5_3 = {10, 20, 30, 40, 50};
        int sum_5_3 = 0;
        
        for(int index = 0; index < arr_5_3.length; index++){
        	sum_5_3 += arr_5_3[index];
	    }
        
        System.out.println("Sum = " + sum_5_3);
	    
	    /*
	    [5-4] 2차원 배열 arr에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 완성하시오.
		class Exercise5_4 {
		    public static void main(String[] args) {
		        int[][] arr = {
		                {5, 8, 13, 5, 2},
		                {22, 13, 28},
		                {2, 18, 23, 62}
		        };
		        int total = 0; // 합계를 저장하기 위한 변수
		        float average = 0; // 평균을 저장하기 위한 변수
		        /*
		        (1)
		        * /
		        System.out.println("total = " + total);
		        System.out.println("Average = " + average);
		    }
		}
	    */
	    
        int[][] arr_5_4 = {
                {5, 8, 13, 5, 2},
                {22, 13, 28},
                {2, 18, 23, 62}
        };
        int total_5_4 = 0;
//        합계를 저장하기 위한 변수
        float average_5_4 = 0;
//        평균을 저장하기 위한 변수
        
        for(int index1 = 0; index1 < arr_5_4.length; index1++){
        	for(int index2 = 0; index2 < arr_5_4[index1].length; index2++){
        		total_5_4 += arr_5_4[index1][index2];
        		average_5_4 += 1;
        	}
        }
        average_5_4 = total_5_4 / average_5_4;
        System.out.println("total = " + total_5_4);
        System.out.println("Average = " + average_5_4);
	    
	    /*
	    [5-5] 거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제이다.
			변수 money의 금액을 동전으로 바꾸었을 때 각각 몇 개의 동전이 필요한지 계산해서 출력하라.
			단, 가능한 한 적은 수의 동전으로 거슬러 주어야한다.
			(1)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
		class Exercise5_5 {
		    public static void main(String[] args) {
		        int[] coinUnit = { 500, 100, 50, 10 };
		        int money = 2790;
		        /*
		        (1)
		        * /
		    }
		}
	    */
        int[] coinUnit_5_5 = { 500, 100, 50, 10 };
        int money_5_5 = 2790;
        
	    for(int index = 0; index < coinUnit_5_5.length; index++){
	    	System.out.println(coinUnit_5_5[index] + "원 : " + (money_5_5 / coinUnit_5_5[index]) + "개");
	    	money_5_5 %= coinUnit_5_5[index];
	    }
	    
	    /*
	    [5-6] 다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램이다.
			※ 임의의 값을 사용했기 때문에 실행결과와 다를 수 있다.
		class Exercise5_6 {
		    public static void main(String[] args) {
		        int[] ballArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		        int[] ball3 = new int[3];
		        
		        // ballArr의 index순서대로 index의 요소와 임의의 요소를 골라서 값을 바꾼다.
		        
		        
		        
		        // ballArr의 앞에서 3개를 ball3로 복사한다.
		        
		        
		        // ball3의 값을 출력한다.
		        
		        
		    }
		}
	    */
	    
        int[] ballArr_5_6 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] ball3_5_6 = new int[3];
        
//		ballArr의 index순서대로 index의 요소와 임의의 요소를 골라서 값을 바꾼다.
        for(int index = 0; index < ballArr_5_6.length; index++){
        	int temp = ballArr_5_6[index];
        	int random = (int)(Math.random() * 9);
        	ballArr_5_6[index] = ballArr_5_6[random];
        	ballArr_5_6[random] = temp;
        }
        
//		ballArr의 앞에서 3개를 ball3로 복사한다.
        for(int index = 0; index < 3; index++){
        	ball3_5_6[index] = ballArr_5_6[index];
        }
        
//		ball3의 값을 출력한다.
	    for(int index = 0; index < ball3_5_6.length; index++){
	    	System.out.println(ball3_5_6[index]);
	    }
	    
	    /*
	    [5-7] 다음은 배열 answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 '*'을 찍어서 그래프를 그리는 프로그램이다.
		class Exercise5_7 {
		    public static void main(String[] args) {
		        int[] answer = { 1, 4, 3, 2, 1, 2, 3, 2, 1, 4 };
		        int[] counter = new int[4];
		        
		        // answer의 요소들 중 1이면 counter의 0번방을 증가, 2이면 counter의 1번방을 증가
		        // 3이면 counter의 2번방을 증가, 4이면 counter의 3번방을 증가.
		        
		        
		        
		        // couter에 저장된 요소를 결과와 같이 출력 하여라.
		        
		        
		        
		        // hide : answer의 값의 범위를 측정하여 최대 5개의 통계 만들기
		    }
		}
	    */
	    
        int[] answer_5_7 = { 1, 4, 3, 2, 1, 2, 3, 2, 1, 4 };
        int[] counter_5_7 = new int[4];
        
//		answer의 요소들 중 1이면 counter의 0번방을 증가, 2이면 counter의 1번방을 증가
//		3이면 counter의 2번방을 증가, 4이면 counter의 3번방을 증가.
        for(int index = 0; index < answer_5_7.length; index++){
        	counter_5_7[answer_5_7[index] - 1] += 1;
        }
        
        
//		couter에 저장된 요소를 결과와 같이 출력 하여라.
        for(int index = 0; index < counter_5_7.length; index++){
        	System.out.print(index + 1 + " : " + counter_5_7[index] + "개 ");
        	for(int count = 0; count < counter_5_7[index]; count++){
        		System.out.print("*");
        	}
        	System.out.println();
        }
        
        
//		hide : answer의 값의 범위를 측정하여 최대 5개의 통계 만들기
        int max_5_7 = answer_5_7[0];
        int min_5_7 = answer_5_7[0];
        int range = max_5_7 - min_5_7;
        int[] rangeCount = new int[5];
        for(int index = 0; index < answer_5_7.length; index++){
        	if(max_5_7 < answer_5_7[index]){
        		max_5_7 = answer_5_7[index];
        	} else if(min_5_7 > answer_5_7[index]){
        		min_5_7 = answer_5_7[index];
        	}
        }
        
        for (int i = 0; i < answer_5_7.length; i++) {
        	for (int j = 0; j < rangeCount.length; j++) {
        		if(min_5_7 + (int)(range * (float)(j + 1) / 5) <= answer_5_7[i] && answer_5_7[i] <= min_5_7 + (int)(range * (float)(j + 1) / 5)){
    				rangeCount[j]++;
    			}
			}
		}
        for(int index = 0; index < rangeCount.length; index++){
        	System.out.print(min_5_7 + (int)(range / 5f * (index + 1)) + " ~ " + (min_5_7 + (int)(range / 5f * (index + 1))) + " : " + rangeCount[index] + "개 ");
        	for(int count = 0; count < rangeCount[index]; count++){
        		System.out.print("*");
        	}
        	System.out.println();
        }
	    
        /*
        [5-8] 문제 5-5에 동전의 개수를 추가한 프로그램이다.
        	커맨드라인으로부터 거슬러 줄 금액을 입력받아 계산한다.
        	보유한 동전의 개수로 거스름돈을 지불할 수 없으면, '거스름돈이 부족합니다.'라고 출력하고 종료한다.
        	지불할 돈이 충분히 있으면, 거스름돈을 지불한 만큼 가진 돈에서 빼고 남은 동전의 개수를화면에 출력한다.
        	(1)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
        class Exercise5_8 {
            public static void main(String[] args) {
                if(args.length!=1){
                    System.out.println("한개의 숫자만 입력해 주세요.");
                    System.exit(0);
                }
                // 문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
                int money = Integer.parseInt(args[0]);
                System.out.println("money="+money);
                int[] coinUnit = { 500, 100, 50, 10 } ; // 동전의 단위
                int[] coin = { 5, 5, 5, 5 } ; // 단위별 동전의 개수
                
                for(int i=0;i<coinUnit.length;i++) {
                    int coinNum = 0;
                    /* (1) 아래의 로직에 맞게 코드를 작성하시오.
                    1. 금액(money)을 동전단위로 나눠서 필요한 동전의 개수(coinNum)를 구한다.
                    2. 배열 coin에서 coinNum만큼의 동전을 뺀다.
                    (만일 충분한 동전이 없다면 배열 coin에 있는 만큼만 뺀다.)
                    3. 금액에서 동전의 개수(coinNum)와 동전단위를 곱한 값을 뺀다.
                    * /
                    System.out.println(coinUnit[i]+"원: "+coinNum);
                }

                if(money > 0) {
                    System.out.println("거스름돈이 부족합니다.");
                    System.exit(0); // 프로그램을 종료한다.
                }

                System.out.println("=남은 동전의 개수 =");
                for(int i=0;i<coinUnit.length;i++) {
                    System.out.println(coinUnit[i]+"원:"+coin[i]);
                }
            }
        }
        */
        if(args.length!=1){
            System.out.println("한개의 숫자만 입력해 주세요.");
            System.exit(0);
        }
        // 문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
        int money = Integer.parseInt(args[0]);
        System.out.println("money=" + money);
        int[] coinUnit = { 500, 100, 50, 10 } ; // 동전의 단위
        int[] coin = { 5, 5, 5, 5 } ; // 단위별 동전의 개수
        
        for(int i = 0; i < coinUnit.length; i++) {
            int coinNum = 0;
//          1. 금액(money)을 동전단위로 나눠서 필요한 동전의 개수(coinNum)를 구한다.
            coinNum = money / coinUnit[i];
//          2. 배열 coin에서 coinNum만큼의 동전을 뺀다.
//          (만일 충분한 동전이 없다면 배열 coin에 있는 만큼만 뺀다.)
            if(coinNum > coin[i]){
            	coinNum = coin[i];
            }
            coin[i] -= coinNum;
//          3. 금액에서 동전의 개수(coinNum)와 동전단위를 곱한 값을 뺀다.
            money -= coinNum * coinUnit[i];
            System.out.println(coinUnit[i] + "원: " + coinNum);
        }

        if(money > 0) {
            System.out.println("거스름돈이 부족합니다.");
            System.exit(0);
//          프로그램을 종료한다.
        }

        System.out.println("=남은 동전의 개수 =");
        for(int i=0;i<coinUnit.length;i++) {
            System.out.println(coinUnit[i] + "원:" + coin[i]);
        }
	    
        /*
		[5-9] 주어진 배열을 시계방향으로 90도 회전시켜서 출력하는 프로그램을 완성 하시오.
		class Exercise5_9 {
		    public static void main(String[] args) {
		        char[][] star = {
		                {'*','*',' ',' ',' '},
		                {'*','*',' ',' ',' '},
		                {'*','*','*','*','*'},
		                {'*','*','*','*','*'}
		        };
		        char[][] result = new char[star[0].length][star.length];
		
		        for(int i=0; i < star.length;i++) {
		            for(int j=0; j < star[i].length;j++) {
		                System.out.print(star[i][j]);
		            }
		            System.out.println();
		        }
		        System.out.println();
		
		        for(int i=0; i < star.length;i++) {
		            for(int j=0; j < star[i].length;j++) {
		                /*
		                (1) 알맞은 코드를 넣어 완성하시오.
		                * /
		            }
		        }
		        
		        for(int i=0; i < result.length;i++) {
		            for(int j=0; j < result[i].length;j++) {
		                System.out.print(result[i][j]);
		            }
		            System.out.println();
		        }
		    }
		}
		*/
        
        char[][] star = {
                {'*','*',' ',' ',' '},
                {'*','*',' ',' ',' '},
                {'*','*','*','*','*'},
                {'*','*','*','*','*'}
        };
        char[][] result = new char[star[0].length][star.length];

        for(int i=0; i < star.length;i++) {
            for(int j=0; j < star[i].length;j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        for(int i=0; i < star.length;i++) {
            for(int j=0; j < star[i].length;j++) {
            	result[j][star.length - 1 - i] = star[i][j];
            }
        }
        
        for(int i=0; i < result.length;i++) {
            for(int j=0; j < result[i].length;j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
	}
}
