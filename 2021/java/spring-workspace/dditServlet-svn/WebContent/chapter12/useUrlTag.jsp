<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>use Url tag</title>
</head>
<body>
<!-- 
URL관련 태그
1) c:redirect
2) c:url => URL을 생성해줌
   -> var : 읽어온 결과를 저장할 변수 명(String)
   -> value : 읽어올 URL(String)
   -> scope : 변수를 저장할 영역(String)
 -->
<c:url var="searchUrl" value="http://search.daum.net/search">
	<c:param name="w" value="blog" />
	<c:param name="q" value="공원" />
</c:url>

<ul>
	<li><a href="${searchUrl}" target="_blank">다음공원 블로그 검색</a></li>
	<li><c:url value="/chapter12/useIfTag.jsp" /></li>
	<li><c:url value="./useIfTag.jsp" /></li>
</ul>

</body>
</html>



