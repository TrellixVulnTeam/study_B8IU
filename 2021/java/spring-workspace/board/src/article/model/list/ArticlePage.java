package article.model.list;

import java.util.List;

import article.model.Article;

public class ArticlePage {
	int total;
	int currentPage;
	List<Article> articles;
	int totalPage;
	int startPage;
	int endPage;

	public ArticlePage(int total, int currentPage, int size, List<Article> articles) {
		super();
		this.total = total;
		this.currentPage = currentPage;
		this.articles = articles;

		if (total == 0) {
			totalPage = 0;
			startPage = 0;
			endPage = 0;
			return;
		}

		totalPage = (int) Math.ceil((float) total / size);
		startPage = (currentPage - 1) / 5 * 5 + 1;
		endPage = startPage + 4 > totalPage ? totalPage : startPage + 4;
	}

	public int getTotal() {
		return total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean hasArticles() {
		return total > 0;
	}

	public boolean hasNoArticles() {
		return !hasArticles();
	}
}
