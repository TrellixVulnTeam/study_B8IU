<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ page import="java.net.URLEncoder" %>
<%
 String value = "자바";
 String encodedValue = URLEncoder.encode(value,"UTF-8");
 response.sendRedirect("/dditServlet/chapter03/index.jsp?name="+encodedValue);
%>