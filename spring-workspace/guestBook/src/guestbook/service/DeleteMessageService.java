package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class DeleteMessageService {
	private static DeleteMessageService deleteMessageService = new DeleteMessageService();
	private MessageDao messageDao;

	private DeleteMessageService() {
		messageDao = MessageDao.getInstance();
	}

	public static DeleteMessageService getInstance() {
		return deleteMessageService;
	}

	public int deleteMessage(String messageId, String password) {
		Connection conn = null;
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			Message message = messageDao.select(conn, messageId);
			if (message == null) {
				throw new MessageNotFoundException("메시지 없음");
			} else if (!message.matchPassword(password)) {
				throw new InvalidPasswordException("비밀번호 불일치");
			} else {
				result = messageDao.delete(conn, messageId);
			}
			conn.commit();
		} catch (SQLException ex) {
			JdbcUtil.rollback(conn);
			result = 0;
			throw new ServiceException("삭제 실패: " + ex.getMessage(), ex);
		} catch (InvalidPasswordException | MessageNotFoundException ex) {
			JdbcUtil.rollback(conn);
			throw ex;
		} finally {
			JdbcUtil.close(conn);
		}
		return result;
	}
}
