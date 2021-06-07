<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.HashMap"%>
<%
	HashMap<String, Object> mapData = new HashMap<String, Object>();
	mapData.put("name", "개똥이");
	mapData.put("today", new java.util.Date());
%>
<!DOCTYPE html>
<html>
<head>
<title>foreach tag연습</title>
</head>
<body>
<c:set var="intArray" value="<%=new int[]{1,2,3,4,5}%>" />
<c:set var="map" value="<%=mapData%>" />

<h4>1부터 100까지 홀수의 합</h4>
<c:set var="sum" value="0" />
<c:forEach var="i" begin="1" end="100" step="2">
	<c:set var="sum" value="${sum + i}" />
<%-- 	${sum = sum + i} --%>
</c:forEach>
결과 = ${sum}<br />

<h4>구구단 : 7단</h4>
<ul>
<c:forEach var="i" begin="1" end="9">
	<li>7 x ${i} = ${7 * i}</li>
</c:forEach>
</ul>


<h4>Map</h4>
<c:forEach var="i" items="${map}" varStatus="status">
	${status.index} : ${status.count} : ${i.key} = ${i.value}<br />
</c:forEach>

<h4>int형 배열</h4>
<!-- 
var : 사용할 EL 변수(String)
items : 반복 처리할 데이터 (Collection, Iterator, Enumeration, Map, 배열)
begin : 시작 인덱스 값(int)
end : 끝 인덱스 값(int)
varStatus : loop 상태를 저장할 EL 변수 명(String)
step : 인덱스 증분 값(int)
 -->
<c:forEach var="i" items="${intArray}" begin="0" end="4" varStatus="status">
	${status.index} - ${status.count} - [${i}] <br />
</c:forEach>
</body>
</html>
