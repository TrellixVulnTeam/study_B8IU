<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 쓰기</title>
<style type="text/css">
label {
	display: inline-block;
	width: 50px;
	text-align: center;
}
</style>
</head>
<body>
	<form action="" method="post">
		<p>
			<label for="title">제목</label>
			<c:if test="${errors.titleEmpty}">제목을 입력하세요.</c:if>
		</p>
		<p>
			<input type="text" id="title" name="title" value="" />
		</p>
		<p>
			<label for="content">내용</label>
			<c:if test="${errors.contentEmpty}">내용을 입력하세요.</c:if>
		</p>
		<p>
			<textarea id="content" name="content" rows="5" cols="30"></textarea>
		</p>
		<p>
			<input type="submit" value="새 글 등록" />
		</p>
	</form>
</body>
</html>