<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id") == null ? "" : request.getParameter("id");
String password = request.getParameter("password") == null ? "" : request.getParameter("password");

if (id.equals("a001") && password.equals("1234")) {
	session.setAttribute("id", id);
	session.setAttribute("password", password);
	session.setAttribute("name", "개똥이");
	out.println("<script>location.href='index.jsp'</script>");
} else{
	out.println("<script>alert('로그인 실패!')</script>");
	out.println("<script>history.back()</script>");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>