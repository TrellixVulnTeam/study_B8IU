<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>catch 태그</title>
</head>
<body>
<c:catch var="ex">
	<%=request.getParameter("name") %><br />
	<%if(request.getParameter("name").equals("ddit")){ %>
		${param.name}은 ddit입니다.
	<%}%>
</c:catch><br />
<c:if test="${ex!=null}">
	오류 발생..${ex}
</c:if> 
</body>
</html>


