package productTest;

import java.util.Vector;

public class UserVO {
	private String name;
	private int money;
	private int mileage;
	private Vector<ProductVO> buyList = new Vector<ProductVO>();
	
	public Vector<ProductVO> getBuyList() {
		return buyList;
	}

	public void setBuyList(Vector<ProductVO> buyList) {
		this.buyList = buyList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	private UserVO(String name, int money, int mileage) {
		this.name = name;
		this.money = money;
		this.mileage = mileage;
	}
	
	public static UserVO insert(String name, int money, int mileage) {
		return new UserVO(name, money, mileage);
	}
}
