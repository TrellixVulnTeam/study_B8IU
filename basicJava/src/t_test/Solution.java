package t_test;

import java.util.Arrays;

public class Solution {
	public String solution(String[] participant, String[] completion) {
		
		String answer = "";
//		결과를 저장할 String 타입의 변수 선언

		Arrays.sort(participant);
		Arrays.sort(completion);
//		두 배열 정렬

        for (int i = 0; i < participant.length; i++) {
//        	participant의 길이만큼 수행하는데,
//        	participant은 completion보다 1 길게 입력 됨
//        	만약 i의 최대값을 completion의 길이를 기준으로 산정한다면,
//        	participant의 마지막 요소에 도달하지 않아 완주하지 못한 선수를 찾을 수 없음
        	
            if (completion.length == i) {
//            	그래서 completion를 마지막 회전에 돌리면 에러가 발생하기 때문에,
//            	i와 길이가 같아지면 에러가 발생하고,
//            	participant는 배열의 마지막 요소에 도달함.
                answer = participant[i];
                break;
//              participant 배열의 마지막 요소와 일치하는  요소가 존재할 수 없어 마지막 요소 반환
                
            } else {
                if (!participant[i].equals(completion[i])) {
//                	participant의 i번째 요소와 completion의 i번째 요소가 일치하지 않으면 수행
                    answer = participant[i];
//                  둘이 일치하지 않으면 participant의 i번째 요소는 완주하지 못한 경우
//                  따라서 participant의 i번째 요소  반환
                    break;
                }
            }
		}
		return answer;
	}
}