package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.list.ArticlePage;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ListArticleService {
	private static final int SIZE = 10;

	private static ListArticleService listArticleService;

	private ArticleDao articleDao;
	private ArticleContentDao articleContentDao;

	private ListArticleService() {
		articleDao = ArticleDao.getInstance();
		articleContentDao = ArticleContentDao.getInstance();
	}

	public static ListArticleService getInstance() {
		if (listArticleService == null) {
			listArticleService = new ListArticleService();
		}
		return listArticleService;
	}

	public ArticlePage getArticlePage(int pageNum) {
		Connection connection = null;
		try {
			connection = ConnectionProvider.getConnection();
			int total = articleDao.selectCount(connection);

			connection = ConnectionProvider.getConnection();
			return new ArticlePage(total, pageNum, SIZE, articleDao.select(connection, (pageNum - 1) * SIZE, SIZE));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(connection);
		}
	}
}
