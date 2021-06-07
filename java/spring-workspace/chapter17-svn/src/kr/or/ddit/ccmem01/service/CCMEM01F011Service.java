package kr.or.ddit.ccmem01.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import kr.or.ddit.ccmem01.dao.CCMEM01F011Dao;
import kr.or.ddit.ccmem01.model.CCMEM01F011Vo;

public class CCMEM01F011Service {
	private static CCMEM01F011Service instance = new CCMEM01F011Service();
	private CCMEM01F011Service() {}
	public static CCMEM01F011Service getInstance() {
		return instance;
	}
	
	public CCMEM01F011Vo getMemberDetail(String memId) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		
		CCMEM01F011Dao dao = CCMEM01F011Dao.getInstance();
		CCMEM01F011Vo vo = dao.getMemberDetail(conn, memId);
		
		return vo;
	}
}




