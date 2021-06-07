<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재 시간</title>
</head>
<body>

<!-- 스크립트릿(scriptlet) : JSP의 스크립트 요소. 
사이에 위치한 값을 문자열로 생성해줌 -->
지금 : <%=new java.util.Date()%>

</body>
</html>