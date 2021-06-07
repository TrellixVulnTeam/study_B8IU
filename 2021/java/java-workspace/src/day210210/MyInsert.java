package day210210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.xml.crypto.Data;

public class MyInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, "python", "python");
		Statement stmt = con.createStatement();

		String sql = "INSERT INTO sample VALUES('4', '4', '4')";
		int result = stmt.executeUpdate(sql);
		
		if (result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		stmt.close();
		con.close();
	}
}
