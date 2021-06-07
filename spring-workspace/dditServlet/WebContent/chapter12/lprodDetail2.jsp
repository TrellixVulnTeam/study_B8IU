<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="chapter12.LprodVO"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%
Map<String, String> map = new HashMap<String, String>();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보 상세정보 보기(Map)</title>
</head>
<body>
	<!-- target									-->
	<!--	→ property 값을 설정할 객체를 지정(Object)	-->
	<!-- property								-->
	<!--	→ 속성명(String)						-->
	<!-- value									-->
	<!--	→ 변수에 할당할 값(Object)				-->
	<!-- scope									-->
	<!--	→ 변수를 생성할 영역. 기본값은 page(String)	-->
	<!-- val									-->
	<!--	→ EL 변수 명(String)					-->
	<c:set target="<%=map%>" property="lprodId" value="1"></c:set>
	<c:set target="<%=map%>" property="lprodGd" value="P101"></c:set>
	<c:set target="<%=map%>" property="lprodNm" value="컴퓨터제품"></c:set>

	<table border="1" style="width: 100%; cellpadding: 0px; cellspacing: 0px;">
		<tr>
			<th>상품분류번호</th>
			<th>상품분류코드</th>
			<th>상품분류명</th>
		</tr>
		<tr>
			<td><%=map.get("lprodId")%></td>
			<td><%=map.get("lprodGd")%></td>
			<td><%=map.get("lprodNm")%></td>
		</tr>
	</table>
</body>
</html>