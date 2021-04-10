package f_OOP2;

public class OverTest {
	public static void main(String[] args) {
		OverGo og = new OverGo();
		String result = og.upMethod();
		System.out.println(result);
		
		String result2 = og.upMethod1();
		System.out.println(result2);
	}
}

class OverUp {
	String upMethod(){
		return "OverUpMethod";
	}
}

class OverGo extends OverUp {
	@Override
	String upMethod(){
		return "OverGoMethod";
	}
	
	String upMethod(int a) {
		return a + "OverGo";
	}
	
	String upMethod1() {
		return super.upMethod();
	}
}
