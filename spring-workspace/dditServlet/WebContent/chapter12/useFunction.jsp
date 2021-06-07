<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함수 사용</title>
</head>
<body>
	<c:set var="str1" value="Functions <태그>를 사용합니다."></c:set>
	<c:set var="str2" value="사용"></c:set>
	<c:set var="tokens" value="1, 2, 3, 4, 5, 6, 7, 8, 9, 10"></c:set>
	<!-- 문자열 길이										-->
	<p>\${fn:length(str1)} = ${fn:length(str1)}</p>
	<!-- 대문자로 변환										-->
	<p>\${fn:toUpperCase(str1)} = ${fn:toUpperCase(str1)}</p>
	<!-- 소문자로 변환										-->
	<p>\${fn:toLowerCase(str1)} = ${fn:toLowerCase(str1)}</p>
	<!-- 문자열 추출										-->
	<p>\${fn:substring(str1, 3, 6)} = ${fn:substring(str1, 3, 6)}</p>
	<!-- str1에서 str1에 포함되어 있는 str2 이후의 문자열을 구함	-->
	<p>\${fn:substringAfter(str1, str2)} = ${fn:substringAfter(str1, str2)}</p>
	<!-- str1에서 str1에 포함되어 있는 str2 이전의 문자열을 구함	-->
	<p>\${fn:substringBefore(str1, str2)} = ${fn:substringBefore(str1, str2)}</p>
	<!-- 좌우 공백 문자 제거									-->
	<p>\${fn:trim(str1)} = ${fn:trim(str1)}</p>
	<!-- str1에 있는 src를 dest로 변환						-->
	<p>\${fn:replace(str1, " ", "-")} = ${fn:replace(str1, " ", "-")}</p>
	<!-- str1에 있는 str2의 위치 인덱스를 구함					-->
	<p>\${fn:indexOf(str1, str2)} = ${fn:indexOf(str1, str2)}</p>
	<!-- str1이 'Fun'으로 시작하면 true						-->
	<p>\${fn:startsWith(str1, 'Fun')} = ${fn:startsWith(str1, 'Fun')}</p>
	<!-- str1이 '합니다.'으로 끝나면 true						-->
	<p>\${fn:endsWith(str1, "합니다.")} = ${fn:endsWith(str1, "합니다.")}</p>
	<!-- str1이 str2를 포함하면 true						-->
	<p>\${fn:contains(str1, str2)} = ${fn:contains(str1, str2)}</p>
	<!-- 대소문자 관계없이 str1이 str2를 포함하면 true			-->
	<p>\${fn:containsIgnoreCase(str1, str2)} = ${fn:containsIgnoreCase(str1, str2)}</p>

	<c:set var="array" value="${fn:split(tokens, ', ')}" />
	<p>\${fn:join(array, "-")} = ${fn:join(array, "-")}</p>
	<p>\${fn:escapeXml(str1)} = ${fn:escapeXml(str1)}</p>
</body>
</html>