<%@ page contentType="text/html; charset=iso-8859-1" %>
<%@ page import="java.util.Date" %>
<%
	Date now = new Date();
%>
<html>
<head><title>현재 시간</title></head>
<body>
현재 시각: 
<%= now %>
<hr />
글자가 깨진 이유는 소스 코드를 저장 시 사용한 캐릭터 인코딩과 page 디렉티브의 contentType 속성에 지정한 캐릭터 셋이 일치하지 않기 때문
<br />
응답 컨텐츠의 캐릭터 셋을 ISO-8859-1로 지정해서이다. ISO-8859-1은 알파벳과 서유럽어의 문자만을 포함하는 캐릭터 셋으로서 한글이나 한문 등의 문자는 정의되어 있지 않다.
<br />
그래서 결과에 포함된 한글이 깨져 보이는 것이다.
<br />
iso-8859-1을 utf-8로 바꾸어준다.
</body>
</html>