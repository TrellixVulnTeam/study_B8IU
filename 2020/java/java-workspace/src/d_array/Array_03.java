package d_array;

public class Array_03 {
	public static void main(String[] args) {
		/*
		1. 정렬(sort)
			- 여러 데이터를 빠르고 쉽게 찾기 위해 일정한 순서대로 데이터를 가지런히 나열하는 작업이다.
			- 버블정렬, 선택정렬, 삽입정렬
		*/
		
		/*
		2. 버블 정렬(bubble sort)
			- 인접한 데이터 간의 교환이 계속해서 일어나면서 정렬이 이루어진다.
			- 가장 큰 값이 맨 뒤에 위치한다.
		*/
		
//		1. 5개의 정수 5, 2, 3, 1, 4를 변수 sortNum에 저장해주세요.
		int[] sortNum = {5, 2, 3, 1, 4};
		
//		2. 버블 정렬을 이용하여 정렬해주세요.
		System.out.print("초기값 : [");
		for(int index = 0; index < sortNum.length; index++){
			if (index != sortNum.length - 1){
				System.out.print(sortNum[index] + ", ");
			} else{
				System.out.print(sortNum[index]);
			}
		}
		System.out.println("]");
		
//		2-1. sortNum의 0번방이 sortNum의 1번 방보다 크면 자리를 바꿔라.
//		if(sortNum[0] > sortNum[1]){
//			int temp = sortNum[0];
//			sortNum[0] = sortNum[1];
//			sortNum[1] = temp;
//		}
//		2-2. sortNum의 값을 출력하여라.
//		for(int index = 0; index < sortNum.length; index++){
//			System.out.print(sortNum[index]);
//		}
//		System.out.println();
//		
//		if(sortNum[1] > sortNum[2]){
//			int temp = sortNum[1];
//			sortNum[1] = sortNum[2];
//			sortNum[2] = temp;
//		}
//		for(int index = 0; index < sortNum.length; index++){
//			System.out.print(sortNum[index]);
//		}
//		System.out.println();
//		
//		if(sortNum[2] > sortNum[3]){
//			int temp = sortNum[2];
//			sortNum[2] = sortNum[3];
//			sortNum[3] = temp;
//		}
//		for(int index = 0; index < sortNum.length; index++){
//			System.out.print(sortNum[index]);
//		}
//		System.out.println();
//		
//		if(sortNum[3] > sortNum[4]){
//			int temp = sortNum[3];
//			sortNum[3] = sortNum[4];
//			sortNum[4] = temp;
//		}
//		for(int index = 0; index < sortNum.length; index++){
//			System.out.print(sortNum[index]);
//		}
//		System.out.println();
		
		for(int index = 1; index < sortNum.length; index++){
//			회전
			System.out.println("-----");
			System.out.println(index + "회전");
			for(int count = 1; count < sortNum.length - index + 1; count++){
//				버블
				if(sortNum[count-1] > sortNum[count]){
					int temp = sortNum[count-1];
					sortNum[count-1] = sortNum[count];
					sortNum[count] = temp;
				}
				for(int i = 0; i < sortNum.length; i++){
					if(i == 0){
						System.out.print("[" + sortNum[i]);
					} else if(i != sortNum.length - 1){
						System.out.print(", " + sortNum[i]);						
					} else {
						System.out.print(", " + sortNum[i]);
					}
				}
				System.out.println("]");
			}
		}
		
		/*
		3. 선택 정렬(select sort)
			- 
		
		
		
		
		*/
		
//		1. 최솟값 찾기
//		1-1. 최솟값의 방번호 찾기
//		2. 기준방과 최솟값 바꾸기
		int sort[] = new int[] {5, 2, 3, 1, 4};
		
		System.out.print("초기값 : [");
		for(int index = 0; index < sort.length; index++){
			if (index != sort.length - 1){
				System.out.print(sort[index] + ", ");
			} else{
				System.out.print(sort[index]);
			}
		}
		System.out.println("]");
		
		
		
		for (int index = 0; index < sort.length - 1; index++) {
			int[] min = new int[]{sort[index], index};
//			index, num
			
			for(int i = index + 1; i < sort.length; i++) {
				if(min[0] > sort[i]){
					min = new int[]{sort[i], i};
				}
			}
			System.out.println("min : " + min[0] + ", index : " + min[1]);
			
			
			int temp = sort[index];
			sort[index] = min[0];
			sort[min[1]] = temp;
			
			for(int i = 0; i < sort.length; i++){
				if(i == 0){
					System.out.print("[" + sort[i]);
				} else if(i != sort.length - 1){
					System.out.print(", " + sort[i]);						
				} else {
					System.out.print(", " + sort[i]);
				}
			}
			System.out.println("]");
		} 
		
	}
}
