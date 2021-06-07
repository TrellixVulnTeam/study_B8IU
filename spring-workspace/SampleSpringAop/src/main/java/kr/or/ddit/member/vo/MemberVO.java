package kr.or.ddit.member.vo;

import java.util.Date;

public class MemberVO {
	private String memberid;
	private String password;
	private String name;
	private String email;
	private Date regdate;

	public MemberVO() {

	}

	public MemberVO(String memberid, String password, String name, String email, Date regdate) {
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

	public Date getRegdate() {
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

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberVO [memberid=" + memberid + ", password=" + password + ", name=" + name + ", email=" + email + ", regdate=" + regdate + "]";
	}


}

