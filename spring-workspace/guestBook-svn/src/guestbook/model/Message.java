package guestbook.model;

//guestbook_message 테이블 컬럼과 매핑되는 프로퍼티 목록을 갖음. 자바빈 규약
public class Message {
	private int id;
	private String guestName;
	private String password;
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//비밀번호 존재 유무 체크
	public boolean hasPassword() {
		return password != null && !password.isEmpty();
	}
	//파라미터로 전달받은 pwd가 저장된 password 필드와 같은지 확인
	public boolean matchPassword(String pwd) {
		return password!=null && password.equals(pwd);
	}
	
	
	
	
	
}





