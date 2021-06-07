package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class GetMessageListService {
	private static GetMessageListService getMessageListService = new GetMessageListService();
	private MessageDao messageDao;
	private static final int MESSAGE_COUNT_PER_PAGE = 3;

	private GetMessageListService() {
		messageDao = MessageDao.getInstance();
	}

	public static GetMessageListService getInstance() {
		return getMessageListService;
	}

	public MessageListView getMessageList(int pageNumber) {
		Connection conn = null;
		int currentPageNumber = pageNumber;
		List<Message> messageList = null;
		int messageTotalCount = 0;
		int firstRow = 0;
		int endRow = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			messageTotalCount = messageDao.selectCount(conn);
			if (messageTotalCount > 0) {
				firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
				messageList = messageDao.selectList(conn, firstRow, endRow);
			} else {
				currentPageNumber = 0;
				messageList = Collections.emptyList();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE, firstRow, endRow);
	}
}
