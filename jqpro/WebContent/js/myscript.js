/**
 * 
 */
let a;
function appendImg() {
//	result1의 첫 번째 이미지를 선택
//	→ result1의 맨 뒤로 추가
//		: 이동이 됨
	
//	0.5초마다 한 번씩 이동	
	a = setInterval(function() {
		$("#result1 img").first().appendTo($("#result1"));
	}, 500);
	
//	$("#btn1").hide();
	$("#btn1").prop('disabled', true);
	
};

function stopImg() {
	clearInterval(a);
	
//	$("#btn1").show();
	$('#btn1').prop('disabled', false);
};
