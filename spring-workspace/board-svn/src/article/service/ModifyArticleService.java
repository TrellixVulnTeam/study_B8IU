package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

//게시글 수정 기능 제공
public class ModifyArticleService {
	//제목 수정을 위한 dao
	private ArticleDao articleDao = new ArticleDao();
	//내용 수정을 위한 dao
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public void modify(ModifyRequest modReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			//해당 게시글번호의 제목 수정
			articleDao.update(conn,modReq.getArticleNumber(),modReq.getTitle());
			//해당 게시글번호의 내용 수정
			contentDao.update(conn,modReq.getArticleNumber(),modReq.getContent());
			
			conn.commit();	//*******
		}catch (SQLException e) {
			JdbcUtil.rollback(conn); //*******
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
		
	}
	
}






