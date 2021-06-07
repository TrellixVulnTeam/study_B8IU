package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class ChangePasswordService {
	private MemberDao memberDao = new MemberDao();
	
	public void changePassword(String userId, String curPwd, String newPwd) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, userId);
			//회원 데이터가 없음.
			if(member == null) {
				throw new MemberNotFoundException();
			}
			//form에서 입력된 curPwd와 실제 비밀번호가 일치하지 않음
			if(!member.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			//member 객체의 비밀번호를 변경
			member.changePassword(newPwd);
			//변경한 비밀번호 데이터를 member 테이블에 반영
			memberDao.update(conn, member);
			conn.commit();
		}catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		}finally {
			JdbcUtil.close(conn);
		}
	}
}





