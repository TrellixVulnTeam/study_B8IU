<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>EL 산술 연산자 기초</title>
</head>
<body>

\${1+2} : ${1+2}<br />
\${1-2} : ${1-2}<br />
\${1*2} : ${1*2}<br />
\${1/2}(double로 자동 형변환) : ${1/2}<br />
\${1%2}(나머지): ${1%2}<br />
<hr />
<!-- 관계 연산자 정리 -->
\${3>2} : ${3>2} 또는 ${3 gt 2}<br />
\${3>=2} : ${3>=2} 또는 ${3 ge 2}<br />
\${3<2} : ${3<2} 또는 ${3 lt 2}<br />
\${3<=2} : ${3<=2} 또는 ${3 le 2}<br />
\${3==2} : ${3==2} 또는 ${3 eq 2}<br />
\${3!=2} : ${3!=2} 또는 ${3 ne 2}<br />
\${"개똥이"=="개똥이"} : ${"개똥이"=="개똥이"}<br />
<%-- \${"개똥이"=="개똥이"} : ${"개똥이"=="개똥이"}<br /> --%>

<!-- 논리 연산자 정리 -->
\${true and true} : ${true and true} ${true && true}<br /> 
\${true or false} : ${true or false}<br /> 
\${not false} : ${not false}<br />
\${not (7<3)} : ${not (7<3)}<br />




</body>
</html>