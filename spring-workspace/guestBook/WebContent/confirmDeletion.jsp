<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");

String messageId = request.getParameter("messageId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메시지 삭제 확인</title>
<style type="text/css">
label {
	display: inline-block;
	width: 75px;
}
</style>
</head>
<body>
	<%
	if (messageId != null && messageId != "") {
	%>
	<form action="deleteMessage.jsp" method="post">
		<input type="hidden" name="messageId" value="<%=messageId%>" />
		<p>메시지를 삭제하시려면 비밀번호를 입력하세요.</p>
		<p>
			<label for="password">비밀번호</label><input type="password" id="password" name="password" required="required" />
		</p>
		<p>
			<input type="submit" value="메시지 삭제하기" />
		</p>
	</form>
	<%
	} else {
	%>
	<p>올바르지 못한 값입니다.</p>
	<%
	}
	%>
	<p>
		<input type="button" value="목록으로 이동" onclick="location.href='list.jsp'" />
	</p>
</body>
</html>
