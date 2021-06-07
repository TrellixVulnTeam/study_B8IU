<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL의 수치 연산자</title>
</head>
<body>
	숫자의 경우 자바 연산자와 동일한 방법으로 사용됨
	<br />
	<br />문자열을 비교할 경우 String.compareTo() 메서드를 사용.
	<br />
	<%
	String str = new String("2021");
	pageContext.setAttribute("str", str);
	%>
	str == "2021"의 결과는? ${str == "2021"}
	<br />이 코드는 someValue.compareTo("2021") == 0과 같은 의미임.
	<br />
	<br />str eq "2021"의 결과는? ${str eq "2021"}
	<br />str.compareTo("2021") == 0의 결과는? ${str.compareTo("2021") == 0}
	<br />
</body>
</html>