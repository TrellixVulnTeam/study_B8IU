<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>EL에서의 Collection</title>
</head>
<body>

<%
List<Long> values = Arrays.asList(1L,2L,5L,10L);
request.setAttribute("vals", values);

for(int i=0;i<values.size();i++){
	request.setAttribute("val", values.get(i));
%>
	${val}
<%
}
%>
<hr />
<!-- 할당 연산자. 주의할 점은 할당 연산자 자체도 출력 결과를 생성함 -->
<%-- ${var1 = 10} --%>
<!-- 그래서 이렇게 처리하면 됨 -->
${var1 = 10;''}
var1 : ${var1}
<hr />
${hangul=['가','나','다'];''}
${hangul[0]}
<hr />
${hangul=[['가','나','다'],['라','마','바']];''}
${hangul[0][1]}




</body>
</html>


