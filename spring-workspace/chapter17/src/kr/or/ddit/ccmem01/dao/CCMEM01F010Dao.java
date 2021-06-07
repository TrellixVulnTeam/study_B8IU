package kr.or.ddit.ccmem01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdbc.JdbcUtil;
import kr.or.ddit.ccmem01.model.CCMEM01F010Vo;
import kr.or.ddit.ccmem01.model.CCMEM01F011Vo;

public class CCMEM01F010Dao {
	private static CCMEM01F010Dao ccmem01f010Dao = new CCMEM01F010Dao();

	private CCMEM01F010Dao() {

	}

	public static CCMEM01F010Dao getInstance() {
		return ccmem01f010Dao;
	}

	public int selectCount(Connection connection) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int res = 0;
		String sql = "SELECT COUNT (*) FROM (SELECT M.MEM_ID, M.MEM_NAME, SUM(P.PROD_SALE * C.CART_QTY) AS AMT FROM MEMBER M, PROD P, CART C WHERE M.MEM_ID = C.CART_MEMBER AND P.PROD_ID = C.CART_PROD AND C.CART_NO LIKE '2005%' GROUP BY M.MEM_ID, M.MEM_NAME ORDER BY M.MEM_ID)";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				res = resultSet.getInt(1);
			}
			return res;
		} finally {
			JdbcUtil.close(resultSet);
			JdbcUtil.close(preparedStatement);
		}
	}

	public List<CCMEM01F010Vo> selectList(Connection connection, int startRow, int endRow) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<CCMEM01F010Vo> list = new ArrayList<CCMEM01F010Vo>();

		String sql = "SELECT MEM_ID, MEM_NAME, AMT FROM (SELECT ROWNUM AS RN, MEM_ID, MEM_NAME, AMT FROM (SELECT M.MEM_ID, M.MEM_NAME, SUM(P.PROD_SALE * C.CART_QTY) AS AMT FROM MEMBER M, PROD P, CART C WHERE M.MEM_ID = C.CART_MEMBER AND P.PROD_ID = C.CART_PROD AND C.CART_NO LIKE '2005%' GROUP BY M.MEM_ID, M.MEM_NAME ORDER BY M.MEM_ID)) WHERE RN BETWEEN ? AND ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, startRow);
			preparedStatement.setInt(2, endRow);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				do {
					list.add(makeVoFromResultSet(resultSet));
				} while (resultSet.next());
				return list;
			}
			return Collections.emptyList();
		} finally {
			JdbcUtil.close(resultSet);
			JdbcUtil.close(preparedStatement);
		}
	}

	public CCMEM01F010Vo makeVoFromResultSet(ResultSet resultSet) throws SQLException {
		CCMEM01F010Vo ccmem01f010Vo = new CCMEM01F010Vo();
		ccmem01f010Vo.setMemId(resultSet.getString("mem_id"));
		ccmem01f010Vo.setMemName(resultSet.getString("mem_name"));
		ccmem01f010Vo.setAmt(resultSet.getInt("amt"));

		return ccmem01f010Vo;
	}
}
