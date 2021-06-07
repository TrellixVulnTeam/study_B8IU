package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import article.model.ArticleContent;
import jdbc.JdbcUtil;

public class ArticleContentDao {
	private static ArticleContentDao articleContentDao;

	private ArticleContentDao() {

	}

	public static ArticleContentDao getInstance() {
		if (articleContentDao == null) {
			articleContentDao = new ArticleContentDao();
		}
		return articleContentDao;
	}

	public ArticleContent insert(Connection connection, ArticleContent articleContent) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO ARTICLE_CONTENT(ARTICLE_NO, CONTENT) VALUES(?, ?)";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, articleContent.getArticleNo());
			preparedStatement.setString(2, articleContent.getContent());
			int insertCount = preparedStatement.executeUpdate();

			if (insertCount > 0) {
				return articleContent;
			}
			return null;
		} finally {
			JdbcUtil.close(preparedStatement);
		}
	}

	public ArticleContent selectByArticleNo(Connection connection, int articleNo) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT ARTICLE_NO, CONTENT FROM ARTICLE_CONTENT WHERE ARTICLE_NO = ?";

		ArticleContent articleContent = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, articleNo);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				articleContent = convertArticleContent(resultSet);
			}
		} finally {
			JdbcUtil.close(resultSet);
			JdbcUtil.close(preparedStatement);
		}
		return articleContent;
	}

	private ArticleContent convertArticleContent(ResultSet resultSet) throws SQLException {
		return new ArticleContent(resultSet.getInt("ARTICLE_NO"), resultSet.getString("CONTENT"));
	}

	public int update(Connection connection, Integer articleNo, String content) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE ARTICLE_CONTENT SET CONTENT = ? WHERE ARTICLE_NO = ?";
		int result = 0;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, content);
			preparedStatement.setInt(2, articleNo);

			result = preparedStatement.executeUpdate();
		} finally {
			JdbcUtil.close(preparedStatement);
		}

		return result;
	}
}
