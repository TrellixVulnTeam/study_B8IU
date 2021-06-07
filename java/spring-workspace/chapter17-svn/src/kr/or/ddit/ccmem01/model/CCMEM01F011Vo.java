package kr.or.ddit.ccmem01.model;

public class CCMEM01F011Vo {
	private String memId;
	private String memName;
	private String memLike;
	private String memJob;
	private String memZip;
	private String memAdd1;
	private String memAdd2;
	private String memHp;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemLike() {
		return memLike;
	}
	public void setMemLike(String memLike) {
		this.memLike = memLike;
	}
	public String getMemJob() {
		return memJob;
	}
	public void setMemJob(String memJob) {
		this.memJob = memJob;
	}
	public String getMemZip() {
		return memZip;
	}
	public void setMemZip(String memZip) {
		this.memZip = memZip;
	}
	public String getMemAdd1() {
		return memAdd1;
	}
	public void setMemAdd1(String memAdd1) {
		this.memAdd1 = memAdd1;
	}
	public String getMemAdd2() {
		return memAdd2;
	}
	public void setMemAdd2(String memAdd2) {
		this.memAdd2 = memAdd2;
	}
	public String getMemHp() {
		return memHp;
	}
	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}
	
	@Override
	public String toString() {
		return "CCMEM01F011Vo [memId=" + memId + ", memName=" + memName + ", memLike=" + memLike + ", memJob=" + memJob
				+ ", memZip=" + memZip + ", memAdd1=" + memAdd1 + ", memAdd2=" + memAdd2 + ", memHp=" + memHp + "]";
	}
	
	
}
