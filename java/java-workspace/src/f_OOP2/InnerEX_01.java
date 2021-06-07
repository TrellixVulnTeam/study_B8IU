package f_OOP2;

public class InnerEX_01 {
	public static void main(String[] args) {
		System.out.println(InnerEX_01.StaticInner.cv);
		
		InnerEX_01.StaticInner staticInner = new InnerEX_01.StaticInner();
		System.out.println(staticInner.iv);
		
		InnerEX_01 innerEX_01 = new InnerEX_01();
		
		InnerEX_01.InstanceInner instanceInner = innerEX_01.new InstanceInner();
		System.out.println(instanceInner.iv);
		System.out.println(InnerEX_01.InstanceInner.CCC);
		
		
	}
	
//	static 클래스
	static class StaticInner {
		static int cv = 300;
		int iv = 200;
	}
	
//	Instance 클래스
//	밖에 있는 클래스가 인스턴스화 되어야만 접근 가능
	class InstanceInner {
//		InstanceInner가 인스턴스화 되어야만 접근 가능
		int iv = 50;
//		static int cv = 20;
		static final int CCC = 90;
	}
	
	void method() {
		class LocalInner {
			int iv = 200;
//			static int cv = 60;
		}
	}
}
