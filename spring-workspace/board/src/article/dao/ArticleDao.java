package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import article.model.Article;
import article.model.Writer;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ArticleDao {
	private static ArticleDao articleDao;

	private ArticleDao() {

	}

	public static ArticleDao getInstance() {
		if (articleDao == null) {
			articleDao = new ArticleDao();
		}
		return articleDao;
	}

	public Article insert(Connection connection, Article article) throws SQLException {
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String insertSql = "INSERT INTO ARTICLE(ARTICLE_NO, WRITER_ID, WRITER_NAME, TITLE, REGDATE, MODDATE, READ_CNT) VALUES((SELECT NVL(MAX(ARTICLE_NO) + 1, 1) FROM ARTICLE), ?, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YYYY-MM-DD'), 0)";
		String selectSql = "SELECT ARTICLE_NO, WRITER_ID, WRITER_NAME, TITLE, REGDATE, MODDATE, READ_CNT FROM ARTICLE WHERE ARTICLE_NO = (SELECT MAX(ARTICLE_NO) FROM ARTICLE)";

		try {
			preparedStatement = connection.prepareStatement(insertSql);
			preparedStatement.setString(1, article.getWriter().getWriterId());
			preparedStatement.setString(2, article.getWriter().getWriterName());
			preparedStatement.setString(3, article.getTitle());
			int insertCount = preparedStatement.executeUpdate();

			if (insertCount > 0) {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(selectSql);
				if (resultSet.next()) {
					return new Article(resultSet.getInt("article_no"), new Writer(resultSet.getString("writer_id"), resultSet.getString("writer_name")), resultSet.getString("title"), resultSet.getString("regdate"), resultSet.getString("moddate"), resultSet.getInt("read_cnt"));
				}
			}
			return null;
		} finally {
			JdbcUtil.close(resultSet);
			JdbcUtil.close(statement);
			JdbcUtil.close(preparedStatement);
		}
	}

	public List<Article> select(Connection connection, int startRow, int size) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT ARTICLE_NO, WRITER_ID, WRITER_NAME, TITLE, REGDATE, MODDATE, READ_CNT FROM (SELECT ROWNUM AS RN, ARTICLE_NO, WRITER_ID, WRITER_NAME, TITLE, REGDATE, MODDATE, READ_CNT FROM(SELECT ARTICLE_NO, WRITER_ID, WRITER_NAME, TITLE, REGDATE, MODDATE, READ_CNT FROM ARTICLE ORDER BY ARTICLE_NO DESC)) WHERE RN BETWEEN ? AND ?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, startRow + 1);
			preparedStatement.setInt(2, startRow + size);

			resultSet = preparedStatement.executeQuery();

			List<Article> result = new ArrayList<Article>();

			while (resultSet.next()) {
				result.add(convertArticle(resultSet));
			}

			return result;
		} finally {
			JdbcUtil.close(resultSet);
			JdbcUtil.close(preparedStatement);
		}
	}

	private Article convertArticle(ResultSet resultSet) throws SQLException {
		return new Article(resultSet.getInt("ARTICLE_NO"), new Writer(resultSet.getString("WRITER_ID"), resultSet.getString("WRITER_NAME")), resultSet.getString("TITLE"), resultSet.getString("REGDATE"), resultSet.getString("MODDATE"), resultSet.getInt("READ_CNT"));
	}

	public int selectCount(Connection connection) throws SQLException {
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT COUNT(*) AS COUNT FROM ARTICLE";
		int result = 0;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				result = resultSet.getInt("COUNT");
			}
		} finally {
			JdbcUtil.close(resultSet);
			JdbcUtil.close(statement);
		}
		return result;
	}

	public Article selectByArticleNo(Connection connection, int articleNo) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT ARTICLE_NO, WRITER_ID, WRITER_NAME, TITLE, REGDATE, MODDATE, READ_CNT FROM ARTICLE WHERE ARTICLE_NO = ?";
		Article article = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, articleNo);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				article = convertArticle(resultSet);
			}
		} finally {
			JdbcUtil.close(resultSet);
			JdbcUtil.close(preparedStatement);
		}

		return article;
	}

	public int increaseReadCount(Connection connection, int articleNo) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE ARTICLE SET READ_CNT = READ_CNT + 1 WHERE ARTICLE_NO = ?";
		int result = 0;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, articleNo);

			result = preparedStatement.executeUpdate();
		} finally {
			JdbcUtil.close(preparedStatement);
		}
		return result;
	}

	public int update(Connection connection, Integer articleNo, String title) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE ARTICLE SET TITLE = ?, MODDATE = TO_CHAR(SYSDATE, 'YYYY-MM-DD') WHERE ARTICLE_NO = ?";
		int result = 0;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title);
			preparedStatement.setInt(2, articleNo);

			result = preparedStatement.executeUpdate();
		} finally {
			JdbcUtil.close(preparedStatement);
		}

		return result;
	}

	public int delete(Connection connection, int articleNo) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM ARTICLE WHERE ARTICLE_NO = ?";

		int result = 0;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, articleNo);

			result = preparedStatement.executeUpdate();
		} finally {
			JdbcUtil.close(preparedStatement);
		}

		return result;
	}
}
