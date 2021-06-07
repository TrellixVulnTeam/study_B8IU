<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 읽기(readArticle.jsp)</title>
</head>
<body>
<a href="/board/login.do" target="_blank">로그인</a><br />
<table border="1" style="width:100%;">
<tr>
	<th>번호</th><td>${articleData.article.articleNo}</td>
</tr>
<tr>
	<th>작성자</th><td>${articleData.article.writer.writerName}</td>
</tr>
<tr>
	<th>제목</th><td>${articleData.article.title}</td>
</tr>
<tr>
	<th>내용</th><td>${articleData.content}</td>
</tr>
<tr>
	<td colspan="2">
<%-- 	<c:set var="pageNo" value="${param.pageNo}" /> --%>
	<a href="list.do?pageNo=${param.pageNo}">[목록]</a>
	<c:if test="${authUser.id==articleData.article.writer.writerId}">
		<a href="modify.do?no=${articleData.article.articleNo}">[게시글수정]</a>
		<a href="delete.do?no=${articleData.article.articleNo}">[게시글삭제]</a>
	</c:if>
	</td>
</tr>
</table>
로그인 : ${authUser.id} / 글쓴이 : ${articleData.article.writer.writerId}
</body>
</html>








