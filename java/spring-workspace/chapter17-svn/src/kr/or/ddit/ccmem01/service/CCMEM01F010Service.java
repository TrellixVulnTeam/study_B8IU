package kr.or.ddit.ccmem01.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import kr.or.ddit.ccmem01.dao.CCMEM01F010Dao;
import kr.or.ddit.ccmem01.model.CCMEM01F010Vo;

//기능
public class CCMEM01F010Service {
	//싱글톤 패턴 적용
	private static CCMEM01F010Service instance = new CCMEM01F010Service();
	private CCMEM01F010Service() {}
	public static CCMEM01F010Service getInstance() {
		return instance;
	}
	
	private static final int MESSAGE_COUNT_PER_PAGE = 7;
	
	public CCMEM01F010ServiceView getSelectList(int pageNumber) {
		Connection conn = null;
		List<CCMEM01F010Vo> list = null;
		int currentPageNumber = pageNumber;
		
		CCMEM01F010Dao dao = CCMEM01F010Dao.getInstance();
		int totalCount = 0;
		int firstRow = 0;
		int endRow = 0;
		try {
			conn = ConnectionProvider.getConnection();
			
			//전체글개수
			totalCount = dao.selectCount(conn);
			
			firstRow = (pageNumber - 1)*MESSAGE_COUNT_PER_PAGE + 1;
			endRow =   firstRow + MESSAGE_COUNT_PER_PAGE - 1;
			if(totalCount>0) {
				list = dao.selectList(conn, firstRow, endRow);
			}else {
				currentPageNumber = 0;
				list = Collections.emptyList();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		return new CCMEM01F010ServiceView(list, totalCount, pageNumber,
				MESSAGE_COUNT_PER_PAGE, firstRow, endRow);
	}
}





