package kr.or.ddit.ccmem01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import kr.or.ddit.ccmem01.model.CCMEM01F011Vo;

public class CCMEM01F011Dao {
	private static CCMEM01F011Dao ccmem01f010Dao = new CCMEM01F011Dao();

	private CCMEM01F011Dao() {

	}

	public static CCMEM01F011Dao getInstance() {
		return ccmem01f010Dao;
	}

	public CCMEM01F011Vo select(Connection connection, String memId) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT MEM_ID, MEM_NAME, MEM_ADD1, MEM_ADD2, TO_CHAR(MEM_BIR, 'YYYY-MM-DD') AS MEM_BIR, MEM_HP, MEM_MAIL, MEM_JOB, MEM_LIKE, MEM_MILEAGE, SUM(PROD_SALE * CART_QTY) AS AMT FROM MEMBER M, CART C, PROD P WHERE M.MEM_ID = C.CART_MEMBER AND C.CART_PROD = P.PROD_ID AND MEM_ID = ? GROUP BY MEM_ID, MEM_NAME, MEM_ADD1, MEM_ADD2, MEM_BIR, MEM_HP, MEM_MAIL, MEM_JOB, MEM_LIKE, MEM_MILEAGE";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return makeVoFromResultSet(resultSet);
			}
			return null;
		} finally {
			JdbcUtil.close(resultSet);
			JdbcUtil.close(preparedStatement);
		}
	}

	public CCMEM01F011Vo makeVoFromResultSet(ResultSet resultSet) throws SQLException {
		CCMEM01F011Vo ccmem02f010Vo = new CCMEM01F011Vo();
		ccmem02f010Vo.setMemId(resultSet.getString("mem_id"));
		ccmem02f010Vo.setMemName(resultSet.getString("mem_name"));
		ccmem02f010Vo.setMemAdd1(resultSet.getString("mem_add1"));
		ccmem02f010Vo.setMemAdd2(resultSet.getString("mem_add2"));
		ccmem02f010Vo.setMemBir(resultSet.getString("mem_bir"));
		ccmem02f010Vo.setMemHp(resultSet.getString("mem_hp"));
		ccmem02f010Vo.setMemMail(resultSet.getString("mem_mail"));
		ccmem02f010Vo.setMemJob(resultSet.getString("mem_job"));
		ccmem02f010Vo.setMemLike(resultSet.getString("mem_like"));
		ccmem02f010Vo.setMemMileage(resultSet.getInt("mem_mileage"));
		ccmem02f010Vo.setAmt(resultSet.getInt("amt"));
		return ccmem02f010Vo;
	}
}
