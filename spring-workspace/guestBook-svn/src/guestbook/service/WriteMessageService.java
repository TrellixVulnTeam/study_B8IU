package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

//방명록 기능을 제공. 신규 메시지 등록 기능
public class WriteMessageService {
	//싱글톤 패턴 구함
	private static WriteMessageService instance = new WriteMessageService();
	//생성자
	private WriteMessageService() {}
	
	public static WriteMessageService getInstance() {
		return instance;
	}
	
	public void write(Message message) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			messageDao.insert(conn, message);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
	}
}




