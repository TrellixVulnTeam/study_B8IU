package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	//member 테이블에서 memberid 컬럼 값이 id 파라미터와 동일한 데이터를 조회
	public Member selectById(Connection conn, String id) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(
					"SELECT MEMBERID"
					+ "     , NAME"
					+ "     , PASSWORD"
					+ "     , EMAIL"
					+ "     , TO_CHAR(REGDATE,'YYYY-MM-DD') AS REGDATE"
					+ " FROM MEMBER"
					+ " WHERE MEMBERID = ?"
					);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if(rs.next()) {
				member = new Member(
						rs.getString("memberid"),
						rs.getString("name"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getString("regdate")
					);
			}
			return member;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	//member 테이블에 데이터를 추가함
	public void insert(Connection conn, Member mem) throws SQLException{
		try(
			PreparedStatement pstmt = 
			conn.prepareStatement(
					"INSERT INTO MEMBER(MEMBERID,NAME,PASSWORD,EMAIL,REGDATE) "
					+ " VALUES(?,?,?,?,SYSDATE)"
					)
				){
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setString(4, mem.getEmail());
			pstmt.executeUpdate();
		}
	}
	
	//update
	public void update(Connection conn, Member member) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					" UPDATE MEMBER"
					+ " SET    NAME=?, PASSWORD = ?"
					+ " WHERE  MEMBERID = ? "
					);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getId());
			pstmt.executeUpdate();
		}catch (SQLException e) {
		}
	}
	
}










