package article.service;

public class DeleteRequest {
	private String writerId;
	private Integer articleNo;

	public DeleteRequest(String writerId, Integer articleNo) {
		super();
		this.writerId = writerId;
		this.articleNo = articleNo;
	}

	public String getWriterId() {
		return writerId;
	}

	public Integer getArticleNo() {
		return articleNo;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public void setArticleNo(Integer articleNo) {
		this.articleNo = articleNo;
	}
}
