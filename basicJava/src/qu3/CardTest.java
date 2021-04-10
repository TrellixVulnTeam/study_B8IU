package qu3;

public class CardTest {
    public static void main(String[] args) {
        // 1. Card클래스의 폭을 출력하여라.
    	System.out.println(Card.width);
    	
        // 2. Card클래스의 높이를 출력하여라.
    	System.out.println(Card.heigh);
    	
        // 3. Card클래스의 객체를 생성해 주세요. 변수명 : cd1
    	Card cd1 = new Card();
    	
        // 4. 변수 cd1의 이름을 "Daniel"로 변경하여라.
    	cd1.name = "Daniel";
    	
        // 5. 변수 cd1의 직원 번호를 "19961210"로 변경하여라.
    	cd1.number = 19961210;
    	
        // 6. Card클래스의 객체를 생성해 주세요. 변수명 : cd2
    	Card cd2 = new Card();
    	
        // 7. 변수 cd2의 이름을 "nayeon"로 변경하여라.
    	cd2.name = "nayeon";
    	
        // 8. 변수 cd2의 직원 번호를 "19950922"로 변경하여라.
    	cd2.number = 19950922;
    	
        // 9. 결과의 출력1과 같이 출력하여라.
    	System.out.println("1번 카드의 이름은 " + cd1.name + ", 직원번호 " + cd1.number + ", 폭은 " + cd1.width + ", 높이는 " + cd1.heigh + "이다.");
    	System.out.println("2번 카드의 이름은 " + cd2.name + ", 직원번호 " + cd2.number + ", 폭은 " + cd2.width + ", 높이는 " + cd2.heigh + "이다.");
        
    	// 10. Card클래스의 폭을 70으로 변경하여라.
    	Card.width = 70;
    	
        // 11. Card클래스의 높이를 100으로 변경하여라.
    	Card.heigh = 100;
    	
        // 12. 결과의 출력2와 같이 출력하여라.
    	System.out.println("1번 카드의 이름은 " + cd1.name + ", 직원번호 " + cd1.number + ", 폭은 " + cd1.width + ", 높이는 " + cd1.heigh + "이다.");
    	System.out.println("2번 카드의 이름은 " + cd2.name + ", 직원번호 " + cd2.number + ", 폭은 " + cd2.width + ", 높이는 " + cd2.heigh + "이다.");
    }
}

class Card {
    String name; // 이름
    int number; // 직원번호
    static int width = 100; // 폭
    static int heigh = 250; // 높이
}