<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품분류 정보 상세</title>
<script type="text/javascript">
function fn_showToggle(getParam){
	console.log("getParam : "+getParam)
	if(getParam=="divView"){
		document.getElementById("divView").style.display = "none";
		document.getElementById("divEdit").style.display = "block";
	}else{
		document.getElementById("divView").style.display = "block";
		document.getElementById("divEdit").style.display = "none";
	}
	
}
</script>
</head>
<body>
<%
	String mode = request.getParameter("updateGu")==null?"success":request.getParameter("updateGu");
	if(mode.equals("success")){
		mode="divEdit";
	}else{
		mode="divView";
	}
%>
<c:set var="mode" value="<%=mode %>" />
	<form  method="post" action="/delete">
	<input type="hidden" name="lprodId" value="${lprodVo.lprodId}" />
		<div id="divView">
			<h1>상품분류 정보 상세</h1>
			<p>상품분류 번호 :${lprodVo.lprodId}</p>
			<p>상품분류 코드 :${lprodVo.lprodGu}</p>
			<p>상품분류 명 :${lprodVo.lprodNm}</p>
			<input type="button" value="수정" onclick="fn_showToggle('divView')">&nbsp; 
			<input type="submit" value="삭제">&nbsp; 
			<input type="button" value="목록" onclick="location.href='list'"/>
		</div>
	</form>
	<!-- 상세정보 수정 -->
	<form method="post" action="/update">
	<input type="hidden" name="lprodId" value="${lprodVo.lprodId}" />
	<div id="divEdit" style="display: none;">
		<h1>상품분류 정보 수정</h1>
		<p>상품분류 번호 :${lprodVo.lprodId}</p>
		<p>
			상품분류 코드 :<input type="text" name="lprodGu" id="lprodGu"  value="${lprodVo.lprodGu}" />
		</p>
		<p>
			상품분류 명 :<input type="text" name="lprodNm" value="${lprodVo.lprodNm}" />
		</p>
		<input type="submit" value="확인" />&nbsp; 
		<input type="button" value="취소" onclick="fn_showToggle('divEdit')">&nbsp; 
		<input type="button" value="목록" onclick="location.href='list'"/>
	</div>
	</form> 
<script type="text/javascript">
fn_ShowToggle("<%=mode%>");
</script>
</body>
</html>