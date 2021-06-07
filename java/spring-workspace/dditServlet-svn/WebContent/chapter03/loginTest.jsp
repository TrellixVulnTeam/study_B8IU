<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<script type="text/javascript">
	function fn_chk(){
		var memId = document.getElementById("memId");
		var memPass = document.getElementById("memPass");
		var job = document.getElementsByName("job");
		var cnt = 0;
		for(var i=0;i<job.length;i++){
			if(job[i].checked){
				cnt = cnt + 1
			}
		}//end for
		
		if(memId.value==""){
			cnt = 0;
			alert("아이디를 입력해주세요");
			return false;
		}//end if
		if(memPass.value==""){
			cnt = 0;
			alert("비밀번호를 입력해주세요");
			return false;
		}//end if
// 		if(memId.value!="a001"){
// 			alert("로그인실패")
// 		}//end if
		if(cnt>0){
			return true;
		}else{
			alert("직업을 선택해주세요")
			return false;
		}//end if
	}//end function
</script>
</head>
<body>
	<form action="loginCheck.jsp" method="post" name="frm" id="frm" onsubmit="return fn_chk()">
		<input type="radio" name="job" value="student" /><label for="student">학생</label>
		<input type="radio" name="job" value="teacher" /><label for="teacher">교사</label>
		<input type="radio" name="job" value="manager" /><label for="manager">관리자</label>
		<br />
		아이디: <input type="text" name="memId" id="memId" value="" />
		<br />
		비밀번호: <input type="text" name="memPass" id="memPass" value="" />
		<br />
		<input type="submit" value="로그인" />
	</form>
</body>
</html>