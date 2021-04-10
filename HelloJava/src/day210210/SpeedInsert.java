package day210210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class SpeedInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, "python", "python");
		Statement stmt = con.createStatement();
		
		long now1 = Calendar.getInstance().getTimeInMillis();
		
		for (int i = 0; i < 100000; i++) {
			String sql = "INSERT INTO sample VALUES('4', '4', '4')";
			int result = stmt.executeUpdate(sql);
		}
		
		long now2 = Calendar.getInstance().getTimeInMillis();
		
		stmt.close();
		con.close();
		
		long ellapse = now2 - now1;
		System.out.println("now1 : " + now1);
		System.out.println("now2 : " + now2);
		System.out.println("ellapse : " + ellapse);
	}
}
