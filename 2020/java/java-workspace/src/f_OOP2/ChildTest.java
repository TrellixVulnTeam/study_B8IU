package f_OOP2;

public class ChildTest {
	public static void main(String[] args) {
		Child ch = new Child();
		
		ch.volume = 10;
		System.out.println(ch.volume);
//		출력 : 10
		
		ch.volumeUp();
		System.out.println(ch.volume);
//		출력 : 11
		
		ch.channel = 15;
		System.out.println(ch.channel);
//		출력 : 15
		
		ch.channelUp();
		System.out.println(ch.channel);
//		출력 : 15
	}
}

class Parents {
	int channel;
	void channelUp(){
		channel++;
	}
}

class Child extends Parents {
	int volume;
	int channel;
	void volumeUp() {
		volume++;
	}
}