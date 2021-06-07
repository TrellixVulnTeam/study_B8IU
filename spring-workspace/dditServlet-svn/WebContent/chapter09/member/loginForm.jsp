<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String id = null;
	if(cookies!=null&&cookies.length>0){
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("id")){
				//object이므로 String으로 형변환 필요
				id = cookies[i].getValue();	//a001
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>로그인폼</title>
<script type="text/javascript">
function fn_deleteCookie(){
	location.href = "deleteCookie.jsp";
<%
//새로고침 시 로그아웃이 되어버리는 현상이 있음..
// Cookie cookieId = new Cookie("id",null);
// Cookie cookiePassword = new Cookie("password",null);
// cookieId.setMaxAge(0);
// cookiePassword.setMaxAge(0);
// response.addCookie(cookieId);
// response.addCookie(cookiePassword);	
%>
// 	location.href="loginForm.jsp";
}
</script>
</head>
<body>
<%
if(id!=null){
%>
	<%=id%>님 환영합니다.
	<input type="button" name="btn" id="btn" onclick="fn_deleteCookie()" value="로그아웃" />
<%
}else{
%>
<form name="frm" id="frm" method="post" action="<%=request.getContextPath()%>/chapter09/member/login.jsp">
	아이디 <input type="text" name="id" id="id" style="width:150px;" />
	비밀번호 <input type="password" name="password" id="password" style="width:150px;" />
	<input type="submit" value="로그인" />
</form>
<%}%>
</body>
</html>