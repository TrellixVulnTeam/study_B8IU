package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;

public class ReadArticleService {
	//글
	private ArticleDao articleDao = new ArticleDao();
	//상세글
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	//게시글 읽기 기능 구현 메소드
	public ArticleData getArticle(int articleNum) {
		Connection conn = null;
		try {
			//conn 객체 생성
			conn = ConnectionProvider.getConnection();
			//article 테이블에서 지정한 번호의 Article 객체를 구함
			Article article = articleDao.selectById(conn, articleNum);
			//게시글 데이터가 없으면 exception 발생
			if(article == null) {
				throw new ArticleNoFoundException();
			}
			//ARTICLE_CONTENT 테이블에서 지정한 번호의 ArticleContent 객체를 구함
			ArticleContent content = contentDao.selectById(conn, articleNum);
			//게시글 내용 데이터가 없으면 exception 발생
			if(content == null) {
				throw new ArticleContentNoFoundException();
			}
			//조회수를 증가시킴
			articleDao.increaseReadCount(conn, articleNum);
			
			//ArticleData 객체를 리턴함(service 패키지에서 만들기)
			//필드 구성 : private Article article;
			//			private ArticleContent content;
			return new ArticleData(article, content);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
		
		
	}
	
}



