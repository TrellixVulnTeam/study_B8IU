package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {
	private static JoinService joinService = new JoinService();
	private MemberDao memberDao;

	private JoinService() {
		memberDao = MemberDao.getInstance();
	}

	public static JoinService getInstance() {
		return joinService;
	}

	public void join(JoinRequest joinRequest) {
		Connection connection = null;
		try {
			connection = ConnectionProvider.getConnection();
			connection.setAutoCommit(false);

			Member member = memberDao.selectById(connection, joinRequest.getId());

			if (member != null) {
				JdbcUtil.rollback(connection);
				throw new DuplicateIdException();
			}

			memberDao.insert(connection, new Member(joinRequest.getId(), joinRequest.getPassword(), joinRequest.getName(), null, null));
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			JdbcUtil.rollback(connection);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(connection);
		}
	}
}
