<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String type = request.getParameter("type");
	
	if(type == null){
		return;
	}
%>
<br />
<table border="1" style="width:100%;cellpadding:0px;cellspacing:0px;">
	<tr><th>타입</th><td><b><%=type%></b></td></tr>
	<tr><th>특징</th><td>
<%
	if(type.equals("A")){
		out.println("강한 내구성");
	}else if(type.equals("B")){
		out.println("뛰어난 대처 능력");
	}else{
		out.println("뭣이 중헌디");
	}
%>
	</td></tr>
</table>