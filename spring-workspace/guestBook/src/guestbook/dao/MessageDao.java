package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import guestbook.model.Message;
import jdbc.JdbcUtil;

public class MessageDao {
	private static MessageDao messageDao = new MessageDao();

	private MessageDao() {

	}

	public static MessageDao getInstance() {
		return messageDao;
	}

	public int insert(Connection conn, Message message) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO GUESTBOOK_MESSAGE(MESSAGE_ID, GUEST_NAME, PASSWORD, MESSAGE) VALUES((SELECT NVL(MAX(MESSAGE_ID) + 1, 1) FROM GUESTBOOK_MESSAGE), ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());

			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public Message select(Connection conn, String messageId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT MESSAGE_ID, GUEST_NAME, PASSWORD, MESSAGE FROM GUESTBOOK_MESSAGE WHERE MESSAGE_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, messageId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return makeMessageFromResultSet(rs);
			}
			return null;
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public List<Message> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT MESSAGE_ID, GUEST_NAME, PASSWORD, MESSAGE FROM (SELECT ROWNUM AS RN, MESSAGE_ID, GUEST_NAME, PASSWORD, MESSAGE FROM (SELECT MESSAGE_ID, GUEST_NAME, PASSWORD, MESSAGE FROM GUESTBOOK_MESSAGE ORDER BY MESSAGE_ID DESC) M) WHERE RN BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			List<Message> messageList = new ArrayList<Message>();
			if (rs.next()) {
				do {
					messageList.add(makeMessageFromResultSet(rs));
				} while (rs.next());
				return messageList;
			}
			return Collections.emptyList();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setMessageId(rs.getInt("MESSAGE_ID"));
		message.setGuestName(rs.getString("GUEST_NAME"));
		message.setPassword(rs.getString("PASSWORD"));
		message.setMessage(rs.getString("MESSAGE"));
		return message;
	}

	public int delete(Connection conn, String messageId) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM GUESTBOOK_MESSAGE WHERE MESSAGE_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, messageId);
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT COUNT(*) FROM GUESTBOOK_MESSAGE";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
}
