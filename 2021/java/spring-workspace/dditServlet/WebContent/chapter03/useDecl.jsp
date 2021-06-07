<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!//선언부를 시작함
	//int : 메서드의 리턴 타입. 메서드 실행 결과값의 타입이 int이을 나타냄
	//정수 값 : int, logn, short
	//실수 값(소수점 표함) : double, float
	//a, b : 파라미터의 이름. 메서드 내부에서 변수로 사용됨.
	public int multiply(int a, int b) {
		int c = a * b;
		return c;
	}
	//선언부 종료%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언부를 사용한 두 정수값의 곱</title>
</head>
<body>
	<!-- 선언부에서 정의한 multiply() 메서드를 호출(call)한 결과값을 표현식을 사용하여 출력함. -->
	10 * 25 =
	<%=multiply(10, 25)%>
</body>
</html>