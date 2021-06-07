<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Map<String, Object> mapData = new HashMap<>();

mapData.put("name", "개똥이");
mapData.put("today", new Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach Tag 연습</title>
</head>
<body>
	<c:set var="intArray" value="<%=new int[] { 1, 2, 3, 4, 5 }%>"></c:set>
	<c:set var="map" value="<%=mapData%>"></c:set>

	<h4>int형 배열</h4>
	<!-- var																-->
	<!--	→ 사용할 EL 변수(String)											-->
	<!-- items																-->
	<!--	→ 반복 처리할 데이터 (Collection, Iterator, Enumeration, Map, 배열)	-->
	<!-- begin																-->
	<!--	→ 시작 인덱스 값(int)												-->
	<!-- end																-->
	<!--	→ 끝 인덱스 값(int)													-->
	<!-- varStatus															-->
	<!--	→ loop 상태를 저장할 EL 변수 명(String)								-->
	<!-- step																-->
	<!--	→ 인덱스 증분 값(int)												-->
	<c:forEach var="i" items="${intArray}" begin="1" end="4" varStatus="status">
		<p>${status.index}-${status.count}-[${i}]</p>
	</c:forEach>

	<hr />

	<h4>Map</h4>
	<c:forEach var="i" items="${map}" varStatus="status">
		<p>${status.index}:${status.count}:${i.key}=${i.value}</p>
	</c:forEach>

	<hr />

	<h4>구구단: 7단</h4>
	<ul>
		<c:forEach var="i" begin="1" end="9">
			<li>7 × ${i} = ${7 * i}</li>
		</c:forEach>
	</ul>

	<hr />

	<h4>1부터 100까지의 홀수의 합</h4>
	<c:set var="sum" value="0"></c:set>
	<c:forEach var="i" begin="1" end="100" step="2">
		<c:set var="sum" value="${sum + i}"></c:set>
	</c:forEach>
	<p>결과: ${sum}</p>
</body>
</html>