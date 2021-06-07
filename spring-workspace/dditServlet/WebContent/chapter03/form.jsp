<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼 생성</title>
<script type="text/javascript">
	function chkCheckbox() {
		const name = document.querySelector('input[name=name]');
		if (name.value.trim().length === 0) {
			alert('이름이 입력되지 않았습니다.');
			return false;
		}

		const address = document.querySelector('input[name=address]');
		if (address.value.trim().length === 0) {
			alert('주소가 입력되지 않았습니다.');
			return false;
		}

		const petArr = document.querySelectorAll('input[name=pet]:checked');
		if (petArr.length === 0) {
			alert('좋아하는 동물이 입력되지 않았습니다.');
			return false;
		}

		const fruit = document.querySelector('input[name=fruit]:checked');
		if (fruit === null) {
			alert('좋아하는 과일이 입력되지 않았습니다.');
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<!-- 
<input> 태그는 폼의 입력 요소를 생성함 
HTML 폼의 각 입력 요소는 이름을 갖음
<input> 태그의 name 속성은 address인데 name 속성의 값이 입력 요소의 이름이 됨
입력 요소의 이름은 웹 브라우저가 서버에 전송하는 요청 파라미터의 이름으로 사용됨
이름 입력 요소에 개똥이를 입력한 뒤 [전송]버튼을 클릭하면, 웹 브라우저는 (파라미터이름=값) 
형식으로 파라미터 목록을 웹 서버에 전송함
-->
	<form action="viewParameter.jsp" method="post" onsubmit="return chkCheckbox()">
		이름 : <input type="text" name="name" size="10" /> <br />
		주소 : <input type="text" name="address" size="30" /> <br />
		좋아하는 동물 :
		<input type="checkbox" name="pet" value="dog" id="dog"> <label for="dog">강아지</label>
		<input type="checkbox" name="pet" value="cat" id="cat"><label for="cat">고양이</label>
		<input type="checkbox" name="pet" value="pig" id="pig"> <label for="pig">돼지</label> <br />
		좋아하는 과일 :
		<input type="radio" name="fruit" value="apple" id="apple"> <label for="apple">사과</label>
		<input type="radio" name="fruit" value="orange" id="orange"><label for="orange">오렌지</label> <br />
		
		<input type="submit" value="전송" style="cursor: pointer;" alt="전송" title="전송" />
	</form>
</body>
</html>