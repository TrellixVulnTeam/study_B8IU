<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL에서의 Collection</title>
</head>
<body>
	<%
	List<Long> values = Arrays.asList(1L, 2L, 5L, 10L);

	for (Long value : values) {
		request.setAttribute("val", value);
	%>
	${val}
	<%
	}
	%>

	<hr />

	<!-- 할당 연산자 -->
	<!-- 할당 연산자 자체도 출력 결과를 생성함 -->
	${val1 = 10;''}val1
	<br />→ ${val1}

	<hr />

	${hangul=['가','나','다'];''}${hangul[0]}

	<hr />

	${hangul=[['가','나','다'],['라', '마', '바']];''} ${hangul[0][1]}
</body>
</html>