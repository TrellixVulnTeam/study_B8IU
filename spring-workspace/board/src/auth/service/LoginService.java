package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class LoginService {
	private static LoginService loginService = new LoginService();
	private MemberDao memberDao;

	private LoginService() {
		memberDao = MemberDao.getInstance();
	}

	public static LoginService getInstance() {
		return loginService;
	}

	public User login(String memberid, String password) {
		Connection connection = null;
		Member member = null;
		try {
			connection = ConnectionProvider.getConnection();

			member = memberDao.selectById(connection, memberid);

			if (member == null || !member.matchPassword(password)) {
				throw new LoginFailException();
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(connection);
		}
		return new User(member.getMemberid(), member.getName());
	}
}
