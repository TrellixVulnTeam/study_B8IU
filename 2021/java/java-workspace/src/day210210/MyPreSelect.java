package day210210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyPreSelect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, "python", "python");

		
//		String sql = "select * from sample";
//		Statement stmt = con.createStatement();
//		ResultSet result = stmt.executeQuery(sql);

		String sql = "select * from sample where col01 = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "3");
		
		ResultSet result = pstmt.executeQuery();
		
		int index = 0;
		System.out.print("\tcol1");
		System.out.print("\tcol2");
		System.out.println("\tcol3");
		while (result.next()) {
			String col1 = result.getString("col01");
			String col2 = result.getString("col02");
			String col3 = result.getString("col03");
			System.out.print(++index);
			System.out.print("\t" + col1);
			System.out.print("\t" + col2);
			System.out.println("\t" + col3);
		}
//		stmt.close();
		pstmt.close();
		con.close();
	}
}
