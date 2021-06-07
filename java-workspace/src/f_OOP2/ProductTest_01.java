package f_OOP2;

import java.util.Vector;

public class ProductTest_01 {
	public static void main(String[] args) {
		Computer computer = new Computer(200, "삼보");
		HandPhone handPhone = new HandPhone(100, "iPhone");
		Styler styler = new Styler(400, "LG");
		
		Buyer buyer = new Buyer("신민경", 1000);
		
		buyer.buy(styler);
		buyer.buy(handPhone);
		
		buyer.summary();
		buyer.refund(styler);
		buyer.refund(computer);
		buyer.refund(handPhone);
		buyer.refund(computer);
	}
}

class Product {
	int price;
	String name;
	int mileage;
	
	public Product(int price, String name) {
		this.price = price;
		this.name = name;
		mileage = (int)(price * 0.05);
	}
}

class Computer extends Product {
	public Computer(int price, String name) {
		super(price, name);
	}

	@Override
	public String toString() {
		return "Computer";
	}
}

class HandPhone extends Product {
	public HandPhone(int price, String name) {
		super(price, name);
	}

	@Override
	public String toString() {
		return "HandPhone";
	}
}

class Styler extends Product {
	public Styler(int price, String name) {
		super(price, name);
	}

	@Override
	public String toString() {
		return "Styler";
	}
}

class Buyer {
	String name;
	int money;
	int mileage;
	
	Vector item = new Vector();
	
	public Buyer(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	void buy(Product p) {
		if(money < p.price){
			System.out.println("나가세요.");
			return;
		}
		
		money -= p.price;
		mileage += p.mileage;
		item.add(p);
		System.out.println(p + " 상품을 구매하셨습니다. 감사합니다.");
	}
	
//	summary()
/*		영	수	증
	
	구매내역
		Styler 400만원
		Styler 400만원
		Handphone	200만원
		합계	1000만원
		
		xx 고객님의 남은 돈은 xx만원이고, 마일리지는 xx만원입니다.
		호갱님 감사합니다. */
	void summary() {
		System.out.println();
		System.out.println("\t영\t수\t증");
		System.out.println();
		System.out.println("구매 내역");
		if (item.isEmpty()) {
			System.out.println("\t구매하신 내역이 없습니다.");
		} else {
			int spend = 0;
			for (int i = 0; i < item.size(); i++) {
				System.out.println("\t" + item.get(i) + "\t" + ((Product)item.get(i)).price + "만원");
				spend += ((Product)item.get(i)).price;
			}
			System.out.println();
			System.out.println("합계\t" + spend + "만원");
		}
		
		System.out.println();
		if (money > 0) {
			System.out.print(name + " 고객님의 남은 돈은 " + money + "만원이고, 마일리지는 ");
		} else {
			System.out.print(name + " 고객님의 남은 돈은 " + money + "원이고, 마일리지는 ");
		}
		if(mileage > 0) {
			System.out.println(mileage + "만원 입니다.");
		} else {
			System.out.println(mileage + "원 입니다.");
		}
	}
	
//	반품 refund()
/*	
	1. 물건을 구매한 적이 없는 경우
	2. 자신이 구매한 물건인 경우에만 반품이 가능
	*/
	void refund(Product p) {
		
		if (item.size() == 0) {
			System.out.println();
			System.out.println("손님께서는 이 매장에서 구입하신 내역이 없습니다.");
			return;
		}
		
		if (!item.remove(p)) {
			System.out.println();
			System.out.println("손님께서는 이 매장에서 " + p + "를 구매하시지 않으셨습니다.");
			return;
		}
		
		System.out.println();
		System.out.println(p + "를 반품합니다.");
		
		money += p.price;
		mileage -= p.mileage;
		
		if (money > 0) {
			System.out.print(name + " 고객님의 남은 돈은 " + money + "만원이고, 마일리지는 ");
		} else {
			System.out.print(name + " 고객님의 남은 돈은 " + money + "원이고, 마일리지는 ");
		}
		if(mileage > 0) {
			System.out.println(mileage + "만원 입니다.");
		} else {
			System.out.println(mileage + "원 입니다.");
		}
	}
}
