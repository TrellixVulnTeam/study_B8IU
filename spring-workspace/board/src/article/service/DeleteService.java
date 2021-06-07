package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class DeleteService {
	private static DeleteService deleteService;
	private ArticleDao articleDao;
	private ArticleContentDao articleContentDao;

	private DeleteService() {
		articleDao = ArticleDao.getInstance();
		articleContentDao = ArticleContentDao.getInstance();
	};

	public static DeleteService getInstance() {
		if (deleteService == null) {
			deleteService = new DeleteService();
		}
		return deleteService;
	}

	public int delete(int articleNo) {
		Connection connection = null;
		int result = 0;

		try {
			connection = ConnectionProvider.getConnection();

			result = articleDao.delete(connection, articleNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection);
		}
		return result;
	}


}
