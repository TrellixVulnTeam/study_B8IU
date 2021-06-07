package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import article.model.Article;
import article.model.ArticleContent;
import jdbc.JdbcUtil;

public class ArticleContentDao {
	
	public ArticleContent insert(Connection conn, ArticleContent content)
			throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO ARTICLE_CONTENT(ARTICLE_NO, CONTENT) "
					+ " VALUES(?,?)"
					);
			pstmt.setInt(1, content.getArticleNo());
			pstmt.setString(2, content.getContent());
			int insertedCount = pstmt.executeUpdate();	//1건 입력됨
			if(insertedCount>0) {
				return content;
			}else {
				return null;
			}
		}finally {
			JdbcUtil.close(pstmt);
		}
	}

	public ArticleContent selectById(Connection conn, int articleNum) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"SELECT ARTICLE_NO, CONTENT"
					+ " FROM   ARTICLE_CONTENT"
					+ "	WHERE  ARTICLE_NO = ?"
					);
			pstmt.setInt(1, articleNum);
			rs = pstmt.executeQuery();
			
			ArticleContent articleContent = null;
			if(rs.next()) {
//				articleContent 
//				= new ArticleContent(rs.getInt("ARTICLE_NO"),
//									 rs.getString("ARTICLE_CONTENT"));
				articleContent = convertArticleContent(rs);
			}
			
			return articleContent;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private ArticleContent convertArticleContent(ResultSet rs) throws SQLException {
		return new ArticleContent(rs.getInt("ARTICLE_NO"),
				 rs.getString("CONTENT"));
	}
	//해당 게시글번호의 내용 수정
	public int update(Connection conn, int articleNumber, String content) 
			throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"UPDATE ARTICLE_CONTENT "
					+ " SET CONTENT = ? "
					+ " WHERE ARTICLE_NO = ?"
					);
			pstmt.setString(1, content);
			pstmt.setInt(2, articleNumber);
			return pstmt.executeUpdate();	//몇 행이 업데이트 되었는지 리턴
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
}




