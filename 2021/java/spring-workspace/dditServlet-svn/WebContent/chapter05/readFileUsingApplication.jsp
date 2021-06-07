<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.io.*"%>
<%@page import="java.net.URL"%>
<html>
<head><title>application 객체를 이용하여 자원 읽기</title></head>
<body>

<%
	String resourcePath = "/chapter05/notice.txt";
%>
	자원의 실제 경로:<br /><%=application.getRealPath(resourcePath) %><br />
<%
	char[] buff = new char[128];
	int len = -1;
	URL url = application.getResource(resourcePath);
	try(InputStreamReader br = new InputStreamReader(url.openStream(),"UTF-8")){		
		while((len = br.read(buff)) != -1){
			out.print(new String(buff,0,len));
		}
	}catch(IOException ex){
		out.println("오류 발생");
	}
%>

</body>
</html>
