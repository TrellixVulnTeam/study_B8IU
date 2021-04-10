package h_javaLang;

import java.util.StringTokenizer;

public class StringTokenizer_01 {
	public static void main(String[] args) {
		String text = "100,,,200,,300,400";
		
		String[] textArr = text.split("0,");
		for (int i = 0; i < textArr.length; i++) {
			System.out.println(textArr[i]);
		}
		System.out.println("==================================");
		
		StringTokenizer stringTokenizer = new StringTokenizer(text, "0,");

		while (stringTokenizer.hasMoreTokens()) {
			System.out.println(stringTokenizer.nextToken());
			
		}
		
		
		
	}
}
