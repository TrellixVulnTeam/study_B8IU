<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="guestbook.service.GetMessageListService"%>
<%@ page import="guestbook.service.MessageListView"%>
<%@ page import="guestbook.model.Message"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String pageNumberStr = request.getParameter("page");
int pageNumber = 1;
try {
	if (pageNumberStr != null) {
		pageNumber = Integer.valueOf(pageNumberStr);
	}
} catch (NumberFormatException ex) {
	ex.printStackTrace();
}

GetMessageListService getMessageListService = GetMessageListService.getInstance();
MessageListView messageListView = getMessageListService.getMessageList(pageNumber);
List<Message> viewData = messageListView.getMessageList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메시지 목록</title>
<style type="text/css">
label {
	display: inline-block;
	width: 75px;
	text-align: center;
}

table {
	border: 3px double black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<div style="border: 3px double black; display: inline-block; padding: 5px;">
		<form method="post" action="writeMessage.jsp">
			<p>
				<label for="name">이름</label><input type="text" id="name" name="guestName" required="required" />
			</p>
			<p>
				<label for="password">비밀번호</label><input type="password" id="password" name="password" required="required" />
			</p>
			<p>
				<label for="message">메시지</label>
				<textarea cols="30" rows="3" id="message" name="message" required="required"></textarea>
			</p>
			<p>
				<input type="submit" value="메시지 남기기" />
			</p>
		</form>
	</div>
	<hr />
	<c:choose>
		<c:when test="<%=viewData == null%>">
			<p>오류 발생!</p>
		</c:when>
		<c:when test="<%=messageListView.isEmpty()%>">
			<p>방명록에 글이 없습니다.</p>
		</c:when>
		<c:otherwise>
			<table border="1" style="width: 50%;">
				<c:forEach var="message" items="<%=viewData%>">
					<tr>
						<td>
							<p>메시지 번호: ${message.messageId}</p>
							<p>손님 이름: ${message.guestName}</p>
							<p>메시지: ${message.message}</p>
							<p>
								[<a href="confirmDeletion.jsp?messageId=${message.messageId}">삭제하기</a>]
							</p>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<c:forEach var="pageNum" begin="1" end="<%=messageListView.getPageTotalCount()%>">
		[<a href="list.jsp?page=${pageNum}">${pageNum}</a>]
	</c:forEach>
</body>
</html>
