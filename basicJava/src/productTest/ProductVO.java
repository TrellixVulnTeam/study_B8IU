package productTest;

public class ProductVO {
	private String name;
	private int price;
	private int count;
	private int mileage;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	protected ProductVO(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
		this.mileage = (int)(price * 0.05);
	}
	
	public static ProductVO insert(String name, int price, int count) {
		return new ProductVO(name, price, count);
	}
}
