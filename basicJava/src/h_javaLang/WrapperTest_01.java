package h_javaLang;

public class WrapperTest_01 {
	public static void main(String[] args) {
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println(i1 == i2);
		System.out.println(i1.equals(i2));
		System.out.println(i1);
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Integer.SIZE);
		
		//JDK 1.8
		//Integer.BYTES
		
		Integer[] iArr = new Integer[3];
		iArr[0] = new Integer(100);
		iArr[1] = new Integer(200);
		iArr[2] = 300; // auto-boxing
		
		Integer i3 = iArr[1];
		int i4 = iArr[2]; //unBoxing
		
		Object[] obj = new Object[1];
		obj[0] = 10;
		int i5 = (int)obj[0];
	}
}
