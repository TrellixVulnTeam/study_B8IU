<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="chapter11.Thermometer"%>
<%
Thermometer thermometer = new Thermometer();
request.setAttribute("thermometer", thermometer);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온도 변환 예제</title>
</head>
<body>
	<p>
		정보<br />→ ${thermometer.getInfo()}
	</p>

	<hr />

	<p>
		${thermometer.addCelsius("대전", 23.0)}대전 온도<br />→ ${thermometer.getCelsius("대전")} ºC (${thermometer.getFahrenheit("대전")} ºF)
	</p>
</body>
</html>