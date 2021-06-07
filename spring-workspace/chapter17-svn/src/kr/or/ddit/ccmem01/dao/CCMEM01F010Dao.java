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

public class CCMEM01F010Dao {
	private static CCMEM01F010Dao instance = new CCMEM01F010Dao();
	private CCMEM01F010Dao() {}
	public static CCMEM01F010Dao getInstance() {
		return instance;
	}

	public List<CCMEM01F010Vo> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(
					"SELECT U.RNUM, U.MEM_ID , U.MEM_NAME , U.AMT"
					+ " FROM"
					+ " ("
					+ "    SELECT ROWNUM RNUM, T.*"
					+ "    FROM ("
					+ "        SELECT A.MEM_ID"
					+ "             , A.MEM_NAME"
					+ "             , SUM(B.PROD_SALE * C.CART_QTY) AS AMT"
					+ "        FROM  MEMBER A, PROD B, CART C"
					+ "        WHERE A.MEM_ID = C.CART_MEMBER"
					+ "        AND   B.PROD_ID = C.CART_PROD"
					+ "        AND   C.CART_NO LIKE '2005%'"
					+ "        GROUP BY A.MEM_ID, A.MEM_NAME"
					+ "        ORDER BY A.MEM_ID"
					+ "    ) T"
					+ " ) U"
					+ " WHERE U.RNUM BETWEEN ? AND ?"
					);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				List<CCMEM01F010Vo> list = new ArrayList<CCMEM01F010Vo>();
				do {
					list.add(makeVoFromResultSet(rs));
				}while(rs.next());
				
				return list;
			}else {
				return Collections.emptyList();
			}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
	}
	
	public int selectCount(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT COUNT(*) TOT_CNT	"
					+ " FROM	"
					+ " (	"
					+ "    SELECT A.MEM_ID	"
					+ "         , A.MEM_NAME	"
					+ "         , SUM(B.PROD_SALE * C.CART_QTY) AS AMT	"
					+ "    FROM  MEMBER A, PROD B, CART C	"
					+ "    WHERE A.MEM_ID = C.CART_MEMBER	"
					+ "    AND   B.PROD_ID = C.CART_PROD	"
					+ "    AND   C.CART_NO LIKE '2005%'	"
					+ "    GROUP BY A.MEM_ID, A.MEM_NAME	"
					+ "    ORDER BY A.MEM_ID	"
					+ " ) T"
					);
			rs.next();
			return rs.getInt(1);
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	private CCMEM01F010Vo makeVoFromResultSet(ResultSet rs) throws SQLException {
		CCMEM01F010Vo vo = new CCMEM01F010Vo();
		vo.setMemId(rs.getString("mem_id"));
		vo.setMemName(rs.getString("mem_name"));
		vo.setAmt(rs.getInt("amt"));
		return vo;
	}

}





