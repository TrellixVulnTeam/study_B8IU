<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<p>글을 수정했습니다.</p>
	<p>
		<a href="read.do?pageNum=${param.pageNum}&articleNo=${param.articleNo}">수정한 글 보기</a>
	</p>
	<p>
		<a href="list.do?pageNum=${param.pageNum}">목록으로 이동하기</a>
	</p>
</body>
</html>