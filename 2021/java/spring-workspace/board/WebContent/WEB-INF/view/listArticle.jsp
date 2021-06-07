<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style type="text/css">
.text-center {
	text-align: center;
}
</style>
</head>
<body>
	<div style="display: inline;">
		<table border="1" style="width: 100%;">
			<tr class="text-center">
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
			</tr>
			<c:choose>
				<c:when test="${articlePage.hasArticles()}">
					<c:forEach var="article" items="${articlePage.articles}" varStatus="status">
						<tr onclick="location.href='read.do?pageNum=${articlePage.currentPage}&articleNo=${article.articleNo}'" style="cursor: pointer;">
							<td class="text-center">${status.count}</td>
							<td>${article.title}</td>
							<td class="text-center">${article.writer.writerName}</td>
							<td class="text-center">${article.readCnt}</td>
						</tr>
					</c:forEach>
					<tr class="text-center">
						<td colspan="4">
							<c:choose>
								<c:when test="${articlePage.startPage != 1}">
									[<a href="?pageNum=1">처음</a>] [<a href="?pageNum=${articlePage.startPage - 1}">이전</a>]
								</c:when>
								<c:otherwise>
									[처음] [이전]
								</c:otherwise>
							</c:choose>
							<c:forEach var="pageNum" begin="${articlePage.startPage}" end="${articlePage.endPage}">
								<c:choose>
									<c:when test="${pageNum == articlePage.currentPage}">
										<font style="font-size: 1.2em;">[${pageNum}]</font>
									</c:when>
									<c:otherwise>
										[<a href="?pageNum=${pageNum}">${pageNum}</a>]
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${articlePage.endPage < articlePage.totalPage}">
									[<a href="?pageNum=${articlePage.endPage + 1}">다음</a>] [<a href="?pageNum=${articlePage.totalPage}">끝</a>]
								</c:when>
								<c:otherwise>
									[다음] [끝]
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">게시글이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>