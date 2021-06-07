package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	private static MemberDao memberDao = new MemberDao();

	private MemberDao() {

	}

	public static MemberDao getInstance() {
		return memberDao;
	}

	public Member selectById(Connection connection, String memberid) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT MEMBERID, PASSWORD, NAME, EMAIL, TO_CHAR(REGDATE, 'YYYY-MM-DD') AS REGDATE FROM MEMBER WHERE MEMBERID = ?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return makeVoFromResultSet(resultSet);
			}
		} finally {
			JdbcUtil.close(resultSet);
			JdbcUtil.close(preparedStatement);
		}
		return null;
	}

	private Member makeVoFromResultSet(ResultSet resultSet) throws SQLException {
		Member member = new Member();
		member.setMemberid(resultSet.getString("memberid"));
		member.setPassword(resultSet.getString("password"));
		member.setName(resultSet.getString("name"));
		member.setEmail(resultSet.getString("email"));
		member.setRegdate(resultSet.getString("regdate"));

		return member;
	}

	public int insert(Connection connection, Member member) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO MEMBER (MEMBERID, PASSWORD, NAME, EMAIL, REGDATE) VALUES (?, ?, ?, ?, SYSDATE)";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getMemberid());
			preparedStatement.setString(2, member.getPassword());
			preparedStatement.setString(3, member.getName());
			preparedStatement.setString(4, member.getEmail());

			return preparedStatement.executeUpdate();
		} finally {
			JdbcUtil.close(preparedStatement);
		}
	}

	public int update(Connection connection, Member member) throws SQLException {
		String sql = "UPDATE MEMBER SET NAME = ?, PASSWORD = ? WHERE MEMBERID = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getName());
			preparedStatement.setString(2, member.getPassword());
			preparedStatement.setString(3, member.getMemberid());
			
			return preparedStatement.executeUpdate();
		} finally {
			JdbcUtil.close(preparedStatement);
		}
	}
	
}
