package day210209;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySelect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, "python", "python");

		String sql = "select * from sample";
		Statement stmt = con.createStatement();

		ResultSet result = stmt.executeQuery(sql);
		while (result.next()) {
			String col1 = result.getString("col01");
			String col2 = result.getString("col02");
			String col3 = result.getString("col03");
			System.out.println("col1 : " + col1 + ", col2 : " + col2 + ", col3 : " + col3);
		}
		stmt.close();
		con.close();
	}
}
