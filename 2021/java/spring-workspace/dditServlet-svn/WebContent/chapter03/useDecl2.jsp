<%@ page contentType = "text/html; charset=UTF-8" %>
<%!
//선언부에 두 개의 메서드를 정의함.

	//두 정수 값의 합을 구해주는 add 메서드
	public int add(int a, int b) {
		int c = a + b;
		return c;
	}
	
	//두 정수 값의 차를 구해주는 subtract 메서드
	public int subtract(int a, int b) {
		int c = a - b;
		return c;
	}
%>
<html>
<head><title>스크립트릿에서 선언부 사용하기</title></head>
<body>
<%
	//계산할 때 값으로 사용할 두 개의 변수 선언(정수값을 나타내는 int 타입)
	int value1 = 3;
	int value2 = 9;
	
	//선언부에서 작성한 add 메서드를 호출, 그 결과값을  addResult 변수에 저장함
	int addResult = add(value1, value2);
	//선언부에서 작성한 subtract 메서드를 호출하고, 그 결과값을 subtractResult 변수에 저장함.
	int subtractResult = subtract(value1, value2);
%>

<%=value1 %> + <%=value2 %> = <%=addResult %>
<br>
<%=value1 %> - <%=value2 %> = <%=subtractResult %>

</body>
</html>
