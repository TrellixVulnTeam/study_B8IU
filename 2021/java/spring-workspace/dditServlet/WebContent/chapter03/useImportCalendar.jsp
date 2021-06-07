<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar 클래스 사용</title>
</head>
<body>
	<%
	//현재 날짜와 시간 정보를 갖고 있는 Calendar 클래스의 인스턴스를 생성
	Calendar cal = Calendar.getInstance();
	%>
	<!-- 생성한 Calendar 클래스의 인스턴스를 사용해서 년, 월, 일을 출력 -->
	오늘은
	<%=cal.get(Calendar.YEAR)%>년
	<%=cal.get(Calendar.MONTH) + 1%>월
	<%=cal.get(Calendar.DATE)%>일 입니다.
</body>
</html>