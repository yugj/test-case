package test.jdbc_oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDML {

	public static void main(String[] args) {
		Statement stmt = null;
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//new oracle.jdbc.driver.OracleDriver();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "ygj");
			stmt = conn.createStatement();
			String sql = "insert into test values (3, 'helloworld')";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
					stmt = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
