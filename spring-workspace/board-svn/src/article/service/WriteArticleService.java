package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import article.model.Writer;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class WriteArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public int write(WriteRequest req){
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			//int articleNo, Writer writer, String title, String regdate, String moddate, int readCnt
			Article article = new Article(0, req.getWriter(), req.getTitle(), null, null, 0);
			Article savedArticle = articleDao.insert(conn, article);
			ArticleContent content = new ArticleContent(savedArticle.getArticleNo(), req.getContent());
			contentDao.insert(conn, content);
			
			conn.commit();
			
			return savedArticle.getArticleNo();
		}catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}
}





