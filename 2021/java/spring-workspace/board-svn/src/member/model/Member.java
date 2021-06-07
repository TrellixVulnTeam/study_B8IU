package member.model;

public class Member {
	private String id;
	private String name;
	private String password;
	private String email;
	private String regdate;
	
	public Member(String id, String name, String password, String email, String regdate) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.regdate = regdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	//암호 변경 기능 구현 시 사용
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}
	//비밀번호 변경
	public void changePassword(String newPwd){
		this.password = newPwd;
	}
	
}
