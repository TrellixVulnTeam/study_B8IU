<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>pageContext 기본 객체</title></head>
<body>

<%
//servletRequest타입으로 return하는 것이 아니라 HttpServletRequest 타입으로 리턴
//request객체를 생성
HttpServletRequest httpRequest = (HttpServletRequest)pageContext.getRequest();
%>

동일여부? 
<%=request == httpRequest%>

<%pageContext.getOut().println("안녕하세요?"); %>

</body>
</html>
