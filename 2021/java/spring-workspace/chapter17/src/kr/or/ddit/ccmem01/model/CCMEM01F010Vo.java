package kr.or.ddit.ccmem01.model;

public class CCMEM01F010Vo {
	private String memId;
	private String memName;
	private int amt;

	public String getMemId() {
		return memId;
	}

	public String getMemName() {
		return memName;
	}

	public int getAmt() {
		return amt;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "CCMEM01F010Vo [memId=" + memId + ", memName=" + memName + ", amt=" + amt + "]";
	}
}
