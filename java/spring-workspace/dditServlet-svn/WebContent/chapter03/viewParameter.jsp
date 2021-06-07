<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %>
<%
	//요청 파라미터의 캐릭터 인코딩을 UTF-8로 지정함.
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head><title>요청 파라미터 출력</title></head>
<body>
<b>request.getParameter() 메서드 사용</b><br>
<!-- request.getParameter() 메서드를 사용하여 name 파라미터와 address 파라미터 값을 출력함 -->
name 파라미터 = <%= request.getParameter("name") %> <br>
address 파라미터 = <%= request.getParameter("address") %>
<p>
<b>request.getParameterValues() 메서드 사용</b><br>
<%
	//이름이 pet인 파라미터의 값 목록을 배열로(String[]) 리턴함. 배열의 첫 번재 원소를 사용할 때에는 배열변수[0]의 형태로 사용
	//pet 파라미터의 값을 String 배열로 읽어옴(pet 파라미터의 값이 한 개 이상 전달될 수 있으므로)
	//같은 이름으로 전송된 파라미터의 값들을 배열로 리턴
	//체크박스를 아무것도 선택하지 않으면 웹 브라우저는 해당 이름의 파라미터를 전송하지 않음.
	//cf) 텍스트를 위한 입력 요소들(<input type="text"..)은 값을 입력하지 않더라도 빈 문자열("")이 파라미터 값으로 전달됨
	String[] values = request.getParameterValues("pet");
	if (values != null) {
	for (int i = 0 ; i < values.length ; i++) {
%>
	<%= values[i] %>
<%
		}
	}
%>
<br />
좋아하는 과일 = <%=request.getParameter("fruit")%>
<p>
<b>request.getParameterNames() 메소드 사용</b><br>
<%
	//파라미터 이름을 출력해주는 기본 형태임
	Enumeration paramEnum = request.getParameterNames();
	while(paramEnum.hasMoreElements()) {
		String name = (String)paramEnum.nextElement();
%>
		<%= name %>
<%
	}
%>
<p>
<b>request.getParameterMap() 메소드 사용</b><br>
<%
	//자바의 Map을 사용하여 파라미터 이름과 파라미터 값을 리턴함. 
	//이 맵에는 <파라미터 이름, 파라미터 값 배열>이 쌍을 이루고 있음
	Map parameterMap = request.getParameterMap();
	String[] nameParam = (String[])parameterMap.get("pet");
	if (nameParam != null) {
%>
name = <%=nameParam[0] %>
<%
	}
%>
</body>
</html>
