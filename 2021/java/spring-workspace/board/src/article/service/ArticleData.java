package article.service;

import article.model.Article;
import article.model.ArticleContent;

public class ArticleData {
	private Article article;
	private ArticleContent articleContent;

	public ArticleData(Article article, ArticleContent articleContent) {
		super();
		this.article = article;
		this.articleContent = articleContent;
	}

	public Article getArticle() {
		return article;
	}

	public ArticleContent getArticleContent() {
		return articleContent;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public void setArticleContent(ArticleContent articleContent) {
		this.articleContent = articleContent;
	}
}
