<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>from.jsp의 제목</title>
</head>
<body>

이 페이지는 from.jsp가 생성한 것임.메롱.
<!-- to.jsp로 요청 흐름이 이동 -->
<jsp:forward page="/chapter07/to/to.jsp" />

</body>
</html>