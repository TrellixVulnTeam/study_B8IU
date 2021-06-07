package kr.or.ddit.ccmem01.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import kr.or.ddit.ccmem01.dao.CCMEM01F011Dao;
import kr.or.ddit.ccmem01.model.CCMEM01F011Vo;

public class CCMEM01F011Service {
	private static CCMEM01F011Service ccmem01f011Service = new CCMEM01F011Service();
	private CCMEM01F011Dao ccmem01f011Dao = null;

	private CCMEM01F011Service() {
		ccmem01f011Dao = CCMEM01F011Dao.getInstance();
	}

	public static CCMEM01F011Service getInstance() {
		return ccmem01f011Service;
	}
	
	public CCMEM01F011Vo getSelect(String memId) {
		Connection connection = null;
		CCMEM01F011Vo member = null;
		
		try {
			connection = ConnectionProvider.getConnection();
			member = ccmem01f011Dao.select(connection, memId);
			
			return member;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil.close(connection);
		}
		return member;
	}
}
