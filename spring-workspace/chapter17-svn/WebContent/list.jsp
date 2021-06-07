<%@page import="kr.or.ddit.ccmem01.service.CCMEM01F010ServiceView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="kr.or.ddit.ccmem01.service.CCMEM01F010Service"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ccmem01.model.CCMEM01F010Vo"%>
<%
	String pageNumberStr = request.getParameter("page");
	int pageNumber = 1;
	if(pageNumberStr!=null){
		pageNumber = Integer.parseInt(pageNumberStr);
	}

	CCMEM01F010Service service = CCMEM01F010Service.getInstance();
// 	List<CCMEM01F010Vo> list = service.getSelectList(pageNumber);
	CCMEM01F010ServiceView list = service.getSelectList(pageNumber);
%>
<c:set var="viewData" value="<%=list%>" />
<!DOCTYPE html>
<html>
<head>
<script src="/chapter17/js/jquery.min.js"></script>
<title>회원별 매출금액 목록</title>
<script type="text/javascript">
function fnWinOpen(vara){
	window.open("memberDetail.jsp?memId="+vara,"oWin"
			,"width=800,height=350,left=100,top=100,scrollbars=no,toolbar=no,location=no,resizable=no,menubar=no");
}
</script>
</head>
<body>
<c:if test="${!viewData.isEmpty()}">
<table border="1" style="width:50%;">
<tr>
	<th>회원 아이디</th>
	<th>회원 명</th>
	<th>판매 금액</th>
</tr>
<c:forEach var="lists" items="${viewData.list}">
<tr style="cursor:pointer;" onclick="fnWinOpen('${lists.memId}')">
	<td>${lists.memId}</td>
	<td>${lists.memName}</td>
	<td>${lists.amt}</td>
</tr>
</c:forEach>
</table>
</c:if>

<div style="width:50%;text-align:center;">
<c:forEach var="pageNum" begin="1" end="${viewData.pageTotalCount}">
<a href="list.jsp?page=${pageNum}">[${pageNum}]</a>
</c:forEach>
</div>
</body>
</html>





