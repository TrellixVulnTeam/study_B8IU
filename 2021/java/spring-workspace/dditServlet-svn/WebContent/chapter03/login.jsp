<%@ page contentType="text/html; charset=UTF-8" %>
<%
	//삼항연산자를 사용하여 request.getParameter의 NULL을 체크함
	String id = request.getParameter("memberId")==null?"":request.getParameter("memberId");

	//파라미터가 null이 아니면서 동시에 memberId 파라미터의 값이 ddit일 때 로그인 되었다라고 하자
	if (id.equals("ddit")) {
		response.sendRedirect("/dditServlet/chapter03/index.jsp");
	} else {
%>
<html>
<head><title>로그인에 실패</title></head>
<body>
아이디가 ddit가 아닙니다.
</body>
</html>
<%
	}
%>
