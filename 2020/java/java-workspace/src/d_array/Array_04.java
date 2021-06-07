package d_array;

public class Array_04 {
	public static void main(String[] args) {
		/*
		1. 다차원 배열
			- 자바에서는 1차원 배열 뿐만 아니라, 2차원 이상의 다차원 배열도 허용한다.
			- 2차원 배열의 선언 방법
				┌───────────┬───────────────────┬───────────────┐
				│    종류 	│      선언 방법		│     선언 예		│
				├───────────┼───────────────────┼───────────────┤
				│  일반 변수	│   변수타입 변수명;		│     int i;	│
				├───────────┼───────────────────┼───────────────┤
				│ 1차원 배열	│  변수타입[] 변수명;	│  int[] arr;	│
				├───────────┼───────────────────┼───────────────┤
				│ 2차원 배열	│ 변수타입[][] 변수명;	│ int[][] arr;	│
		     	└───────────┴───────────────────┴───────────────┘
		*/
//		int[][] arr = new int[2][3];
//		System.out.println(arr[0][0]);
//		System.out.println(arr[0][1]);
//		System.out.println(arr[0][2]);
//		System.out.println(arr[1][0]);
//		System.out.println(arr[1][1]);
//		System.out.println(arr[1][2]);
		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.println(arr[i][j]);
//			}
//		}
		
		int[][] apt = new int[3][];
		/*
		{
			null,
			null,
			null
		}
		*/
		apt[0] = new int[3];
//		System.out.println(arr[0][0]);
//		System.out.println(arr[0][1]);
//		System.out.println(arr[0][2]);
		
		apt[1] = new int[4];
		apt[2] = new int[2];
		
		
//		3. 우리반에서 6명의 친구 이름을 저장해주세요.
		String[] names = new String[]{"곽지훈", "구나은", "권민정", "길민선", "길정우", "김대순"};
		
//		4. 과목 7개를 저장해주세요.
		String[] subjects = new String[]{"국어", "영어", "수학", "사회", "과학", "HTML", "JAVA"};
		
//		1. 6명의 7과목의 점수를 저장할 수 있는 score를 선언 및 생성하여라.
		int[][] score = new int[names.length][subjects.length];
		
//		2. score의 각 방의 값을 0에서 100 사이의 임의의 값으로 초기화하여라.
		
		for (int name = 0; name < score.length; name++) {
			for (int subject = 0; subject < score[name].length; subject++) {
				score[name][subject] = (int)(Math.random()*101);
			}
		}
		
//		for (int name = 0; name < score.length; name++) {
//			int[] temp = new int[subjects.length + 1];
//			for (int subject = 0; subject < score[name].length; subject++) {
//				temp[subject] = score[name][subject];
//				temp[subjects.length] = 
//			}
//		}
		
//		사람 별 점수 합계
		int[] sum = new int[names.length];
		for (int name = 0; name < score.length; name++) {
			for (int subject = 0; subject < score[name].length; subject++) {
				sum[name] += score[name][subject];
			}
		}
		
//		사람 별 평균
//		소수점 세번째자리에서 두번째자리로 반올림
		float[] avr = new float[names.length];
		for (int name = 0; name < score.length; name++) {
			avr[name] = (int)((float)sum[name] / names.length * 100 + 0.5) / 100f;
		}
		
//		과목 별 합계
		int[] subSum = new int[subjects.length];
		for (int name = 0; name < score.length; name++) {
			for (int subject = 0; subject < score[name].length; subject++) {
				subSum[subject] += score[name][subject];
			}
		}
		
//		과목 별 평균
		float[] subAvr = new float[subjects.length];
		for (int subject = 0; subject < subjects.length; subject++) {
			subAvr[subject] = (int)((float)subSum[subject] / subjects.length * 100 + 0.5) / 100f;
		}
		
//		사람 별 석차
//		int[] sortSum = new int[names.length];
//		int[] rank = new int[names.length];
//		for (int name = 0; name < sum.length; name++) {
//			sortSum[name] = sum[name];
//			rank[name] = sum[name];
//		}
//		for (int name = 0; name < sortSum.length; name++) {
//			for (int i = 0; i < sortSum.length - name - 1; i++) {
//				if (sortSum[i] < sortSum[i + 1]) {
//					int temp = sortSum[i];
//					sortSum[i] = sortSum[i + 1];
//					sortSum[i + 1] = temp;
//				}
//			}
//		}
//		
//		for (int name = 0; name < sortSum.length; name++) {
//			for (int i = 0; i < rank.length; i++) {
//				if (sortSum[name] == rank[i]) {
//					rank[i] = name + 1;
//				}
//			}
//		}
		
//		int[] rank = new int[names.length];
//		int max = 700;
//		int rankNum = 0;
//		for (int i = 0; i < names.length; i++) {
//			int temp = 0;
//			for (int j = 0; j < names.length; j++) {
//				if (temp < sum[j] && sum[j] < max) {
//					temp = sum[j];
//				}
//			}
//			max = temp;
//			for (int j = 0; j < names.length; j++) {
//				if(max == sum[j]){
//					rank[j] = rankNum;
//				}
//			}
//			temp = 0;
//			for (int j = 0; j < names.length; j++) {
//				if (rank[j] == rankNum) {
//					temp++;
//				}
//			}
//			rankNum += temp;
//		}
		
//		int[] rank = new int[names.length];
//		for (int index = 0; index < names.length; index++) {
//			int max = 0;
//			int count = 0;
//			for (int i = 0; i < names.length; i++) {
//				if(rank[i] == 0){
//					if(max < sum[i]){
//						max = sum[i];
//					}
//					count++;
//				}
//			}
//			for (int i = 0; i < names.length; i++) {
//				if(max == sum[i]){
//					rank[i] = names.length - count +1;
//				}
//			}
//		}
		
//		int[] rank = new int[names.length];
//		int count = 0;
//		int number = 700;
//		while(count<names.length){
//			int temp = 0;
//			for (int i = 0; i < names.length; i++) {
//				if(sum[i] == number){
//					rank[i] = count + 1;
//					temp++;
//				}
//			}
//			count += temp;
//			number--;
//		}
		
		int[] rank = new int[names.length];
		for (int index = 0; index < names.length; index++) {
			for (int i = 0; i < names.length; i++) {
				if(sum[index] > sum[i]){
					rank[i]++;
				}
			}
			rank[index]++;
		}
		
//		
		
//		0. 출력
		for (int subject = 0; subject < subjects.length; subject++) {
			System.out.print("\t" + subjects[subject]);
		}
		System.out.println("\t합계\t평균\t석차");
		
		for (int name = 0; name < score.length; name++) {
			System.out.print(names[name] + "\t");
			for (int subject = 0; subject < score[name].length; subject++) {
				System.out.print(score[name][subject] + "\t");
			}
			System.out.println(sum[name] + "\t" + avr[name] + "\t" + rank[name]);
		}
		
		System.out.print("과목 합계");
		for (int subject = 0; subject < subjects.length; subject++) {
			System.out.print("\t" + subSum[subject]);
		}
		System.out.println();
		
		System.out.print("과목 평균");
		for (int subject = 0; subject < subjects.length; subject++) {
			System.out.print("\t" + subAvr[subject]);
		}
		System.out.println();
		
		
		for (int name = 0; name < names.length; name++) {
			for (int i = 0; i < names.length - name - 1; i++) {
				if(rank[i] > rank[i + 1]){
					String sTemp = names[i];
					names[i] = names[i + 1];
					names[i + 1] = sTemp;
					
					for (int j = 0; j < subjects.length; j++) {
						int iTemp = score[i][j];
						score[i][j] = score[i + 1][j];
						score[i + 1][j] = iTemp;
					}
					
					int iTemp1 = sum[i];
					sum[i] = sum[i + 1];
					sum[i + 1] = iTemp1;
					
					float fTemp = avr[i];
					avr[i] = avr[i + 1];
					avr[i + 1] = fTemp;
					
					int iTemp2 = rank[i];
					rank[i] = rank[i + 1];
					rank[i + 1] = iTemp2;
				}
			}
		}

		System.out.println("================================= sort 후 =================================================");
		for (int subject = 0; subject < subjects.length; subject++) {
			System.out.print("\t" + subjects[subject]);
		}
		System.out.println("\t합계\t평균\t석차");
		
		for (int name = 0; name < score.length; name++) {
			System.out.print(names[name] + "\t");
			for (int subject = 0; subject < score[name].length; subject++) {
				System.out.print(score[name][subject] + "\t");
			}
			System.out.println(sum[name] + "\t" + avr[name] + "\t" + rank[name]);
		}
		
		System.out.print("과목 합계");
		for (int subject = 0; subject < subjects.length; subject++) {
			System.out.print("\t" + subSum[subject]);
		}
		System.out.println();
		
		System.out.print("과목 평균");
		for (int subject = 0; subject < subjects.length; subject++) {
			System.out.print("\t" + subAvr[subject]);
		}
		System.out.println();

	}
}
