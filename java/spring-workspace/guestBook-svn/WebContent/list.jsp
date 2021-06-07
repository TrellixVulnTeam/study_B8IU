<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="guestbook.service.GetMessageListService"%>
<%@page import="guestbook.model.Message"%>
<%@page import="java.util.List"%>
<%@page import="guestbook.service.MessageListView"%>
<%
	String pageNumberStr = request.getParameter("page");
	int pageNumber = 1;
	if(pageNumberStr!=null){
		pageNumber = Integer.parseInt(pageNumberStr);
	}

	GetMessageListService messageListService = GetMessageListService.getInstance();
// 	List<Message> viewData = messageListService.getMessageList(1);
	MessageListView viewData = messageListService.getMessageList(pageNumber);
%>
<c:set var="viewData" value="<%=viewData%>" />
<!DOCTYPE html>
<html>
<head>
<title>방명록 메시지 목록</title>
</head>
<body>

<form name="frm" id="frm" method="post" action="writeMessage.jsp">
이름 : <input type="text" name="guestName"  /><br />
비밀번호 : <input type="password" name="password"  /><br />
메시지 : <textarea name="message" cols="30" rows="3"></textarea><br />
<input type="submit" value="메시지 남기기" />
</form>
<hr />
<!-- 메시지가 없는 경우 -->
<c:if test="${viewData.isEmpty()}">
등록된 메시지가 없습니다.
</c:if>
<!-- 메시지가 있는 경우 -->
<c:if test="${!viewData.isEmpty()}">
<table border="1" style="width:50%;">
<c:forEach var="message" items="${viewData.messageList}">
<tr>
	<td>
	메시지 번호 : ${message.id}<br />
	손님 이름 : ${message.guestName}<br />
	메시지 : ${message.message}<br />
	<a href="confirmDeletion.jsp?messageId=${message.id}">[삭제하기]</a>
	</td>
</tr>
</c:forEach>
</table>
</c:if>
<!-- 페이지 목록 출력 -->
<c:forEach var="pageNum" begin="1" end="${viewData.pageTotalCount}">
<a href="list.jsp?page=${pageNum}">[${pageNum}]</a>
</c:forEach>

</body>
</html>









