package f_OOP2;

public class InstanceofTest_01 {
	public static void main(String[] args) {
		FireCar fc = new FireCar();
		
		if (fc instanceof FireCar) {
			System.out.println("fc는 Car의 인스턴스이다.");
			FireCar ff = fc;
		}
		
		if (fc instanceof Car) {
			System.out.println("fc는 Car의 인스턴스이다.");
			Car c = fc;
		}
		
		if (fc instanceof Object) {
			System.out.println("fc는 Object의 인스턴스이다.");
			Object ob = fc;
		}
		
		Car c = new Car();
		
		if (c instanceof FireCar) {
			System.out.println("c는 FireCar의 인스턴스이다.");
			FireCar ff = (FireCar)c;
		}
		
		if (c instanceof Car) {
			System.out.println("c는 Car의 인스턴스이다.");
		}
		
		Car cc = new FireCar();
		System.out.println(cc.a);
		System.out.println(cc.b);
		cc.stop();
		cc.drive();
	}
}

class Car {
	static int a = 20;
	int b = 30;
	
	static void stop() {
		System.out.println("끼익~!");
	}
	
	void drive() {
		System.out.println("부릉~!");
	}
}

class FireCar extends Car {
	static int a = 50;
	int b = 70;
	
	static void stop() {
		System.out.println("소방차 끼익~!");
	}
	
	void drive() {
		System.out.println("소방차 부릉~!");
	}
}
