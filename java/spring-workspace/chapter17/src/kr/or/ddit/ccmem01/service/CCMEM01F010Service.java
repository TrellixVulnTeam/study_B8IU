package kr.or.ddit.ccmem01.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import kr.or.ddit.ccmem01.dao.CCMEM01F010Dao;
import kr.or.ddit.ccmem01.model.CCMEM01F010Vo;

public class CCMEM01F010Service {
	private static CCMEM01F010Service ccmem01f010Service = new CCMEM01F010Service();
	private static final int MESSAGE_COUNT_PER_PAGE = 7;
	private CCMEM01F010Dao ccmem01f010Dao = null;

	private CCMEM01F010Service() {
		ccmem01f010Dao = CCMEM01F010Dao.getInstance();
	}

	public static CCMEM01F010Service getInstance() {
		return ccmem01f010Service;
	}

	public CCMEM01F010ServiceView getSelectList(int pageNumber) {
		Connection connection = null;
		List<CCMEM01F010Vo> list = null;

		int firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
		int endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
		int totalCount = 0;

		try {
			connection = ConnectionProvider.getConnection();

			totalCount = ccmem01f010Dao.selectCount(connection);
			if (0 < totalCount) {
				list = ccmem01f010Dao.selectList(connection, firstRow, endRow);
			} else {
				list = Collections.emptyList();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil.close(connection);
		}
		return new CCMEM01F010ServiceView(list, totalCount, pageNumber, MESSAGE_COUNT_PER_PAGE, firstRow, endRow);
	}
}
