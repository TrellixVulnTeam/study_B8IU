<%@ page contentType = "text/html; charset=UTF-8" %>
<html>
<head><title>Calendar 클래스 사용</title></head>
<body>
<%
	java.util.Calendar cal = java.util.Calendar.getInstance();
%>
<!-- 
완전한 클래스 이름을 사용해도 JSP 페이지가 올바르게 실행됨
but, 매번 완전한 클래스 이름을 입력하는 것은 번거로움
import 속성을 사용하면 완전한 클래스 이름을 사용해야 하는 번거로움이 사라짐
 -->
오늘은 
	<%= cal.get(java.util.Calendar.YEAR) %>년 
	<%= cal.get(java.util.Calendar.MONTH) + 1 %>월
	<%= cal.get(java.util.Calendar.DATE) %>일
입니다.
</body>
</html>
