<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="memberInfo" class="chapter08.member.MemberInfo" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="memberInfo" />
<%
memberInfo.setPassword(memberInfo.getId());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입</title>
</head>
<body>
	<table border="1" style="width: 50%; cellpadding: 0px; cellspacing: 0px;">
		<tr>
			<th>아이디</th>
			<td><%=memberInfo.getId()%></td>
			<th>비밀번호</th>
			<td><%=memberInfo.getPassword()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=memberInfo.getName()%></td>
			<th>이메일</th>
			<td><%=memberInfo.getEmail()%></td>
		</tr>
		<tr>
			<th>주소</th>
			<td colspan="3"><%=memberInfo.getAddress()%></td>
		</tr>
	</table>
</body>
</html>