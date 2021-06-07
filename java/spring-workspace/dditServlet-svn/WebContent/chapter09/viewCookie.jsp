<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	//쿠키를 구하면 배열로 저장됨
	Cookie[] cookies = request.getCookies();
	if(cookies!=null&&cookies.length>0){
%>
<!DOCTYPE html>
<html>
<head>
<title>쿠키 목록</title>
</head>
<body>
<%
		for(int i=0;i<cookies.length;i++){
			out.print(cookies[i].getName() + " = ");
			out.println(URLDecoder.decode(cookies[i].getValue(),"UTF-8") + "<br />");
		}
	}else{
		out.println("쿠키가 없습니다");
	}
%>
</body>
</html>