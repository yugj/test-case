package test.date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import util.DB;

public class TestDateFormat{

	public static void main(String[] args) {
		ResultSet rs = null;
		Connection conn = DB.getConnection();
		String sql = "insert into testDateFormat values(null,?)";
		PreparedStatement pstat = DB.prepareStat(conn, sql);
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			//write
			pstat.setString(1, df.format(date));
			pstat.executeUpdate();
			
			
			//read
			pstat = DB.prepareStat(conn, "select * from testDateFormat");
			rs = pstat.executeQuery();
			while(rs.next()) {
				System.out.println(df.format(rs.getTimestamp("date")));
				Date nnn = new Date(rs.getTimestamp("date").getTime());
				String nnnS = df.format(nnn);
				System.out.println("*********************");
				System.out.println(rs.getTimestamp("date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}