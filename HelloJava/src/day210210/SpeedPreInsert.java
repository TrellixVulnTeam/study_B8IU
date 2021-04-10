package day210210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class SpeedPreInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, "python", "python");
		
		long now1 = Calendar.getInstance().getTimeInMillis();
		
		String sql = "INSERT INTO sample VALUES(?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(3, "7");
		pstmt.setString(1, "1");
		pstmt.setString(2, "1");
		for (int i = 0; i < 100000; i++) {
			int result = pstmt.executeUpdate();
		}
		
		long now2 = Calendar.getInstance().getTimeInMillis();
		
		pstmt.close();
		con.close();
		
		long ellapse = now2 - now1;
		System.out.println("now1 : " + now1);
		System.out.println("now2 : " + now2);
		System.out.println("ellapse : " + ellapse);
	}
}
