<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ page import = "java.util.Calendar" %>
<%//import 속성을 사용하여 jav.util.Calendar 클래스를 임포트. JSP 코드는 단순 이름인 Calendar를 사용할 수 있음 %>
<html>
<head><title>Calendar 클래스 사용</title></head>
<body>
<%
	//현재 날짜와 시간 정보를 갖고 있는 Calendar 클래스의 인스턴스를 생성
	Calendar cal = Calendar.getInstance();
%>
<!-- 생성한 Calendar 클래스의 인스턴스를 사용해서 년, 월, 일을 출력 -->
오늘은 
	<%= cal.get(Calendar.YEAR) %>년 
	<%= cal.get(Calendar.MONTH) + 1 %>월
	<%= cal.get(Calendar.DATE) %>일
입니다.
</body>
</html>
