package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

//방명록 기능을 제공. 메시지를 삭제 기능
public class DeleteMessageService {
	//싱글턴
	private static DeleteMessageService instance = new DeleteMessageService();
	private DeleteMessageService() {}
	public static DeleteMessageService getInstances() {
		return instance;
	}
	
	//deleteMessage
	public void deleteMessage(int messageId, String password) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			MessageDao messageDao = MessageDao.getInstance();
			Message message = messageDao.select(conn, messageId);
			if(message == null) {
				throw new MessageNotFoundException("메시지 없음");
			}
			//jsp로부터 온 password와 
			//message객체의 password필드의 값이 같지 않다면
			if(!message.matchPassword(password)) {
				throw new InvalidPasswordException("올바르지 않은 비밀번호가 입력되었습니다.");
			}
			messageDao.delete(conn, messageId);
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("삭제 실패 : " + e.getMessage(), e);
		}catch(InvalidPasswordException | MessageNotFoundException ex){
			JdbcUtil.rollback(conn);
			throw ex;
		}finally {
			JdbcUtil.close(conn);
		}
	}
}





