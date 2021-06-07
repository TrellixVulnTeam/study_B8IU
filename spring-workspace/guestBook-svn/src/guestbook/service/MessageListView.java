package guestbook.service;

import java.util.List;

import guestbook.model.Message;

//요청된 페이지 번호, 요청된 페이지의 메시지 리스트, 전체 페이지 개수 등 정보를 담음
public class MessageListView {
	private int messageTotalCount; //글 전체 개수
	private int currentPageNumber; //현재 페이지 번호
	private List<Message> messageList;	//현재 페이지의 레코드 목록*******
	private int pageTotalCount;	//전체 페이지 개수
	private int messageCountPerPage;	//페이지 별 출력될 레코드 개수
	private int firstRow;	//시작행
	private int endRow;	//종료행
	
	public MessageListView(List<Message> messageList, int messageTotalCount,
				int currentPageNumber, int messageCountPerPage,
				int startRow, int endRow) {
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = startRow;
		this.endRow = endRow;
		
		calculatePageTotalCount();
	}
	//페이지 수 구함
	private void calculatePageTotalCount() {
		pageTotalCount = messageTotalCount / messageCountPerPage; //4 = 13/3
		if(messageTotalCount % messageCountPerPage > 0) {
			pageTotalCount++;
		}
	}
	
	public int getMessageTotalCount() {
		return messageTotalCount;
	}
	public void setMessageTotalCount(int messageTotalCount) {
		this.messageTotalCount = messageTotalCount;
	}
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	public List<Message> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}
	public void setMessageCountPerPage(int messageCountPerPage) {
		this.messageCountPerPage = messageCountPerPage;
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
	
	public boolean isEmpty() {
		return messageTotalCount == 0;
	}
	
}



















