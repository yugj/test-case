package test;

import java.sql.Connection;
import java.sql.Statement;

import util.DB;

public class JDBCShiWu {

	public void test() {
		Statement stmt = null;
		Connection conn = DB.getConnection();
		try {

			// 点禁止自动提交，设置回退
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			// 数据库更新操作1
			stmt
					.executeUpdate("update firsttable Set Name='testTransaction' Where ID = 1");
			// 数据库更新操作2
			stmt
					.executeUpdate("insert into firsttable ID = 12，Name = 'testTransaction2'");
			// 事务提交
			conn.commit();
		}

		catch (Exception ex) {
			ex.printStackTrace();
			try {
				// 操作不成功则回退
				conn.rollback();
			}

			catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
