<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%
String memId =request.getParameter("memId");//a001
String memPass =request.getParameter("memPass"); //1234
%>


<%
String value = "김은대";
// String encodeval = URLEncoder.encode(value,"UTF-8");
if(memId.equals("a001") && memPass.equals("1234")){
// 	response.sendRedirect("/dditServlet/chapter03/home.jsp?name="+encodeval);
	session.setAttribute("userId", "a001");
	session.setAttribute("userName", value);
	response.sendRedirect("/dditServlet/chapter03/home.jsp");
}else{
%>
   <script type="text/javascript">
   	alert("login fail");
   	location.href = "/dditServlet/chapter03/loginTest.jsp";
   	</script>;
<%
	//alert창이 뜨지 않음
	//response.sendRedirect("/dditServlet/chapter03/loginTest.jsp");
}
%>
</body>
</html>