<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>방명록 메시지 삭제 확인</title>
<script type="text/javascript">
function fn_chk(){
	var varPass = document.getElementById("password");
	if(varPass.value==""){
		alert("비밀번호를 입력해주세요");
		return false;
	}else{
		return true;
	}
}
</script>
</head>
<body>
<form name="frm" id="frm" method="post" action="deleteMessage.jsp"
  onSubmit="return fn_chk()">
<input type="hidden" name="messageId" value="<%=request.getParameter("messageId")%>" />
메시지를 삭제하려면 비밀번호를 입력하세요:<br />
비밀번호 : <input type="password" name="password" id="password" /><br />
<input type="submit" value="메시지 삭제하기" />&nbsp;
<input type="button" value="목록으로 이동" onclick="javascript:location.href='list.jsp'" />
</form>

</body>
</html>