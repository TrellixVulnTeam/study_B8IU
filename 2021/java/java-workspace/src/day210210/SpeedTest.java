package day210210;

import java.util.Calendar;

public class SpeedTest {
	public static void main(String[] args) {
		long now1 = Calendar.getInstance().getTimeInMillis();
		Solution solution = new Solution();
		solution.solution(10000);
		long now2 = Calendar.getInstance().getTimeInMillis();
		System.out.println(now2 - now1);
	}
}

class Solution {
    public void solution(int n) {
    	StringBuffer sb = new StringBuffer("");
        for(int i = 0; i<n; i++){
            if(i%2==0){
                sb.append("수");
            }
            else{
                sb.append("박");
            }
            System.out.println(sb);
        }
    }
}