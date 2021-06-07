package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class WriteMessageService {
	private static WriteMessageService writeMessageService = new WriteMessageService();
	private MessageDao messageDao;
	
	private WriteMessageService() {
		messageDao = MessageDao.getInstance();
	};
	
	public static WriteMessageService getInstance() {
		return writeMessageService;
	}
	
	public int write(Message message) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return messageDao.insert(conn, message);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		return 0;
	}
}
