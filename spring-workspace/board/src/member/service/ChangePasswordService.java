package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class ChangePasswordService {
	private static ChangePasswordService changePasswordService = new ChangePasswordService();
	private MemberDao memberDao;

	private ChangePasswordService() {
		memberDao = MemberDao.getInstance();
	}

	public static ChangePasswordService getInstance() {
		return changePasswordService;
	}

	public void changePassword(String memberid, String currentPassword, String newPassword) {
		Connection connection = null;

		try {
			connection = ConnectionProvider.getConnection();
			connection.setAutoCommit(false);
			Member member = memberDao.selectById(connection, memberid);
			if (member == null) {
				throw new MemberNotFoundException();
			}
			
			if (!member.matchPassword(currentPassword)) {
				throw new InvalidPasswordException();
			}
			
			member.changePassword(newPassword);
			memberDao.update(connection, member);
		} catch (SQLException e) {
			JdbcUtil.rollback(connection);
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(connection);
		}
	}
}
