<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	session.setAttribute("memberid", "ddit");
	session.setAttribute("name", "개똥이");
%>
<!DOCTYPE html>
<html>
<head>
<script src="/dditServlet/js/jquery.min.js"></script>
<title>세션에 정보 저장</title>
<script type="text/javascript">
$(function(){
	$("#btn").on("click",function(){
		location.href="closeSession.jsp";
	});
});
</script>
</head>
<body>
세션에 정보를 저장했습니다.<br />
<%
	String memberId = (String)session.getAttribute("memberid");
	String name = (String)session.getAttribute("name");
%>
회원아이디 : <%=memberId%><br />
회원명 : <%=name%><br />
<input type="button" id="btn" value="로그아웃" />
</body>
</html>