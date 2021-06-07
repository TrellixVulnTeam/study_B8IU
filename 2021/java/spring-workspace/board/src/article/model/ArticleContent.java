package article.model;

public class ArticleContent {
	private int articleNo;
	private String content;

	public ArticleContent(int articleNo, String content) {
		super();
		this.articleNo = articleNo;
		this.content = content;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public String getContent() {
		return content;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
