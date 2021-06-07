<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String nowPage = request.getParameter("pageNo");
%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 목록</title>
</head>
<body>
<c:set var="nowPage" value="<%=nowPage%>" />

<table border="1" style="width:100%;">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>조회수</th>
</tr>
<c:if test="${articlePage.hasNoArticles()}">
<tr>
	<td colspan="4">게시글이 없습니다</td>
</tr>
</c:if>
<!-- =============== 목록 출력 시작 ======================= -->
<c:forEach var="article" items="${articlePage.content}" varStatus="status">
<tr>
	<td>${article.articleNo}</td>
	<td>
		<a href="read.do?no=${article.articleNo}&pageNo=${articlePage.currentPage}">
		${article.title}
		</a>
	</td>
	<td>${article.writer.writerName}</td>
	<td>${article.readCnt}</td>
</tr>
</c:forEach>
<!-- =============== 목록 출력 끝 ======================= -->
<!-- =============== 페이징 처리 시작 ======================= -->
<c:if test="${articlePage.hasArticles()}">
<tr style="text-align:center;">
	<td colspan="4">
		<c:if test="${articlePage.startPage > 5}">
		<a href="list.do?pageNo=${articlePage.startPage - 5}">[이전]</a>
		</c:if>
		<c:forEach var="pNo" begin="${articlePage.startPage}" end="${articlePage.endPage}">
			<c:if test="${pNo==nowPage}"><c:set var="varBold" value="font-weight:bolder;color:blue;" /></c:if>
			<c:if test="${pNo!=nowPage}"><c:set var="varBold" value="" /></c:if>
			<a href="list.do?pageNo=${pNo}" style="text-decoration:none;cursor:pointer;${varBold}">[${pNo}]</a>
		</c:forEach>
		<c:if test="${articlePage.endPage < articlePage.totalPage}">
		<a href="list.do?pageNo=${articlePage.startPage + 5}">[다음]</a>
		</c:if>
	</td>
</tr>
</c:if>
<!-- =============== 페이징 처리 끝 ======================= -->
</table>

</body>
</html>



