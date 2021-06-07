package auth.service;

public class User {
	private String memberid;
	private String name;

	public User(String memberid, String name) {
		super();
		this.memberid = memberid;
		this.name = name;
	}

	public String getMemberid() {
		return memberid;
	}

	public String getName() {
		return name;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public void setName(String name) {
		this.name = name;
	}
}
