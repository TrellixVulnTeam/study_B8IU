<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%
String job = request.getParameter("job");
String memId = request.getParameter("memId");
String memPass = request.getParameter("memPass");

if ("student".equals(job) && "a001".equals(memId) && "1234".equals(memPass)) {
	String memName = "김은대";
	session.setAttribute("memId", memId);
	session.setAttribute("memName", memName);
	response.sendRedirect("home.jsp");
} else {
%>
<script>
	alert("로그인 실패!");
	history.go(-1);
</script>
<%
}
%>
