<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style>
			div{
				background: lightBlue;
			}
			span{
				color: blue;
				font-size: 1.5em;
			}
		</style>
	</head>
	<body>
		<h1>JSP : Java Server Page</h1>
		<p>java와 html Code를 혼용하여 기술할 수 있다.</p>
		<p>Front-end 역할과 Back-end 역할을 모두 할 수 있다.</p>
		<p>Java 문장을 기술할 때는 &lt;% %&gt;기호 사이에 기술한다.</p>
		<p>Java 변수를 출력할 때는 &lt;%=변수 이름%&gt; 형식으로 기술한다.</p>
		<p>Client에서 Data 입력 후 전송(제출)하면 jsp 파일에서 Data를 받는다.</p>
		<p>request 내장 객체를 이용해서 값을 받는다.</p>
		<p>String 변수명 = request.getParameter("name");</p>
		<div>
			<%
				request.setCharacterEncoding("UTF-8");
				String name = request.getParameter("name");
				String tel = request.getParameter("tel");
				String password = request.getParameter("password");
			%>
			<p>당신의 이름은 <%=name %>입니다.</p>
			<p><span><%=name %>님 반갑습니다.</span></p>
			<p><%=tel %> 번호로 연락드리겠습니다.</p>
			<p>당신의 비밀번호는 <%=password %> 입니다.</p>
		</div>
	</body>
</html>