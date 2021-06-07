<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<style type="text/css">
label {
	display: inline-block;
	width: 75px;
	text-align: center;
}
</style>
</head>
<body>
	<form action="" method="post">
		<p>
			<label for="articleNo">번호</label><input type="number" id="articleNo" name="articleNo" readonly="readonly" required="required" value="${modifyRequest.articleNo}" />
		</p>
		<p>
			<label for="title">제목</label><input type="text" id="title" name="title" value="${modifyRequest.title}" required="required" />
			<c:if test="${errors.title}">제목을 입력하세요.</c:if>
		</p>
		<p>
			<label for="content">내용</label>
			<textarea id="content" name="content" rows="5" cols="30" required="required">${modifyRequest.content}</textarea>
			<c:if test="${errors.content}">내용을 입력하세요.</c:if>
		</p>
		<input type="submit" value="글 수정" />
	</form>
</body>
</html>