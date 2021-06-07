<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String password = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<%
	if (id.equals("a001") && password.equals("1234")) {
		// 로그인 성공
		Cookie cookieId = new Cookie("id", id);
		Cookie cookiePassword = new Cookie("password", password);

		response.addCookie(cookieId);
		response.addCookie(cookiePassword);

		String message = "";
		message += "	<script>" + "\n";
		message += "		alert(\"로그인 성공\");" + "\n";
		message += "	</script>";
		out.println(message);
	} else {
		String message = "";
		message += "	<script>" + "\n";
		message += "		alert(\"로그인 실패\");" + "\n";
		message += "		history.back();" + "\n";
		message += "	</script>";
		out.println(message);
	}
	%>
</body>
</html>