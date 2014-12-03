package test.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class TestDate_mysql {

	public static void main(String[] args) {
		Connection conn = null; // 连接对象
		Statement stat = null; // Statement对象（SQL语句）
		ResultSet rs = null; // 结果集对象
		java.sql.PreparedStatement pstat = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost/testdate",
					"root", "ygj");
			stat = conn.createStatement();
			Calendar c = Calendar.getInstance();
			Date d = c.getTime();
			String a = d.toLocaleString();
			pstat = conn.prepareStatement("insert into dt values(null,?)");
			pstat.setString(1,a);
			pstat.executeUpdate();
			
			rs = stat.executeQuery("select * from dt");
			Timestamp ts = null;
			while(rs.next()) {
				ts = rs.getTimestamp("dt");
				System.out.println(ts);
				System.out.println(rs.getTimestamp("dt"));
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if(stat != null) {
					stat.close();
					stat = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;

		}

	}

}
