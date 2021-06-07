package member.model;

public class Member {
	private String memberid;
	private String password;
	private String name;
	private String email;
	private String regdate;

	public Member() {

	}

	public Member(String memberid, String password, String name, String email, String regdate) {
		super();
		this.memberid = memberid;
		this.password = password;
		this.name = name;
		this.email = email;
		this.regdate = regdate;
	}

	public String getMemberid() {
		return memberid;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
}
