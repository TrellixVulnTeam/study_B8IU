package kr.or.ddit.ccmem01.model;

public class CCMEM01F011Vo {
	private String memId;
	private String memName;
	private String memAdd1;
	private String memAdd2;
	private String memBir;
	private String memHp;
	private String memMail;
	private String memJob;
	private String memLike;
	private int memMileage;
	private int amt;

	public String getMemId() {
		return memId;
	}

	public String getMemName() {
		return memName;
	}

	public String getMemAdd1() {
		return memAdd1;
	}

	public String getMemAdd2() {
		return memAdd2;
	}

	public String getMemBir() {
		return memBir;
	}

	public String getMemHp() {
		return memHp;
	}

	public String getMemMail() {
		return memMail;
	}

	public String getMemJob() {
		return memJob;
	}

	public String getMemLike() {
		return memLike;
	}

	public int getMemMileage() {
		return memMileage;
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

	public void setMemAdd1(String memAdd1) {
		this.memAdd1 = memAdd1;
	}

	public void setMemAdd2(String memAdd2) {
		this.memAdd2 = memAdd2;
	}

	public void setMemBir(String memBir) {
		this.memBir = memBir;
	}

	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public void setMemJob(String memJob) {
		this.memJob = memJob;
	}

	public void setMemLike(String memLike) {
		this.memLike = memLike;
	}

	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "CCMEM01F010Vo [memId=" + memId + ", memName=" + memName + ", memAdd1=" + memAdd1 + ", memAdd2=" + memAdd2 + ", memBir=" + memBir + ", memHp=" + memHp + ", memMail=" + memMail + ", memJob=" + memJob + ", memLike=" + memLike + ", memMileage=" + memMileage + ", amt=" + amt + "]";
	}
}
