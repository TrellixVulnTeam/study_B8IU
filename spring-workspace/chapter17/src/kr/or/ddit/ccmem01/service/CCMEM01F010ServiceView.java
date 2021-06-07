package kr.or.ddit.ccmem01.service;

import java.util.List;

import kr.or.ddit.ccmem01.model.CCMEM01F010Vo;

public class CCMEM01F010ServiceView {
	List<CCMEM01F010Vo> list;
	int totalCount;
	int pageNumber;
	int MESSAGE_COUNT_PER_PAGE;
	int StartRow;
	int endRow;
	int pageTotalCount;

	public CCMEM01F010ServiceView(List<CCMEM01F010Vo> list, int totalCount, int pageNumber, int MESSAGE_COUNT_PER_PAGE, int StartRow, int endRow) {
		this.list = list;
		this.totalCount = totalCount;
		this.pageNumber = pageNumber;
		this.MESSAGE_COUNT_PER_PAGE = MESSAGE_COUNT_PER_PAGE;
		this.StartRow = StartRow;
		this.endRow = endRow;
		calcPageTotalCount();
	}

	public void calcPageTotalCount() {
		pageTotalCount = (int) Math.ceil((float) totalCount / MESSAGE_COUNT_PER_PAGE);
	}

	public List<CCMEM01F010Vo> getList() {
		return list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getMESSAGE_COUNT_PER_PAGE() {
		return MESSAGE_COUNT_PER_PAGE;
	}

	public int getStartRow() {
		return StartRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setList(List<CCMEM01F010Vo> list) {
		this.list = list;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setMESSAGE_COUNT_PER_PAGE(int mESSAGE_COUNT_PER_PAGE) {
		MESSAGE_COUNT_PER_PAGE = mESSAGE_COUNT_PER_PAGE;
	}

	public void setStartRow(int startRow) {
		StartRow = startRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
}
