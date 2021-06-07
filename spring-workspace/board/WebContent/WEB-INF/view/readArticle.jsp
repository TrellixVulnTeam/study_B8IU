<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 읽기</title>
<script type="text/javascript">
	function deleteArticle() {
		if (confirm("정말 삭제하시겠습니까?")) {
			location.href="delete.do?pageNum=${param.pageNum}&articleNo=${param.articleNo}"
		}
	}
</script>
</head>
<body>
	<table border="1" style="width: 100%;">
		<tr>
			<th>작성자</th>
			<td>${articleData.article.writer.writerName}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${articleData.article.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${articleData.articleContent.content}</td>
		</tr>
		<tr>
			<td colspan="2">
				[<a href="list.do?pageNum=${param.pageNum}">목록</a>]
				<c:if test="${authUser.memberid == articleData.article.writer.writerId}">
					[<a href="modify.do?pageNum=${param.pageNum}&articleNo=${param.articleNo}">게시글 수정</a>]
					[<a href="javascript:deleteArticle()">게시글 삭제</a>]
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>