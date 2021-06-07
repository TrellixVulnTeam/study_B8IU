<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kr.or.ddit.ccmem01.model.CCMEM01F011Vo"%>
<%@ page import="kr.or.ddit.ccmem01.service.CCMEM01F011Service"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
String memId = request.getParameter("memId");

CCMEM01F011Service ccmem01f011Service = CCMEM01F011Service.getInstance();
CCMEM01F011Vo ccmem01f011Vo = ccmem01f011Service.getSelect(memId);
%>
<c:set var="member" value="<%=ccmem01f011Vo%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${member.memName}</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<style type="text/css">
.spanButton {
	cursor: pointer;
}
.displayNone {
	display: none;
}
</style>
<script type="text/javascript">
	function fn_def() {
		$('#idDef').removeClass('displayNone');
		$('#idDet').addClass('displayNone');
	}
	function fn_det() {
		$('#idDef').addClass('displayNone');
		$('#idDet').removeClass('displayNone');
	}
</script>
</head>
<body>
	<span class="spanButton" onclick="fn_def()">회원 기본 정보</span>&nbsp;&nbsp;
	<span class="spanButton" onclick="fn_det()">회원 상세 정보</span>
	<br />
	<div id="idDef">
		<table border="1" style="width: 100%;">
			<tr>
				<th>아이디</th>
				<td>${member.memId}</td>
				<th>직업</th>
				<td>${member.memJob}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${member.memName}</td>
				<th>취미</th>
				<td>${member.memLike}</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td colspan="3">${member.memHp}</td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="3">${member.memAdd1}&nbsp;${member.memAdd2}</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: right;"><input type="button" onclick="window.close();" value="닫기" /></td>
			</tr>
		</table>
	</div>
	<div id="idDet" class="displayNone">
		<table border="1" style="width: 100%;">
			<tr>
				<th>회원 생일</th>
				<td>${member.memBir}</td>
				<th>메일주소</th>
				<td>${member.memMail}</td>
			</tr>
			<tr>
				<th>마일리지</th>
				<td colspan="3">${member.memMileage}</td>
			</tr>
			<tr>
				<th>총 구매 금액</th>
				<td colspan="3">${member.amt}</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: right;"><input type="button" onclick="self.close()" value="닫기" /></td>
			</tr>
		</table>
	</div>
</body>
</html>