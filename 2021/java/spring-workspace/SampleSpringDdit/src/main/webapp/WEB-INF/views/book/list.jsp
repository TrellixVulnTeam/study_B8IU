<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록</title>
<style type="text/css">
table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}

.text-center {
	text-align: center;
}

.text-right {
	text-align: right;
}
</style>
</head>
<body>
	<h1>책 목록</h1>
	<p>
		<form>
			<input type="text" placeholder="검색" name="keyword" value="${keyword}" /> <input type="submit" value="검색" />
		</form>
	</p>
	<table border="1">
		<thead>
			<tr>
				<th>제목</th>
				<th>카테고리</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${data}">
				<tr>
					<td class="text-center"><a href="detail?bookId=${row.BOOK_ID}">${row.TITLE}</a></td>
					<td class="text-center">${row.CATEGORY}</td>
					<td class="text-right"><fmt:formatNumber type="number" maxFractionDigits="3" value="${row.PRICE}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="create">생성</a>
	</p>
</body>
</html>