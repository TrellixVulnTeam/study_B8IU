package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ReadArticleService {
	private static ReadArticleService readArticleService = new ReadArticleService();
	private ArticleDao articleDao;
	private ArticleContentDao articleContentDao;

	private ReadArticleService() {
		articleDao = ArticleDao.getInstance();
		articleContentDao = ArticleContentDao.getInstance();
	}

	public static ReadArticleService getInstance() {
		return readArticleService;
	}

	public ArticleData getArticle(int articleNo) {
		Connection connection = null;

		try {
			connection = ConnectionProvider.getConnection();

			Article article = articleDao.selectByArticleNo(connection, articleNo);
			ArticleContent articleContent = articleContentDao.selectByArticleNo(connection, articleNo);

			if (article == null) {
				throw new ArticleNoFoundException();
			}
			if (articleContent == null) {
				throw new ArticleContentNoFoundException();
			}

			if (articleDao.increaseReadCount(connection, articleNo) != 0) {
				article.setReadCnt(article.getReadCnt() + 1);
			};

			return new ArticleData(article, articleContent);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(connection);
		}
	}
}
