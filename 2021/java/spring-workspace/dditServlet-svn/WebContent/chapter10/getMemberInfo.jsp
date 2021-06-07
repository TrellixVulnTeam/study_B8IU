<%@ page contentType = "text/html; charset=UTF-8" %>
<%
	//초단위(30분)
	session.setMaxInactiveInterval(60*30);

	String memberId = (String)session.getAttribute("MEMBERID");
	String name = (String)session.getAttribute("NAME");
%>
<html>
<head><title>저장된 세션의 정보 확인</title></head>
<body>
회원Id : <%=memberId%>
<br />
회원이름 : <%=name%>
<br />
<a href="./setMemberInfo.jsp">되돌아가기</a>
</body>
</html>