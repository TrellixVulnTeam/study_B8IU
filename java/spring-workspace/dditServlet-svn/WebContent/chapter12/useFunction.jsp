<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>함수 사용</title>
</head>
<body>

<c:set var="str1" value="Functions <태그>를 사용합니다." />
<c:set var="str2" value="사용" />
<c:set var="tokens" value="1,2,3,4,5,6,7,8,9,10" />
<!-- 문자열 길이 -->
\${fn:length(str1)} = ${fn:length(str1)}<br />
<!-- 대문자로 변환 -->
\${fn:toUpperCase(str1)} = ${fn:toUpperCase(str1)}<br />
<!-- 소문자로 변환 -->
\${fn:toLowerCase(str1)} = ${fn:toLowerCase(str1)}<br />
<!-- 문자열 추출 -->
\${fn:substring(str1,3,6)} = ${fn:substring(str1,3,6)}<br />
<!-- str1에서 str1에 포함되어 있는 str2 이후의 문자열을 구함 -->
\${fn:substringAfter(str1, str2)} = ${fn:substringAfter(str1, str2)} <br />
<!-- str1에서 str1에 포함되어 있는 str2 이전의 문자열을 구함 -->
\${fn:substringBefore(str1, str2)} = ${fn:substringBefore(str1, str2)} <br/>
<!-- 좌우 공백 문자 제거 -->
trim(str1) = "${fn:trim(str1)}" <br>
<!-- str1에 있는 src를 dest로 변환함 -->
\${fn:replace(str1, " ", "-")} = ${fn:replace(str1, " ", "-")} <br>
<!-- str1에서 str2가 위치한 인덱스 구함 -->
\${fn:indexOf(str1, str2)} = ${fn:indexOf(str1, str2)} <br>
<!-- str1이 str2로 시작하면 true -->
startsWith(str1, str2) = "${fn:startsWith(str1, 'Fun')}" <br>
<!-- str1이 str2로 끝나면 true -->
endsWith(str1, str2) = "${fn:endsWith(str1, "합니다.")}" <br>
<!-- str1이 str2를 포함하고 있으면 true -->
contains(str1, str2) = "${fn:contains(str1, str2)}" <br>
containsIgnoreCase(str1, str2) = "${fn:containsIgnoreCase(str1, str2)}" <br>

<c:set var="array" value="${fn:split(tokens, ',')}" />

join(array, "-") = "${fn:join(array, "-")}" <br>
escapeXml(str1) = "${fn:escapeXml(str1)}" <br>








</body>
</html>


