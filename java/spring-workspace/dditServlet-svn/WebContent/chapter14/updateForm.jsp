<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>이름 변경폼</title>
</head>
<body>

<form name="frm" id="frm" method="post" action="/dditServlet/chapter14/update.jsp">
<table border="1" style="width:100px;">
<tr>
	<th>아이디</th>
	<td><input type="text" name="memberId" id="memberId" style="width:100px;" /></td>
	<th>이름</th>
	<td><input type="text" name="name" id="name" style="width:100px;" /></td>
</tr>
<tr>
	<td colspan="4"><input type="submit" value="변경" /></td>
</tr>	
</table>
</form>






</body>
</html>