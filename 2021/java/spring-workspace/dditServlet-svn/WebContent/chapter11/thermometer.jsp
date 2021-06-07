<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="chapter11.Thermometer" %>
<%
	Thermometer thermometer = new Thermometer();
	request.setAttribute("t", thermometer);
	
// 	thermometer.setCelsius("대전", 23.0);
%>
<!DOCTYPE html>
<html>
<head>
<title>온도 변환 예제</title>
</head>
<body>
<!-- thermometer.jsp -->
	${t.setCelsius("대전",23.0)}
	대전 온도 : 섭씨 ${t.getCelsius("대전")}도 / 화씨 ${t.getFahrenheit("대전")}
	<br />
	정보 : ${t.getInfo()} 

</body>
</html>




