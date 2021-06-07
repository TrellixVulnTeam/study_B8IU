package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class LoginService {
	//객체 생성
	private MemberDao memberDao = new MemberDao();
	
	public User login(String id, String password) {
		try {
			//conn 객체 생성
			Connection conn = ConnectionProvider.getConnection();
			//conn 객체와 id를 파라미터로 memberDao.selectById 메소드 실행
			Member member = memberDao.selectById(conn, id);
			//만약 member 객체가 null이면 LoginFailException() 메소드 실행
			if(member == null) {
				throw new LoginFailException();
			}
			if(!member.matchPassword(password)) {
				throw new LoginFailException();
			}
			return new User(member.getId(), member.getName());
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
}
