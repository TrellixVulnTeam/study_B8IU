<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kr.or.ddit.ccmem01.service.CCMEM01F010Service"%>
<%@ page import="kr.or.ddit.ccmem01.service.CCMEM01F010ServiceView"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
CCMEM01F010Service ccmem01f010Service = CCMEM01F010Service.getInstance();

int pageNumber = 1;
if (request.getParameter("page") != null) {
	try {
		pageNumber = Integer.valueOf(request.getParameter("page"));
	} catch (Exception ex) {
		pageNumber = 1;
		ex.printStackTrace();
	}
}

CCMEM01F010ServiceView list = ccmem01f010Service.getSelectList(pageNumber);
%>
<c:set var="viewData" value="<%=list%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 별 매출금액 목록</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div style="display: inline-block; width: 50%;">
		<c:if test="${!viewData.list.isEmpty()}">
			<table border="1" style="width: 100%;">
				<tr>
					<th>회원 아이디</th>
					<th>회원명</th>
					<th>판매 금액</th>
				</tr>
				<c:forEach var="lists" items="${viewData.list}">
					<tr onclick="window.open('memberDetails.jsp?memId=${lists.memId}','${lists.memName}','width=400, height=200, left=100, top=100, scrollbars=no, menubar=no, status=no, toolbar=no, resizeable=no');" style="cursor: pointer;">
						<td>${lists.memId}</td>
						<td>${lists.memName}</td>
						<td>${lists.amt}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<p style="text-align: center;">
			<c:forEach var="pageNum" begin="1" end="${viewData.pageTotalCount}">[<a href="list.jsp?page=${pageNum}">${pageNum}</a>]</c:forEach>
		</p>
	</div>
</body>
</html>