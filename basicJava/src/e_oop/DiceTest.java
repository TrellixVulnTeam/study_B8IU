package e_oop;

public class DiceTest {
	public static void main(String[] args) {
//		2. throwDice 메서드를 호출
		DoubleDice doubleDice = new DoubleDice();
		int result = doubleDice.throwDice();
		System.out.println("모든 주사위의 합 : " + result);
//		3. JVM 3-3, 4-4, 3-1
	}
}

class DoubleDice{
//	1. 주사위 두 개를 던져서 그 합을 반환하는 throwDice 메서드를 만들어주세요.
//		단, 두 개의 주사위가 같으면 한번 더 던진다.
	int throwDice(){
		int firstDice = (int)(Math.random() * 6 + 1);
		int secondDice = (int) (Math.random() * 6 + 1);
		System.out.println("첫 번째 주사위 : " + firstDice + ", 두 번째 주사위 : " + secondDice);
		
		int result = firstDice + secondDice;
		if (firstDice == secondDice) {
			result += throwDice();
		}
		return result;
	}
}