package article.service;

import java.util.Map;

public class ModifyRequest {
	private String userId;	//사용자 아이디
	private int articleNumber;	//글번호(기본키)
	private String title;	//글제목
	private String content;	//글내용
	
	public ModifyRequest(String userId, int articleNumber, String title, String content) {
		this.userId = userId;
		this.articleNumber = articleNumber;
		this.title = title;
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void validate(Map<String,Boolean> errors) {
		if(title==null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);	//true : 문제발생
		}
	}
}






