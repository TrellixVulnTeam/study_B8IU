package i_reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx_01 {
	public static void main(String[] args) {
		/*
		1. 정규식이란?
			- 텍스트 데이터 중에서 원하는 조건과 일치하는 문자열을 찾기 위해 만들어졌다.
			- 정규식의 구성
				: Pattern 클래스를 이용하여 정규식을 정의한다.
				: Matcher 클래스를 이용하여 데이터를 비교한다.
		*/
		Pattern pattern = Pattern.compile("[a-z]*");
		Matcher matcher = pattern.matcher("asdf");
		System.out.println(matcher.matches());
		
		/*		
		^ 문자열의 시작
		$ 문자열의 끝
		. 임의의 한 문자. 단, \ 제외.
		* 앞 문자가 없을 수도, 무한정 있을 수도 있다.
		+ 앞 문자가 한 문자 이상 포함.
		? 앞 문자가 없거나 하나
		[] 문자의 집합이나 범위를 표현한다. [^ ] not의 의미
		{} 횟수 또는 범위를 나타낸다. {}
		() 소괄호 안의 문자를 하나의 문자로 인지
		| 패턴 안에서 or의 의미를 가진다. (010|016)
		
		\s 공백 문자
		\S 공백을 제외한 모든 문자
		\w 영문자 또는 숫자 [a-zA-Z0-9]
		\d 숫자 [0-9] \\d
		*/
		
		//1. 영어 소문자 2개 또는 3개로 이루어진 정규식
		Pattern pattern1 = Pattern.compile("[a-z]{2,3}");
		Matcher matcher1 = pattern1.matcher("ri");
		System.out.println(matcher1.matches());
		
		String regEx01 = "[a-z]{2,3}";
		System.out.println(Pattern.matches(regEx01, "adfs"));
		
		//2. 영문자가 3회 나온 후 숫자가 없을 수도, 무제한 있을 수도 있다.
		Pattern pattern2 = Pattern.compile("[a-zA-Z]{3}[0-9]*");
		Matcher matcher2 = pattern2.matcher("rir123");
		System.out.println(matcher2.matches());
		
		
		//3. 숫자3개 - 숫자 4개 - 숫자 4개
		Pattern pattern3 = Pattern.compile("[0-9]{3}-[0-9]{4}-[0-9]{4}");
		Matcher matcher3 = pattern3.matcher("010-1234-5678");
		System.out.println(matcher3.matches());
		
		//4. 010 - 0이 올 수 없다. 숫자 3개 - 숫자 4개
		//	011
		//	016
		//	017
		//	018
		//	019
		Pattern pattern4 = Pattern.compile("01([01]|[6-9])-[1-9][0-9]{3}-[0-9]{4}");
		Matcher matcher4 = pattern4.matcher("019-0234-5678");
		System.out.println(matcher4.matches());
		
		//5. 주민등록번호
		// 숫자2개 0 1-9 0 1-9 - 1-4 숫자6자리
		//		 1 0-2 1 0-9
		//		 	   2 0-9
		//		 	   3 0-1
		String regEx05 = "[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])-[1-4][0-9]{6}";
		System.out.println(Pattern.matches(regEx05, "970905-1234567"));
		
		//6. 이메일 주소
		/*
		pgsk0927@gmail.com
		1. 영문자로 시작
		2. 영문자 또는 숫자 특수문자(-_.\)
		3. @이후에 영문자 또는 숫자가 3 ~ 7자가 올 수 있다.
		4. .이후에 영문자 또는 숫자가 2 ~ 3자가 올 수 있다.
		5. .kr이 올 수도 있다.
		*/
		String regEx06 = "[a-zA-Z][a-zA-Z0-9_-]+@[a-zA-Z0-9]{3,7}.[a-zA-Z0-9]{2,3}(.[a-zA-Z0-9]{2,3})?";
		System.out.println(Pattern.matches(regEx06, "ririnto@kakao.co.kr"));
		
		String text = "야이 개나리 십장생아 이런 조카신발 같은 경우를 봤나..";
		
		String result = filter(text);
		
		System.out.println(result);
	}

	private static String filter(String text) {
		Pattern p = Pattern.compile("개나리|십장생|조카신발|병일신", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(text);
		
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String group = m.group();
			String re = maskword(group);
			m.appendReplacement(sb, re);
		}
		m.appendTail(sb);
		return sb.toString();
	}

	private static String maskword(String group) {
//		개나리 → 개♡♡
		char[] gg = group.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < gg.length; i++) {
			if (i==0) {
				sb.append(gg[i]);
			} else {
				sb.append("♡");
			}
		}
		
		return sb.toString();
	}
}
