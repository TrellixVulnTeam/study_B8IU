package f_OOP2;

public class SuperTest_01 {

}

class Parent2 {
	int x = 10;
	int y = 20;
	
	int getAdd() {
		return x + y;
	}
}

class Child2 extends Parent2 {
	int x = 30;
	int z = 40;
	
	int getAdd(int x){
		System.out.println(x);
		System.out.println(this.x);
		System.out.println(super.x);
		
		return getAdd();
	}
}
