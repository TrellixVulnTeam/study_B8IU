<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 생성하기</title>
<style type="text/css">
label {
	display: inline-block;
	width: 75px;
	text-align: center;
}
</style>
<script type="text/javascript">
	function check() {
		if (document.querySelector("#title").value.trim().length < 1) {
			alert("제목이 입력되지 않았습니다.");
			return false;
		}

		if (document.querySelector("#category").value.trim().length < 1) {
			alert("카테고리가 입력되지 않았습니다.");
			return false;
		}

		if (document.querySelector("#price").value.trim().length < 1) {
			alert("가격이 입력되지 않았습니다.");
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<h1>책 생성하기</h1>
	<form method="POST" onsubmit="return check()">
		<p>
			<label for="title">제목</label><input type="text" id="title" name="title" value="${data.TITLE}" required="required" />
			<c:if test="errors.title">제목을 입력하세요.</c:if>
		</p>
		<p>
			<label for="category">카테고리</label><input type="text" id="category" name="category" value="${data.CATEGORY}" required="required" />
			<c:if test="errors.category">카테고리를 입력하세요.</c:if>
		</p>
		<p>
			<label for="price">가격</label><input type="number" step="10" id="price" name="price" value="${data.PRICE}" required="required" />
			<c:if test="errors.price">가격을 입력하세요.</c:if>
		</p>
		<p>
			<input type="submit" value="저장" />
		</p>
	</form>
</body>
</html>