package day210210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MyPreDelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, "python", "python");

//		String sql = "DELETE FROM SAMPLE WHERE COL01 = '1'";
//		Statement stmt = con.createStatement();
//		int result = stmt.executeUpdate(sql);
		
		String sql = "DELETE FROM SAMPLE WHERE COL01 = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "7");
		int result = pstmt.executeUpdate();

		if (result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
//		stmt.close();
		pstmt.close();
		con.close();
	}
}
