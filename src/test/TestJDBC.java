package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {
	public static void main(String[] args) throws Exception {
		PreparedStatement pstat = null;
		Connection conn = null;
		ResultSet rs = null;

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/test",
				"root", "ygj");
		String sql = "select * from users where id > ?";
		//String sql2 = "update users set name = 'hello world' where id =?";
		//pstat = conn.prepareStatement(sql2);
		pstat = conn.prepareStatement(sql);
		pstat.setInt(1, 10);
		//pstat.executeUpdate();
		rs = pstat.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt("id") + " ");
			System.out.print(rs.getString("name") + " ");
			System.out.print(rs.getString("passwd") + " ");
			System.out.println();
			
			
		}
		
		

	}

}
