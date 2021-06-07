package e_oop;

public class CardTest {
	public static void main(String[] args) {
//		1. Card 클래스의 너비를 출력해주세요.
		System.out.println(Card.width);
//		2. Card 클래스의 높이를 출력해주세요.
		System.out.println(Card.height);
		
//		3. Card 클래스의 객체를 만들어주세요. ( cd1 )
		Card cd1 = new Card();
		
//		4. cd1의 문양을 Heart로 변경해주세요.
		cd1.kind = "heart";
		System.out.println(cd1.kind);
		
//		5. cd1의 숫자를 7로 변경해주세요.
		cd1.number = 7;
		System.out.println(cd1.number);
		
//		6. Card 클래스의 객체를 만들어주세요. ( cd2 )
		Card cd2 = new Card();
		
//		7. cd2의 문양을 SPADE로 변경해주세요.
		cd2.kind = "spade";
		System.out.println(cd2.kind);
		
//		8. cd2의 숫자를 3로 변경해주세요.
		cd2.number = 3;
		System.out.println(cd2.number);
		
//		9. 아래와 같이 출력해주세요.
//		cd1의 모양 : xx, 숫자 : xx, 너비 : xx, 높이 : xx
		System.out.println("cd1의 모양 : " + cd1.kind + ", 숫자 : " + cd1.number + ", 너비 : " + cd1.width + ", 높이 : " + cd1.height);
//		cd2의 모양 : xx, 숫자 : xx, 너비 : xx, 높이 : xx
		System.out.println("cd2의 모양 : " + cd2.kind + ", 숫자 : " + cd2.number + ", 너비 : " + cd2.width + ", 높이 : " + cd2.height);
		
//		10. cd1의 너비를 70으로 변경해주세요.
		cd1.width = 70;
		
//		11. cd1의 높이를 90으로 변경해주세요.
		cd1.height = 90;
		
//		12. 아래와 같이 출력해주세요.
//		cd1의 모양 : xx, 숫자 : xx, 너비 : xx, 높이 : xx
		System.out.println("cd1의 모양 : " + cd1.kind + ", 숫자 : " + cd1.number + ", 너비 : " + cd1.width + ", 높이 : " + cd1.height);
//		cd2의 모양 : xx, 숫자 : xx, 너비 : xx, 높이 : xx
		System.out.println("cd2의 모양 : " + cd2.kind + ", 숫자 : " + cd2.number + ", 너비 : " + cd2.width + ", 높이 : " + cd2.height);
	}
}

class Card{
//	인스턴스 변수
	String kind; 
	int number;
	
//	클래스 변수
	static int width = 100;
	static int height = 250;
	
	void method(){
//		지역변수
		int v = 3;
	}
	
	static void method2(){
		
	}
	
}