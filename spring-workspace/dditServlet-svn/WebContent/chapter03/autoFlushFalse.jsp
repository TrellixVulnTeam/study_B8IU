<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page buffer="1kb" autoFlush="true" %>
<!DOCTYPE html>
<html>
<head>
<title>autoFlush 속성값 false 예제</title>
</head>
<body>
<!-- autoFlush 속성이 true이면, JSP 페이지가 생성하는 데이터 크기가
버퍼 크기보다 커지면 자동으로 버퍼를 플러시 하므로 정상적으로 실행됨 -->
<%
for(int i=0;i<1000;i++){
out.println("1234");
}
%>

</body>
</html>