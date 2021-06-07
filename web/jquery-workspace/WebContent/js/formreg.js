/**
 * @author 이학재
 */
let nameReg = /^[가-힣]{2,10}$/;
let idReg = /^[a-z][\.0-9a-zA-Z]{3,11}$/;
let telReg = /^0\d{1,2}-\d{3,4}-\d{4}$/;
let pwReg = /^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&()+]).{8,20}$/;
let emailReg = /^([\.0-9a-zA-Z_-]+)@([a-z0-9A-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;

/**
 * 이름을 입력하면 유효성을 판별하여 그 결과를 돌려주는 메서드
 * @author 이학재
 * @param name
 * @returns {Boolean}
 */
function nameCheck(name) {
	if (name.length < 1) {
		alert("이름을 입력하세요.");
		return false;
	}
	
	if (name.length < 2 || name.length > 10)  {
		alert("이름은 2 ~ 10 글자여야 합니다.");
		return false;
	}
	
	if (!nameReg.test(name)) {
		alert("이름은 2 ~ 10 글자의 한글이어야 합니다.");
		return false;
	}
	
	return true;
};

/**
 * id를 입력하면 유효성을 판별하여 그 결과를 돌려주는 메서드
 * @author 이학재
 * @param name
 * @returns {Boolean}
 */
function idCheck(id) {
	if (id.length < 1) {
		alert("아이디를 입력하세요.");
		return false;
	}
	
	if (id.length < 4 || id.length > 12) {
		alert("아이디는 4 ~ 12 글자여야 합니다.");
		return false;
	}
	
	if (!idReg.test(id)) {
		alert("아이디는 영문 소문자로 시작하며, 4 ~ 12글자의 영문 또는 숫자여야 합니다.");
		return false;
	}
	
	return true;
};

/**
 * 전화번호를 입력하면 유효성을 판별하여 그 결과를 돌려주는 메서드
 * @author 이학재
 * @param name
 * @returns {Boolean}
 */
function telCheck(tel) {
	if (tel.length < 1) {
		alert("전화번호를 입력하세요.");
		return false;
	}
	
	if (!telReg.test(tel)) {
		alert("전화번호는 02-1234-5678 또는 011-123-4567 또는 010-1234-5678과 동일한 형태로 작성되어야 합니다.");
		return false;
	}
	
	return true;
};

/**
 * 비밀번호를 입력하면 유효성을 판별하여 그 결과를 돌려주는 메서드
 * @author 이학재
 * @param pw
 * @returns {Boolean}
 */
function pwCheck(pw) {
	if (pw.length < 1) {
		alert('비밀번호를 입력하세요.');
		return false;
	}
	
	if (pw.length < 8 || pw.length > 20) {
		alert("비밀번호의 길이는 8 ~ 20자리여야 합니다.");
		return false;
	}
	
	if(!pwReg.test(pw)) {
		alert("비밀번호는 8 ~ 20자리이며, 영문 대문자와 소문자, 숫자, 특수문자를 1개 이상씩 포함하여야 합니다.");
		return false;
	}
	return true;
};

/**
 * 이메일을 입력받아 유효성을 판별하여 그 결과를 돌려주는 메서드
 * @param email
 * @returns {Boolean}
 */
function emailCheck(email) {
	if (email < 1) {
		alert("이메일을 입력하세요.");
		return false;
	}
	
	if(!emailReg.test(email)) {
		alert("이메일의 형식이 올바르지 않습니다.");
		return false;
	}
	return true;
};
