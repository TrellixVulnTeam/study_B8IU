package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import guestbook.model.Message;
import jdbc.JdbcUtil;

//guestbook_message 테이블에 대한 CRUD 메서드를 제공함
public class MessageDao {
	//외부에서 직접 접근 불가
	private static MessageDao messageDao = new MessageDao();
	//생성자. new를 통해 객체 생성도 불가
	private MessageDao() {}
	//getInstance() 메서드를 통해서만 인스턴스를 얻을 수 있음
	public static MessageDao getInstance() {
		return messageDao;
	}
	
	//insert
	public int insert(Connection conn, Message message) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"insert into guestbook_message " +
					"(message_id, guest_name, password, message) " +
					"values((select nvl(max(message_id),0)+1 from guestbook_message),?,?,?)"
					);
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			System.out.println("MessageDao->insert->try");
			return pstmt.executeUpdate();
		}finally {
			System.out.println("MessageDao->insert->finally");
			JdbcUtil.close(pstmt);
		}
	}
	
	//select
	public Message select(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from guestbook_message where message_id = ?"
					);
			pstmt.setInt(1, messageId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Message message = new Message();
				message.setId(rs.getInt("message_id"));
				message.setGuestName(rs.getString("guest_name"));
				message.setPassword(rs.getString("password"));
				message.setMessage(rs.getString("message"));
				return message;
			}else {
				return null;
			}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<Message> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select s.*"
					+ " from("
					+ " select rownum rnum, t.message_id,t.guest_name,t.password,t.message from ("
					+ " SELECT MESSAGE_ID, GUEST_NAME,PASSWORD,MESSAGE "
					+ "     FROM GUESTBOOK_MESSAGE ORDER BY MESSAGE_ID DESC) T) s"
					+ "    where s.rnum between ? and ?"
					);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				List<Message> messageList =  new ArrayList<Message>();
				do {
					messageList.add(makeMessageFromResultSet(rs));
				}while(rs.next());
				return messageList;
			}else {
				return Collections.emptyList();
			}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	//ResultSet을 Message 형으로 변환 메소드
	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("message_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));
		return message;
	}
	
	public int delete(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"delete from guestbook_message where message_id=?"
					);
			pstmt.setInt(1, messageId);
			return pstmt.executeUpdate();
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
	//전체 레코드 개수 구함
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM GUESTBOOK_MESSAGE");
			rs.next();
			return rs.getInt(1);
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
}











