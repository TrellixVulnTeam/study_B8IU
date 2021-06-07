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

public class ArticleDao {
	public Article insert(Connection conn, Article article) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(
"INSERT INTO ARTICLE(ARTICLE_NO, WRITER_ID, WRITER_NAME, TITLE, REGDATE, MODDATE, READ_CNT)"
+ " VALUES("
+ " (SELECT NVL(MAX(ARTICLE_NO),0)+1 FROM ARTICLE),?,?,?,TO_CHAR(SYSDATE,'YYYY-MM-DD'),'',0)"
			);
			pstmt.setString(1, article.getWriter().getWriterId());
			pstmt.setString(2, article.getWriter().getWriterName());
			pstmt.setString(3, article.getTitle());
			
			int insertCount = pstmt.executeUpdate();	//1이 리턴됨
			//insert가 잘 되었다면. article 객체에 insert 결과를 저장함
			if(insertCount>0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(
						"SELECT ARTICLE_NO, WRITER_ID, WRITER_NAME, TITLE, REGDATE, MODDATE, READ_CNT "
						+ " FROM ARTICLE "
						+ " WHERE ARTICLE_NO = (SELECT MAX(ARTICLE_NO) FROM ARTICLE)"
						);
				if(rs.next()) {
					return new Article(
							rs.getInt("ARTICLE_NO"),
							article.getWriter(),
							article.getTitle(),
							rs.getString("REGDATE"),
							rs.getString("MODDATE"),
							rs.getInt("READ_CNT")
							);
				}
			}
			return null;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<Article> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(
						"select s.ARTICLE_NO, s.WRITER_ID, s.WRITER_NAME, s.TITLE, s.REGDATE, s.MODDATE, s.READ_CNT"
						+ " from"
						+ " ("
						+ " select rownum rnum, T.* from"
						+ " ("
						+ " select ARTICLE_NO, WRITER_ID, WRITER_NAME, TITLE, REGDATE, MODDATE, READ_CNT"
						+ " from article"
						+ " order by ARTICLE_NO desc"
						+ " ) T"
						+ " )s"
						+ " where s.rnum between ? and ?"
					);
			//startRow는 0부터 시작하므로 1을 더해줌
			pstmt.setInt(1, startRow+1);
			//startRow가 0이면 0 + 10 = 10
			pstmt.setInt(2, startRow + size);
			rs = pstmt.executeQuery();
			List<Article> result = new ArrayList<>();	//******
			while(rs.next()) {
				result.add(convertArticle(rs));
			}
			return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}//end select
	
	private Article convertArticle(ResultSet rs) throws SQLException {
		return new Article(rs.getInt("ARTICLE_NO"),
					new Writer(rs.getString("WRITER_ID"), rs.getString("WRITER_NAME")),
					rs.getString("TITLE"),
					rs.getString("REGDATE"),
					rs.getString("MODDATE"),
					rs.getInt("READ_CNT")
				);
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM ARTICLE");
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public Article selectById(Connection conn, int articleNum) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"SELECT ARTICLE_NO,WRITER_ID,"
					+ " WRITER_NAME,TITLE,REGDATE,"
					+ " MODDATE,READ_CNT"
					+ " FROM ARTICLE"
					+ " WHERE  ARTICLE_NO = ?"
					);
			pstmt.setInt(1, articleNum);
			rs = pstmt.executeQuery();
			Article article = null;
			if(rs.next()) {
				article = convertArticle(rs);
			}
			return article;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void increaseReadCount(Connection conn, int articleNum) 
			throws SQLException {
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(
				"update article "
				+ " set read_cnt = read_cnt+1 "
				+ " where article_no = ?"
				);
		pstmt.setInt(1, articleNum);
		pstmt.executeUpdate();
	}
	//해당 게시글번호의 제목 수정
	public int update(Connection conn, int articleNumber, String title) 
		throws SQLException{
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"UPDATE ARTICLE "
					+ " SET TITLE = ?, MODDATE = SYSDATE " 
					+ " WHERE ARTICLE_NO = ?"
					);
			pstmt.setString(1, title);
			pstmt.setInt(2, articleNumber);
			return pstmt.executeUpdate();	//몇 행의 데이터가 업데이트 되었는지..
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
}









