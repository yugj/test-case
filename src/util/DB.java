package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test",
					"root", "ygj");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static PreparedStatement prepareStat(Connection conn, String sql) {
		PreparedStatement pstat = null;
		try {
			pstat = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstat;
	}

	public static void close(Connection conn) {

		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(PreparedStatement pstat) {

		try {
			if (pstat != null) {
				pstat.close();
				pstat = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
