package qu3;

public class Qu3_9 {
    public static void main(String[] args) {
        // 6. doubleDice메서드를 호출 하여라.
    	int result = Qu3_9.doubleDice();
    	
        // 7. 총 이동거리를 출력하여라.
        // 예를 들어 주사위 값이 (3,3)이 나오게 되면 한 번 더 던질 수 있는 기회가 주어
        // 지며 두 번째 던진 주사위 값이 (5.2)가 되었다면 총 이동거리는 13이 된다.
    	System.out.println(result);
    }

    static int doubleDice() {
        // 1. 첫 번째 주사위 : 1~6사이의 임의의 정수를 변수 firstDice에 저장하여라.
    	int firstDice = (int)(Math.random() * 6 + 1);
    	
        // 2. 두 번째 주사위 : 1~6사이의 임의의 정수를 변수 secondDice에 저장하여라.
    	int secondDice = (int)(Math.random() * 6 + 1);
    	
        // 3. 두 주사위의 합을 변수 result에 저장하여라.
    	int result = firstDice + secondDice;
    	
        // 4. 만일 두 주사위의 값이 같다면 주사위 두개를 한 번 더 던지도록 하여라.
    	if (firstDice == secondDice) {
    		result += doubleDice();
    	}
    	
        // 5. 전체 주사위 값의 합을 반환 하여라.
    	return result;
    }
}