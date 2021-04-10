package h_javaLang;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest_03 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "가나";
		byte[] strCP = str.getBytes("CP949");
		byte[] strMS = str.getBytes("MS949");
		byte[] strUT = str.getBytes("UTF-8");
		System.out.println(Arrays.toString(strCP));
		System.out.println(Arrays.toString(strMS));
		System.out.println(Arrays.toString(strUT));
	}
}
