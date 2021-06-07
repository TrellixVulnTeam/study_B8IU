<%@ page contentType = "text/html; charset=UTF-8" %>
<html>
<head><title>EL의 수치 연산자</title></head>
<body>

숫자의 경우 자바 연산자와 동일한 방법으로 사용됨<br /><br />
문자열을 비교할 경우 String.compareTo() 메서드를 사용.<br />
<%
	String str = "사과";
	request.setAttribute("str", str);
%>
\${str == "사과"} :  ${str == "사과"} <br />
\${param.name == "사과"} :  ${param.name == "사과"} <br />
\${applicationScope.str == "사과"} :  ${requestScope.str == "사과"} <br />
\${str eq "사과"} : ${str eq "사과"}<br />
\${str.equals("사과")} : ${str.equals("사과")}<br />
\${str.compareTo("사과")==0} : ${str.compareTo("사과")==0}<br />
이 코드는 someValue.compareTo("사과")==0과 같은 의미임.<br />
${"사과"=="사과"}<br />
</body>
</html>
