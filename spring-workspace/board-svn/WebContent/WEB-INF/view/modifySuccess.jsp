<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 수정</title>
</head>
<body>
<!-- modifySuccess.jsp -->
게시글을 수정했습니다.<br />
${ctxPath = pageContext.request.contextPath ; ''}
<a href="${ctxPath}/article/list.do">[게시글 목록보기]</a>
</body>
</html>