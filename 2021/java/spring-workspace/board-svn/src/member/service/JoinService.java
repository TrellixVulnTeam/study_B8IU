package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {
	//member 테이블에 memberDao를 통해서 insert 기능, Connection 객체 생성, 닫기
	
	private MemberDao memberDao = new MemberDao();
	
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			//트랜잭션 시작
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, joinReq.getId());
			//아이디 중복 문제 발생.
			if(member != null) {
				JdbcUtil.rollback(conn);	//생략 가능
				throw new DuplicateIdException();
			}
			
			memberDao.insert(conn, 
						new Member(
							joinReq.getId(),
							joinReq.getName(),
							joinReq.getPassword(),
							null,
							null)			
					);
			conn.commit();			
		}catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
}




