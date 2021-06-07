<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forTokens Tag 연습</title>
</head>
<body>
	<p>콤마와 점을 구분자로 사용</p>
	<c:set var="str" value="빨, 주. 노. 초, 파, 남. 보"></c:set>
	<c:forTokens var="t" items="${str}" delims=",. " begin="0" end="6" step="2" varStatus="status">
		<p>${status.index}:${status.count}:${t}</p>
	</c:forTokens>
</body>
</html>