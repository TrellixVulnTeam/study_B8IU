<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>forTokens 태그 연습</title>
</head>
<body>

콤마와 점을 구분자로 사용<br />
<c:set var="str" value="빨,주.노.초,파,남.보" />
<c:forTokens var="t" items="${str}" delims=",."
 begin="0" end="6" step="2" varStatus="status">
	${status.index} : ${status.count} : ${t}<br />
</c:forTokens>

</body>
</html>


