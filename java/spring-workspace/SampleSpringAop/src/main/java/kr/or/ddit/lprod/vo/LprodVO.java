package kr.or.ddit.lprod.vo;

public class LprodVO {
	private int lprodId;
	private String lprodGu;
	private String lprodNm;
	
	public LprodVO() {
		
	}

	public LprodVO(int lprodId, String lprodGu, String lprodNm) {
		super();
		this.lprodId = lprodId;
		this.lprodGu = lprodGu;
		this.lprodNm = lprodNm;
	}

	public int getLprodId() {
		return lprodId;
	}

	public String getLprodGu() {
		return lprodGu;
	}

	public String getLprodNm() {
		return lprodNm;
	}

	public void setLprodId(int lprodId) {
		this.lprodId = lprodId;
	}

	public void setLprodGu(String lprodGu) {
		this.lprodGu = lprodGu;
	}

	public void setLprodNm(String lprodNm) {
		this.lprodNm = lprodNm;
	}

	@Override
	public String toString() {
		return "LprodVO [lprodId=" + lprodId + ", lprodGu=" + lprodGu + ", lprodNm=" + lprodNm + "]";
	}
	
	
	
}
