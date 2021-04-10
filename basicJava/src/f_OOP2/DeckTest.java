package f_OOP2;

import java.util.Arrays;

public class DeckTest {
	public static void main(String[] args) {
//		8. 카드 한벌을 만들어주세요.
//			변수명 : d
		Deck d = new Deck();
		System.out.println(Arrays.toString(d.c));
		
//		9. d에서 0번째 카드를 가져오세요.
//			method 활용
		Card result1 = d.pick(0);
		System.out.println(result1);
		
//		10. d에서 임의의 카드를 한 장 꺼내주세요.
//			method 활용
		Card result2 = d.pick();
		System.out.println(result2);
		
//		11. d를 섞어주세요.
		d.shuffle();
		
//		11-5. d에서 0번째 카드를 가져오세요.
//			method 활용
		Card result3 = d.pick(0);
		System.out.println(result3);
		
//		12. d를 1000번 섞어주세요.
		d.shuffle(1000);
		
//		12-5. d에서 0번째 카드를 가져오세요.
//			method 활용
		Card result4 = d.pick(0);
		System.out.println(result4);
		
//		13. JVM 그려주세요.
	}
}

class Card {
//	카드 무늬 수
	static final int KIND_MAX = 4;
//	무늬 별 카드 수
	static final int NUM_MAX = 13;
	
	static final int SPADE = 1;
	static final int DIAMOND = 2;
	static final int HEART = 3;
	static final int CLOVER = 4;
	
	int kind;
	int number;
	
	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	Card() {
		this(SPADE, 1);
	}
	
	@Override
	public String toString() {
		String kind = "";
		String number = "";
		
		switch (this.kind) {
		case 1:
			kind = "SPADE";
			break;
		case 2:
			kind = "DIAMOND";
			break;
		case 3:
			kind = "HEART";
			break;
		case 4:
			kind = "CLOVER";
			break;
		}
		
		switch (this.number) {
		case 1:
			number = "A";
			break;
		case 11:
			number = "J";
			break;
		case 12:
			number = "Q";
			break;
		case 13:
			number = "K";
			break;
		default:
			number += this.number;
			break;
		}
		
		return kind + " : " + number;
	}
}

class Deck {
//	1. 카드의 수량을 저장할 수 있는 변수, CARD_NUM을 Card 클래스의 상수를 이용하여 초기화해주세요.
	static final int CARD_NUM = Card.KIND_MAX * Card.NUM_MAX;
	
//	2. 카드를 CARD_NUM만큼 저장해주세요.
//		변수명 : c
	Card[] c = new Card[CARD_NUM];
	
//	3. 기본 생성자를 만들어주세요.
//		단, 기본생성자 내에서 C의 모든 방을 카드로 채워주세요.
	Deck() {
		for (int index = 0; index < c.length; index++) {
			c[index] = new Card(index / Card.NUM_MAX + 1, index % Card.NUM_MAX + 1);
		}
	}
	
//	4. c에서 인자값으로 받은 번째방의 카드 한장을 반환해주세요.
//		메서드명 : pick
	Card pick(int index) {
		Card result = c[index];
		return result;
	}
	
//	5. c에서 임의의 방번째 카드 한 장을 반환해주세요.
//		단, 4번의 pick 메서드를 활용해주세요.
//		메서드명 : pick
	Card pick() {
		int random = (int)(Math.random() * CARD_NUM);
		Card result = pick(random);
		return result;
	}
	
//	6. 카드를 섞어주세요.
//		단, 연습문제 5-6번을 활용해주세요.
//		메서드명 : shuffle
	void shuffle() {
		for (int index = 0; index < c.length; index++) {
			int random = (int)(Math.random() * CARD_NUM);
			Card cTemp = c[index];
			c[index] = c[random];
			c[random] = cTemp;
		}
	}
	
//	7. 카드를 섞어주세요.
//		단, 인자값으로 받은 횟수만큼 반복해주세요.
//		임의의 방의 카드와 또다른 임의의 방의 카드를 바꿔주세요.
//		메서드명 : shuffle
	void shuffle(int count) {
		for (int i = 0; i < count; i++) {
			int random1 = (int)(Math.random() * CARD_NUM);
			int random2 = (int)(Math.random() * CARD_NUM);
			Card cTemp = c[random1];
			c[random1] = c[random2];
			c[random2] = cTemp;
		}
	}
}
