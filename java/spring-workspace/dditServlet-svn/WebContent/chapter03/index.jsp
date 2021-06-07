<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>로그인에 실패</title></head>
<body>
<h2>index.jsp 페이지입니다</h2>
<br />
<%
String name = request.getParameter("name")==null?"없습니다":request.getParameter("name");
%>
name은? <%=name%>
</body>
</html>
