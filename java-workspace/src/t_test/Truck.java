package t_test;

public class Truck extends Car{
	@Override
	public void method(){
		super.method();
		System.out.println("Truck class의 method()");
	}
}
