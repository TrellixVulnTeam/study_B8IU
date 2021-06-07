<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="kr.or.ddit.ccmem01.service.CCMEM01F011Service"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ccmem01.model.CCMEM01F011Vo"%>
<%
	String memId = request.getParameter("memId");
	CCMEM01F011Service ccmem01f011Service = CCMEM01F011Service.getInstance();
	CCMEM01F011Vo memberList = ccmem01f011Service.getMemberDetail(memId);
%>
<c:set var="viewData" value="<%=memberList%>" />
<!DOCTYPE html>
<html>
<head><title>회원 상세 정보</title>
<style type="text/css">
  .spanDef{color:black; text-decoration:none;cursor:pointer;} /* a:link a tag 기본 */
  .spanDef:hover {color:#F22867; font-weight:bold} /* 마우스오버 link*/
  .spanDef:active {color:#70CDD5; font-weight:bold} /* 선택된 link*/
  .spanDef:visited {color:#909090; font-weight:bold} /* 이미방분한 link*/
</style>
<script src="/chapter17/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#span1").on("click",function(){
		$("#idDef").attr("style","display:block;");
		$("#idDet").attr("style","display:none;");
	});
	$("#span2").on("click",function(){
		$("#idDef").attr("style","display:none;");
		$("#idDet").attr("style","display:block;");
	});
});
</script>
</head>
<body>
<span class="spanDef" id="span1">회원 기본 정보</span>&nbsp;&nbsp;
<span class="spanDef" id="span2">회원 상세 정보</span><br />
<div id="idDef">
	<table border="1" style="width:100%;">
	<tr>
		<th style="width:15%;">회원<br />아이디</th>
		<td style="width:30%;">${viewData.memId}</td>
		<th style="width:15%;">직업</th>
		<td style="width:30%;">${viewData.memJob}</td>
	</tr>
	<tr><th>회원 명</th><td>${viewData.memName}</td><th>취미</th><td>${viewData.memLike}</td></tr>
	<tr><th>연락처</th><td colspan="3">${viewData.memHp}</td></tr>
	<tr><th>주소</th><td colspan="3">${viewData.memZip} ${viewData.memAdd1} ${viewData.memAdd2}</td></tr>
	</table>
</div>
<div id="idDet" style="display:none;">
	<table border="1" style="width:100%;">
	<tr>
		<th style="width:15%;">회원<br />생일</th>
		<td style="width:30%;">${viewData.memId}</td>
		<th style="width:15%;">메일주소</th>
		<td style="width:30%;">${viewData.memJob}</td>
	</tr>
	<tr><th>마일리지</th><td colspan="3">${viewData.memZip} ${viewData.memAdd1} ${viewData.memAdd2}</td></tr>
	<tr><th>총 구매금액</th><td colspan="3">${viewData.memZip} ${viewData.memAdd1} ${viewData.memAdd2}</td></tr>
	</table>
</div>
<br />
<div style="width:100%;text-align:right;">
	<input type="button" value="닫기" style="cursor:pointer;" onclick="javascript:self.close();"/>
</div>
</body>
</html>


