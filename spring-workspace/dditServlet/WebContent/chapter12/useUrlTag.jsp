<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>url Tag 연습</title>
</head>
<body>
	<!-- URL 관련 태그								-->
	<!-- 1) c:redirect							-->
	<!-- 2)	c:url								-->
	<!--	→ URL을 생성해 줌						-->
	<!--	→ var								-->
	<!--		→ 읽어온 결과를 저장할 변수 명(String)	-->
	<!--	→ value								-->
	<!--		→ 읽어올 URL(String)				-->
	<!--	→ scope								-->
	<!--		→ 변수를 저장할 영역(String)			-->
	<c:url var="searchUrl" value="http://search.daum.net/search">
		<c:param name="w" value="blog"></c:param>
		<c:param name="q" value="공원"></c:param>
	</c:url>

	<ul>
		<li><a href="${searchUrl}" target="_blank">다음 블로그검색: 공원</a></li>
		<li><c:url value="../chapter12/userIfTag.jsp"></c:url></li>
		<li><c:url value="./useIfTag.jsp"></c:url></li>
	</ul>
</body>
</html>