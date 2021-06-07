package article.service;

import java.util.List;

import article.model.Article;

public class ArticlePage {
	private int total;	//전체 레코드 개수
	private int currentPage;	//현재 페이지 번호
	private List<Article> content;	//데이터 목록*******
	private int totalPage;	//전체 페이지 수
	private int startPage; //시작 페이지 번호
	private int endPage; //종료 페이지 번호
	
	public ArticlePage(int total, int currentPage, int size, List<Article> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		
		if(total == 0) {
			totalPage = 0;
			startPage = 0;
			endPage = 0;
		}else {
			totalPage = total / size;
			//나머지가 있을 때 후위연산자를 통해 1 증가
			if(total % size > 0) {
				totalPage++;
			}
			//[1]<-startPage [2] [3]<-currentPage [4] [5]
			int modVal = currentPage % 5;
			startPage = currentPage / 5 * 5 + 1;	//*******
			if(modVal == 0) startPage -= 5;
			
			endPage = startPage + 4;
			if(endPage > totalPage) endPage = totalPage;
		}
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Article> getContent() {
		return content;
	}
	public void setContent(List<Article> content) {
		this.content = content;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	//목록 결과가 없을 때
	public boolean hasNoArticles() {
		return total == 0;
	}
	//목록 결과가 있을 때
	public boolean hasArticles() {
		return total > 0;
	}
	@Override
	public String toString() {
		return "ArticlePage [total=" + total + ", currentPage=" + currentPage + ", content=" + content + ", totalPage="
				+ totalPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
}






