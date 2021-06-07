package t_test;

public class Solution_ex {
	public static void main(String[] args) {
		Solution st = new Solution();
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		String result = st.solution(participant, completion);
		System.out.println(result);
		
		participant = new String[]{"leo", "kiki", "eden"};
		completion = new String[]{"eden", "kiki"};
		result = st.solution(participant, completion);
		System.out.println(result);
		
		participant = new String[]{"1", "2", "3", "2"};
		completion = new String[]{"1", "2", "2"};
		result = st.solution(participant, completion);
		System.out.println(result);
	}
}
