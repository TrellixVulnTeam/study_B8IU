<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품분류 정보 목록</title>
<script type="text/javascript">
function fn_Login(){
	//"요청경로",
	window.open("/member/login"	,"oWin", "width=300,height=300,left=100,top=100,scrollbars=no, tollbar=no, location=no, resizable=no, status=no, menubar=no")
}
</script>
</head>
<body>
	<h1>상품분류 정보 목록</h1>
	<input type="button" value="로그인" onclick="fn_Login()"> <!-- onclick="location.href='/member/login'" -->
	<table border="1" style="width: 50%">
		<thead>
			<tr>
				<th>상품분류 번호</th>
				<th>상품분류 코드</th>
				<th>상품분류 명</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${lprodListVo}">
				<tr>
					<td><a href="/detail?lprodId=${row.lprodId}&updateGu=success">${row.lprodId}</a></td>
					<td>${row.lprodGu}</td>
					<td>${row.lprodNm}</td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan="3" style="text-align: right;">
						<input type="button" value="신규입력" onclick="location.href='create'"> 
					</td>
				</tr>
		</tbody>
	</table>
</body>
</html>