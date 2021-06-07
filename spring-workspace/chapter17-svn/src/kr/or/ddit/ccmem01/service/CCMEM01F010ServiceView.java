package kr.or.ddit.ccmem01.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import kr.or.ddit.ccmem01.model.CCMEM01F010Vo;

//기능
public class CCMEM01F010ServiceView {
	List<CCMEM01F010Vo> list = null;
	int totalCount = 0;
	int pageNumber = 0;
	int MESSAGE_COUNT_PER_PAGE = 0;
	int firstRow = 0;
	int endRow = 0;
	int pageTotalCount = 0;
	
	public CCMEM01F010ServiceView(List<CCMEM01F010Vo> list, int totalCount, int pageNumber, 
			int MESSAGE_COUNT_PER_PAGE, int firstRow, int endRow) {
		this.list = list;
		this.totalCount = totalCount;
		this.pageNumber = pageNumber;
		this.MESSAGE_COUNT_PER_PAGE = MESSAGE_COUNT_PER_PAGE;
		this.firstRow = firstRow;
		this.endRow = endRow;
		
		calculatePageTotalCount();
	}
	
	private void calculatePageTotalCount() {
		pageTotalCount = totalCount / MESSAGE_COUNT_PER_PAGE;
		if(totalCount % MESSAGE_COUNT_PER_PAGE > 0) {
			pageTotalCount++;
		}
	}

	public List<CCMEM01F010Vo> getList() {
		return list;
	}

	public void setList(List<CCMEM01F010Vo> list) {
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getMESSAGE_COUNT_PER_PAGE() {
		return MESSAGE_COUNT_PER_PAGE;
	}

	public void setMESSAGE_COUNT_PER_PAGE(int mESSAGE_COUNT_PER_PAGE) {
		MESSAGE_COUNT_PER_PAGE = mESSAGE_COUNT_PER_PAGE;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	
	public boolean isEmpty() {
		return totalCount == 0;
	}
}





