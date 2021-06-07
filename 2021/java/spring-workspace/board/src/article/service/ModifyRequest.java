package article.service;

import java.util.Map;

public class ModifyRequest {
	private String writerId;
	private Integer articleNo;
	private String title;
	private String content;

	public ModifyRequest(String writerId, Integer articleNo, String title, String content) {
		super();
		this.writerId = writerId;
		this.articleNo = articleNo;
		this.title = title;
		this.content = content;
	}

	public String getWriterId() {
		return writerId;
	}

	public Integer getArticleNo() {
		return articleNo;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public void setArticleNo(Integer articleNo) {
		this.articleNo = articleNo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}

		if (content == null || content.trim().isEmpty()) {
			errors.put("content", Boolean.TRUE);
		}
	}
}
