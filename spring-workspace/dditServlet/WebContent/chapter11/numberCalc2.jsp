<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		\${1 + 2}<br />→ ${1 + 2}
	</p>
	<p>
		\${1 - 2}<br />→ ${1 - 2}
	</p>
	<p>
		\${1 * 2}<br />→ ${1 * 2}
	</p>
	<p>
		\${1 / 2}: double로 자동 형변환<br />→ ${1 / 2}
	</p>
	<p>
		\${1 % 2}: 나머지<br />→ {1 % 2}
	</p>

	<hr />

	<!-- 관계 연산자 정리													-->
	<p>
		\${3 > 2} 또는 \${3 gt 2}<br />→ ${3 > 2} 또는 ${3 gt 2}
	</p>
	<p>
		\${3 >= 2} 또는 \${3 ge 2}<br />→ ${3 >= 2} 또는 ${3 ge 2}
	</p>
	<p>
		\${3 < 2} 또는 \${3 lt 2}<br />→ ${3 < 2} 또는 ${3 lt 2}
	</p>
	<p>
		\${3 <= 2} 또는 \${3 le 2}<br />→ ${3 <= 2} 또는 ${3 le 2}
	</p>
	<p>
		\${3 == 2} 또는 \${3 eq 2}<br />→ ${3 == 2} 또는 ${3 eq 2}
	</p>
	<p>
		<!-- \${3 != 2} 또는 \${3 ne 2}<br />→ ${3 != 2} 또는 ${3 ne 2}	-->
	</p>
	<p>
		\${"개똥이"=="개똥이"}<br />→ ${"개똥이"=="개똥이"}
	</p>

	<hr />

	<!-- 논리 연산자 정리													-->
	<p>
		\${true and true}<br />→ ${true and true}
	</p>
	<p>
		\${true or false}<br />→ ${true or false}
	</p>
	<p>
		\${not false}<br />→ ${not false}
	</p>
	<p>
		\${not (7 < 3)}<br />→ ${not (7 < 3)}
	</p>

</body>
</html>