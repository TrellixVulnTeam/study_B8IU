package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ModifyService {
	private static ModifyService modifyService;
	private ArticleDao articleDao;
	private ArticleContentDao articleContentDao;

	private ModifyService() {
		articleDao = ArticleDao.getInstance();
		articleContentDao = ArticleContentDao.getInstance();
	};

	public static ModifyService getInstance() {
		if (modifyService == null) {
			modifyService = new ModifyService();
		}
		return modifyService;
	}

	public int modify(ModifyRequest modifyRequest) {
		Connection connection = null;

		int result = 0;
		try {
			connection = ConnectionProvider.getConnection();
			connection.setAutoCommit(false);

			result = articleDao.update(connection, modifyRequest.getArticleNo(), modifyRequest.getTitle());
			if (result > 0) {
				result = articleContentDao.update(connection, modifyRequest.getArticleNo(), modifyRequest.getContent());
			}

			connection.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(connection);
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(connection);
		}
		return result;

	}
}
