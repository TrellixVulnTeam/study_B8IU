<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<style type="text/css">
label {
	display: inline-block;
	width: 75px;
	text-align: center;
}
</style>
<script type="text/javascript">
	function check() {
		if (document.getElementById("lprodGu").value.trim().length < 1) {
			alert("그룹 코드가 작성되지 않았습니다.");
			return false;
		}
		if (document.getElementById("lprodNm").value.trim().length < 1) {
			alert("그룹 명이 작성되지 않았습니다.");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form method="post" onsubmit="return check()">
		<p>
			<label for="lprodId">번호</label><input type="text" id="lprodId" name="lprodId" value="${lprod.lprodId}" required="required" readonly="readonly" />
		</p>
		<p>
			<label for="lprodGu">그룹 코드</label><input type="text" id="lprodGu" name="lprodGu" value="${lprod.lprodGu}" required="required" />
		</p>
		<p>
			<label for="lprodNm">그룹 명</label><input type="text" id="lprodNm" name="lprodNm" value="${lprod.lprodNm}" required="required" />
		</p>
		<p>
			<input type="button" value="목록으로" onclick="location.href='list'" /><input type="submit" value="수정하기" />
		</p>
	</form>
</body>
</html>