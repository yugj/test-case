package test;

import java.sql.Connection;
import java.sql.Statement;

import util.DB;

public class JDBCShiWu {

	public void test() {
		Statement stmt = null;
		Connection conn = DB.getConnection();
		try {

			// ���ֹ�Զ��ύ�����û���
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			// ���ݿ���²���1
			stmt
					.executeUpdate("update firsttable Set Name='testTransaction' Where ID = 1");
			// ���ݿ���²���2
			stmt
					.executeUpdate("insert into firsttable ID = 12��Name = 'testTransaction2'");
			// �����ύ
			conn.commit();
		}

		catch (Exception ex) {
			ex.printStackTrace();
			try {
				// �������ɹ������
				conn.rollback();
			}

			catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
