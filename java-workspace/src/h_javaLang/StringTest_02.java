package h_javaLang;

import java.util.Arrays;

public class StringTest_02 {
	public static void main(String[] args) {
//		char charAt(int index)
//			: 문자열에서 지정된 index번째 문자 하나를 돌려준다.
		
		String s = "Hello";
		char ch = s.charAt(2);
		System.out.println(ch);
		
//		oracle 에서도 사용되는 것
//		String concat(String str)
//			: 기존 문자열에 새로운 문자열을 덧붙인다.
		String s2 = s.concat(" jQuery");
		System.out.println(s2);
		
//		boolean contains();
//			: 기존 문자열에 해당 문자열을 포함하고 있는지 확인한다. 
		boolean s3 = s2.contains("jQ");
		System.out.println(s3);
		
//		확장자 처리에 필요한 것
//		boolean endswith(String str)
//			: 문자열이 str로 끝나는지 확인한다.
		String s4 = "은서가 외로워하고 있어요. 미라야 ~~!.hwp";
		boolean re = s4.endsWith(".hwp");
		System.out.println(re);
		
//		그 외
//		1. lastIndexOf()
//			: 지정된 문자 또는 문자코드 문자열의 오른쪽 끝에서부터 찾아서 그 위치를 반환한다.
//			: 문자가 없다면, -1을 반환한다.
		System.out.println(s2.lastIndexOf("k"));
		
//		2. replace(String oldStr, String newStr)
//			: 기존 문자열을 새로운 문자열로 변환
		String s5 = s2.replace("jQuery", "Java");
		System.out.println(s5);
		
//		3. String[] split(구분자)
//			: 문자열을 지정한 구문자로 나누어 문자열형 배열에 저장한다.
		String s6 = "100,,,200,,300,400";
		String[] sArr = s6.split(",,");
		System.out.println(Arrays.toString(sArr));
		
//		4. String subString(int start, int end)
//			: 주어진 문자열을 시작부터 끝 위치 범위에 있는 포함된 문자열을 얻는다.
		String s7 = s5.substring(2, 6);
		System.out.println(s7);
		
//		5. String trim()
//			: 주어진 문자열 양 끝의 공백을 제거해준다.
		String s8 = "     eun   seo     ";
		String s9 = s8.trim();
		System.out.println(s9);
	}
}
