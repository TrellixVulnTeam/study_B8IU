<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//application 기본 객체에 설정할 속성 이름으로 사용할 파라미터를 읽어옴
String name = request.getParameter("name") == null ? "ddit" : request.getParameter("name");
//application 기본 객체에 설정할 속성값으로 사용할 파라미터를 읽어옴
String value = request.getParameter("value") == null ? "java" : request.getParameter("value");

if (name != null && value != null) {
	//application 기본 객체에 속성을 설정함. 파라미터로 전달받은 값을 속성 이름과 값으로 사용함
	application.setAttribute(name, value);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 속성 지정</title>
</head>
<body>
	<%
	if (name != null && value != null) {
	%>
	application 기본 객체의 속성 설정 :
	<%=name%>
	=
	<%=value%>
	<%
	} else {
	%>
	application 기본 객체의 속성 설정 안 함
	<%
	}
	%>
</body>
</html>