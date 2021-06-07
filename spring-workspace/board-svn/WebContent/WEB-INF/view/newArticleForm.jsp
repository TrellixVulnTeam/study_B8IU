<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 쓰기</title>
</head>
<body>
<form name="frm" id="frm" method="post" action="write.do">
<p>
	제목 : <br /><input type="text" name="title" value="" />
	<c:if test="${errors.title}">제목을 입력하세요</c:if>
</p>
<p>
	내용 : <br />
	<textarea name="content" rows="5" cols="30"></textarea>
</p>
<input type="submit" value="새글 등록" />
</form>
</body>
</html>

