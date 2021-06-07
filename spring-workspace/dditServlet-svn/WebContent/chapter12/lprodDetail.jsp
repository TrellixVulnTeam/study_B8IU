<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="chapter12.lprodVO"%>
<%
	lprodVO vo = new lprodVO();
%>
<!DOCTYPE html>
<html>
<head>
<title>상품분류 상세정보 보기</title>
</head>
<body>
<c:set var="m" value="<%=vo%>" scope="request" />
<c:set target="${m}" property="lprodId" value="1" />
<c:set target="${m}" property="lprodGu" value="P101" />
<c:set target="${m}" property="lprodNm" value="컴퓨터제품" />

<table border="1" style="width:100%;cellpadding:0px;cellspacing:0px;">
	<tr>
		<th>상품분류번호</th>
		<th>상품분류코드</th>
		<th>상품분류명</th>
	</tr>
	<tr>
		<td>${m.lprodId}</td>
		<td>${m.lprodGu}</td>
		<td>${m.lprodNm}</td>
	</tr>
</table>



</body>
</html>




