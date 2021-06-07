<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL의 변수 지원 태그</title>
</head>
<body>
	<!-- var		-->
	<!--	→ 변수 명	-->
	<!-- value		-->
	<!--	→ 변수 값	-->
	<c:set var="name" value="개똥이"></c:set>
	<p>&lt;c:set var="name" value="개똥이">&lt;/c:set></p>
	<p>
		\${name}<br />→ ${name}
	</p>
	<p>
		\${pageScope.name}<br />→ ${pageScope.name}
	</p>
	<p>
		\${requestScope.name}<br />→ ${requestScope.name}
	</p>
	<p>
		\${sessionScope.name}<br />→ ${sessionScope.name}
	</p>
	<p>
		\${applicationScope.name}<br />→ ${applicationScope.name}
	</p>

	<hr />

	<c:set var="name2" value="개똥이" scope="request"></c:set>
	<p>&lt;c:set var="name2" value="개똥이" scope="request">&lt;/c:set></p>
	<p>
		\${name2}<br />→ ${name2}
	</p>
	<p>
		\${pageScope.name2}<br />→ ${pageScope.name2}
	</p>
	<p>
		\${requestScope.name2}<br />→ ${requestScope.name2}
	</p>
	<p>
		\${sessionScope.name2}<br />→ ${sessionScope.name2}
	</p>
	<p>
		\${applicationScope.name2}<br />→ ${applicationScope.name2}
	</p>

	<hr />

	<c:set var="name3">메뚜기</c:set>
	<p>&lt;c:set var="name3">메뚜기&lt;/c:set></p>
	<p>
		\${name3}<br />→ ${name3}
	</p>
	<p>
		\${pageScope.name3}<br />→ ${pageScope.name3}
	</p>
	<p>
		\${requestScope.name3}<br />→ ${requestScope.name3}
	</p>
	<p>
		\${sessionScope.name3}<br />→ ${sessionScope.name3}
	</p>
	<p>
		\${applicationScope.name3}<br />→ ${applicationScope.name3}
	</p>
</body>
</html>