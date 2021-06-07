<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>JSTL의 변수 지원 태그</title>
</head>
<body>
<!-- var : 변수 이름 / value : 변수 값. 기본으로 page객체에 저장됨 -->
<c:set var="name" value="개똥이" />
\${name} : ${name}<br />
<!-- scope : 변수를 저장할 영역.(page, request, session, application) -->
<c:set var="name2" value="홍길동" scope="request" />
\${name2} : ${name2}<br />
<c:set var="name3" scope="request">메뚜기</c:set>
\${name3} : ${name3}<br />


</body>
</html>