/**
 * 
 */

function writePro(data) {
	let res = `<div class="panel panel-default">`;
		res += `<div class="panel-heading">`;
			res += `<h4 class="panel-title">`;
				res += `<a data-toggle="collapse" data-parent="#accordion" href="#collapse${data.i}">${data.title}</a>`;
			res += `</h4>`;
		res += `</div>`;
		res += `<div id="collapse${data.i}" class="panel-collapse collapse">`;
			res += `<div class="panel-body pbody" idx="${i}">`;
				res += `<p class="p1">작성자 : ${data.name} | 이메일 : ${data.email} | 날짜 : ${(new Date()).toLocaleDateString()} | 조회수 : 0</p>`;
				res += `<p class="p2">`;
					res += `<input type="button" idx="${data.i}" class="action" name="modify" value="수정">`;
					res += `<input type="button" idx="${data.i}" class="action" name="delete" value="삭제">`;
				res += `</p>`;
				res += `<p class="p3">`;
					res += `${data.content}`;
				res += `</p>`;
				res += `<p class="p4">`;
					res += `<textarea rows="" cols="60"></textarea>`;
					res += `<input type="button" value="등록" idx="${data.i}" name="reply" class="action">`;
				res += `</p>`;
			res += `</div>`;
		res += `</div>`;
	res += `</div>`;
	
	$('#accordion').append(res);
};

function listPro(board) {
	let res = `<div class="panel-group" id="accordion">`;
	for (let i = 0; i < board.writer.length; i++) {
		res += `<div class="panel panel-default">`;
		res += `<div class="panel-heading">`;
		res += `<h4 class="panel-title">`;
		res += `<a data-toggle="collapse" data-parent="#accordion" class="action" name="list" idx="${i}" href="#collapse${i}">${board.title[i]}</a>`;
		res += `</h4>`;
		res += `</div>`;
		res += `<div id="collapse${i}" class="panel-collapse collapse">`;
		res += `<div class="panel-body pbody" idx="${i}">`;
		res += `<p class="p1">작성자 : ${board.writer[i]} | 이메일 : ${board.email[i]} | 날짜 : ${board.date[i]} | 조회수 : <span class="h">0</span></p>`;
		res += `<p class="p2">`;
		res += `<input type="button" idx="${i}" class="action" name="modify" data-toggle="modal" data-target="#modModal" value="수정">`;
		res += `<input type="button" idx="${i}" class="action" name="delete" value="삭제">`;
		res += `</p>`;
		res += `<p class="p3">`;
		res += `${board.content[i]}`;
		res += `</p>`;
		res += `<p class="p4">`;
		res += `<textarea rows="" cols="60"></textarea>`;
		res += `<input type="button" value="등록" idx="${i}" name="reply" class="action">`;
		res += `</p>`;
		res += `</div>`;
		res += `</div>`;
		res += `</div>`;
	}
	res += `</div>`;
	
	$('#accordion').remove();
	$('.container').append(res);
};

/*
function replyPro(parents, idx) {
	let res = `<div class="comment"`;
	res += `<p class="p1">작성자 : ${String.fromCharCode(Math.random()*26+65)}${String.fromCharCode(Math.random() *26+97)} | 이메일 : | 날짜 : ${(new Date()).toLocaleString()} | 조회수 : 0</p>`;
	res += `<p class="p2">`;
		res += `<input type="button" idx="${idx}" class="action" name="modify" value="수정">`;
		res += `<input type="button" idx="${idx}" class="action" name="delete" value="삭제">`;
	res += `</p>`;
	res += `<p class="p3">`;
		res += `${$(parents).find('textarea').val().replace(/\r/g, "").replace(/\n/g, "<br>")}`;
	res += `</p>`;
	res += `<p class="p4">`;
		res += `<textarea rows="" cols="30"></textarea>`;
		res += `<input type="button" value="등록" idx="${idx}" name="reply" class="action">`;
	res += `</p>`;
	
	$(res).css({
		"border" : "1px solid blue",
		"width" : "300px",
		"margin" : "20px"
	}).appendTo(parents);
};
 */

function replyPro(a,t) {
	let res = `<div class="panel-body panel-reply">`;
	res += `<p class="p1">작성자 : ${t.name} | 이메일 : | 날짜 : ${t.today} | 조회수 : 0</p>`;
	res += `<p class="p2">`;
		res += `<input type="button" idx="1" class="action" name="r_modify" value="댓글 수정">`;
		res += `<input type="button" idx="1" class="action" name="r_delete" value="댓글 삭제">`;
	res += `</p>`;
	res += `<p class="p3">`;
		res += reply.text;
	res += `</p>`;
	res += `</div>`;
	$(res).css({
		"border" : "1px solid red",
		"margin" : "20px"
	}).appendTo($(a).parents('.pbody'));
};
