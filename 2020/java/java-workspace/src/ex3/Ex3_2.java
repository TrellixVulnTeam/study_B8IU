 package ex3;

public class Ex3_2 {
    public static void main(String[] args) {
        //Tv인스턴스를 참조하기 위한 변수 t를 선언
    	Tv t;
    	
        //Tv인스턴스를 생성 후 참조변수 t에 저장
    	t = new Tv();
    	
        //Tv인스턴스의 멤버변수 channel의 값을 7로 변경
    	t.channel = 78;
    	
        //Tv인스턴스의 메서드 channelDown()를 호출
        t.channelDown();
        
        System.out.println("현재 채널은 " + t.channel + "입니다.");
    }
}

class Tv {
	//String형 인스턴스 변수 color 선언
	String color;
	
	//boolean형 인스턴스 변수 power 선언
	boolean power;
	
	//int형 인스턴스 변수 channel 선언
	int channel;

    void power() { // 전원을 켜고 끄는 메서드
        power = !power;
    }

    void channelUp() { // 채널을 하나 증가시키는 메서드
        channel++;
    }

    void channelDown() { // 채널을 하나 감소시키는 메서드
        channel--;
    }
}
