<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String check = request.getParameter("check");
			String gender = request.getParameter("gender");
			String[] likes = request.getParameterValues("like");
			String file = request.getParameter("file");
			String str = " ";
			String res = "";
			for(int i = 0; i < likes.length; i++){
				res += " " + likes[i];
			}
			
			if(check.equals(1)){
				str = "내국인";
			}else{
				str = "외국인";
			}
		%>
		<p><%=id %>님 즐거운 하루 되세요.</p>
		<p>당신의 이름은 <%=name %>이고, <%=str %>입니다.</p>
		<p>당신의 성별은 <%=gender %>이고, 취미는 <%=res %>입니다.</p>
		<p>첨부하신 파일은 <a href="../images/<%=file %>"><%=file %></a>입니다.</p>
	</body>
</html>