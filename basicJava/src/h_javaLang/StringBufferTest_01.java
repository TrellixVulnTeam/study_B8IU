package h_javaLang;

public class StringBufferTest_01 {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("a");
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 300000000; i++) {
			str.append("a");
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
	}
}
