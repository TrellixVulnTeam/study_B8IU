package kr.or.ddit.ccmem01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdbc.JdbcUtil;
import kr.or.ddit.ccmem01.model.CCMEM01F010Vo;
import kr.or.ddit.ccmem01.model.CCMEM01F011Vo;

//CRUD √≥∏Æ
public class CCMEM01F011Dao {
	//ΩÃ±€≈Ê
	private static CCMEM01F011Dao instance = new CCMEM01F011Dao();
	private CCMEM01F011Dao() {}
	public static CCMEM01F011Dao getInstance() {
		return instance;
	}

	public CCMEM01F011Vo getMemberDetail(Connection conn, String memId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(
					"SELECT MEM_ID, MEM_NAME, MEM_LIKE, MEM_JOB, MEM_ZIP, MEM_ADD1, MEM_ADD2, MEM_HP"
					+ " FROM   MEMBER"
					+ " WHERE  MEM_ID = ?"
					);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			rs.next();
			return makeVoFromResultSet(rs);
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private CCMEM01F011Vo makeVoFromResultSet(ResultSet rs) throws SQLException {
		CCMEM01F011Vo vo = new CCMEM01F011Vo();
		vo.setMemId(rs.getString("mem_id"));
		vo.setMemName(rs.getString("mem_name"));
		vo.setMemLike(rs.getString("mem_like"));
		vo.setMemJob(rs.getString("mem_job"));
		vo.setMemZip(rs.getString("mem_zip"));
		vo.setMemAdd1(rs.getString("mem_add1"));
		vo.setMemAdd2(rs.getString("mem_add2"));
		vo.setMemHp(rs.getString("mem_hp"));
		
		return vo;
	}

}





