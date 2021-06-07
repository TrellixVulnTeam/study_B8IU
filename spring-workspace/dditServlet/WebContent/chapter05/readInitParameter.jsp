<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초기화 파라미터 읽어오기</title>
</head>
<body>
	초기화 파라미터 목록
	<br />
	<%
	//"Enumeration(이뉴머레이션)"은 열거형 데이터(배열로 이해하셔도 됨)로
	//"cursor(커서)"의 위치를 통해 객체를 반환합니다.
	Enumeration<String> initParamEnum = application.getInitParameterNames();
	while (initParamEnum.hasMoreElements()) {
		String initParamName = initParamEnum.nextElement();
		out.print(initParamName + " = ");
		out.println(application.getInitParameter(initParamName) + "<br/>");
	}
	%>
</body>
</html>