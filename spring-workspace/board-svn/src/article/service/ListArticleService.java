package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.connection.ConnectionProvider;

public class ListArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private int size = 10;
	
	public ArticlePage getArticlePage(int pageNum) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			//전체 글개수(total)
			int total = articleDao.selectCount(conn);
			//1페이지 : (1 - 1) * 10 => 0
			//2페이지 : (2 - 1) * 10 => 10
			//3페이지 : (3 - 1 ) * 10 => 20
			List<Article> content = articleDao.select(conn, (pageNum-1)*size, size);
			//int total, int currentPage, int size, List<Article> content
			return new ArticlePage(total, pageNum, size, content);
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}



