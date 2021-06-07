package guestbook.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

//방명록 기능을 제공. 방명록에 등록된 메시지 목록을 제공
public class GetMessageListService {
	//싱글톤
	private static GetMessageListService instance = new GetMessageListService();
	private GetMessageListService() {}
	public  static GetMessageListService getInstance() {
		return instance;
	}
	//한 페이지에 보여줄 메시지 개수
	private static final int MESSAGE_COUNT_PER_PAGE = 3;
	
	public MessageListView getMessageList(int pageNumber) {
		Connection conn = null;
		int currentPageNumber = pageNumber;
		List<Message> messageList = null;
		int messageTotalCount = 0;
		int firstRow = 0;
		int endRow = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			messageTotalCount = messageDao.selectCount(conn);
			
			if(messageTotalCount>0) {
				firstRow = (pageNumber-1)*MESSAGE_COUNT_PER_PAGE+1;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
				messageList = messageDao.selectList(conn, firstRow, endRow);
			}else {
				currentPageNumber = 0;
				messageList = Collections.emptyList();
			}
		}catch(SQLException e) {
			e.getMessage();
		}finally {
			JdbcUtil.close(conn);
		}
//		return messageList;
		return new MessageListView(messageList, messageTotalCount,
				currentPageNumber, MESSAGE_COUNT_PER_PAGE,
				firstRow, endRow);
	}
}





