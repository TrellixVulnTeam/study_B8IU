package day210210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class MyPreInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, "python", "python");
		
		String sql = "INSERT INTO sample VALUES(?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(3, "7");
		pstmt.setString(1, "1");
		pstmt.setString(2, "1");
		int result = pstmt.executeUpdate(sql);
		
		pstmt.close();
		con.close();
	}
}
