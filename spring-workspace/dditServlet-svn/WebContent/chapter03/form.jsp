<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>폼 생성</title>
<script type="text/javascript">
	function chkCheckbox(){
		var arr = document.getElementsByName("pet");
		var cnt = 0;
		var cnt2 = 0;
		//3개
// 		alert("arr : " + arr.length);
		
		for(i=0;i<arr.length;i++){
			if(arr[i].checked){
				cnt = cnt + 1;
			}
		}
		
		//이름 체킹
		var varName = document.getElementById("name");
		if(varName.value==""){
			alert("이름을 입력해주세요");
			cnt = 0;
		}
		//주소 체킹
		var varAddress = document.getElementById("address");
		if(varAddress.value==""){
			alert("주소를 입력해주세요");
			cnt = 0;
		}
		
		//과일 체킹
		var varFruit = document.getElementsByName("fruit");
		
		for(var j=0;j<varFruit.length;j++){
			if(varFruit[j].checked){
				cnt2 = cnt2 + 1;
			}
		}
		
		if(cnt>0&&cnt2>0){
			return true;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
<!-- 
<input> 태그는 폼의 입력 요소를 생성함 
HTML 폼의 각 입력 요소는 이름을 갖음
<input> 태그의 name 속성은 address인데 name 속성의 값이 입력 요소의 이름이 됨
입력 요소의 이름은 웹 브라우저가 서버에 전송하는 요청 파라미터의 이름으로 사용됨
이름 입력 요소에 개똥이를 입력한 뒤 [전송]버튼을 클릭하면, 웹 브라우저는 (파라미터이름=값) 형식으로 파라미터 목록을 웹 서버에 전송함
-->
<form name="frm" id="frm" action="viewParameter.jsp" method="post" onsubmit="return chkCheckbox()">
이름 : <input type="text" name="name" id="name" size="10" value="" /> <br />
주소 : <input type="text" name="address" id="address" size="30" value="" /> <br />
좋아하는 동물 :
	<input type="checkbox" name="pet" value="dog" id="dog"><label for="dog">강아지</label>
	<input type="checkbox" name="pet" value="cat" id="cat"><label for="cat">고양이</label>
	<input type="checkbox" name="pet" value="pig" id="pig"><label for="pig">돼지</label>
<br />
좋아하는 과일 :
	<input type="radio" name="fruit" value="apple" id="apple"><label for="apple">사과</label>
	<input type="radio" name="fruit" value="orange" id="orange"><label for="orange">오렌지</label>
<br />
	<input type="submit" value="전송" style="cursor:pointer;" alt="전송" title="전송" />
</form>

</body>
</html>