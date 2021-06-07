package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class WriteArticleService {
	private static WriteArticleService writeArticleService = new WriteArticleService();
	private ArticleDao articleDao;
	private ArticleContentDao articleContentDao;

	private WriteArticleService() {
		articleDao = ArticleDao.getInstance();
		articleContentDao = ArticleContentDao.getInstance();
	}

	public static WriteArticleService getInstance() {
		return writeArticleService;
	}

	public int write(WriteRequest writeRequest) {
		Connection connection = null;;
		try {
			connection = ConnectionProvider.getConnection();
			connection.setAutoCommit(false);

			Article article = new Article(null, writeRequest.getWriter(), writeRequest.getTitle(), null, null, null);
			Article saveArticle = articleDao.insert(connection, article);

			ArticleContent articleContent = new ArticleContent(saveArticle.getArticleNo(), writeRequest.getContent());
			articleContentDao.insert(connection, articleContent);

			connection.commit();

			return saveArticle.getArticleNo();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(connection);
			throw e;
		} finally {
			JdbcUtil.close(connection);
		}
	}
}
