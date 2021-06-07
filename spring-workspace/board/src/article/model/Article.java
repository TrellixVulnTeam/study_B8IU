package article.model;

public class Article {
	private Integer articleNo;
	private Writer writer;
	private String title;
	private String regdate;
	private String moddate;
	private Integer readCnt;

	public Article(Integer articleNo, Writer writer, String title, String regdate, String moddate, Integer readCnt) {
		super();
		this.articleNo = articleNo;
		this.writer = writer;
		this.title = title;
		this.regdate = regdate;
		this.moddate = moddate;
		this.readCnt = readCnt;
	}

	public Integer getArticleNo() {
		return articleNo;
	}

	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getRegdate() {
		return regdate;
	}

	public String getModdate() {
		return moddate;
	}

	public Integer getReadCnt() {
		return readCnt;
	}

	public void setArticleNo(Integer articleNo) {
		this.articleNo = articleNo;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	public void setReadCnt(Integer readCnt) {
		this.readCnt = readCnt;
	}
}
