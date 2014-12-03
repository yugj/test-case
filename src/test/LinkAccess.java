package test;

import java.sql.*;

/**
 * @����: TODO java����Access���ݿ�
 * 
 *      <p>
 *      ����Access���ݿ⣺
 * 
 *      <br>
 *      1.����Access���ݿ�db.mdb,������tUser���ֶ�������: ID�ֶκ�Password�ֶΡ�</br> <br>
 *      2���򿪿������ -> ������ -> ����Դ(ODBC), ѡ��"ϵͳDSN", Ҳ����ѡ��"�û�DSN"ѡ�,
 *      ϵͳ��DSN��ÿ���û������ÿɱ������ʱ���ֵ�Ȩ�����⣬��������ӡ��� ѡ��Driver do Microsoft Access
 *      (*.mdb)��,���"���", �����ĶԻ����ｫ"����Դ��"һ����������Դȡ������,����MyDataBase ��
 *      ��"ѡ��"���ҵ���ոս��������ݿ��ļ�db2010.mdb�����һ��ODBC����Դ�����ú��ˡ�
 *      ���˴��������ļ�������Office2010�����ģ�ע�ⴴ����ʱ�����ʹ��Office����ģʽ���������Ӳ��ϵģ�
 *      </p>
 * 
 * <br>
 *      Java��Access���ݿ�����ӣ�</br>
 *      <p>
 *      JDBC, ȫ��ΪJava DataBase Connectivity standard, ����һ����������Ӧ�ó���ӿڣ�API��,
 *      ͨ�����ɷ��ʸ����ϵ���ݿ⡣JDBCҲ��java��������һ���֡� JDBC������ص����������ھ���Ĺ�ϵ���ݿ⡣��ODBC (Open
 *      Database Connectivity)����, JDBC API
 *      �ж�����һЩJava��ֱ�������ʾ�����ݿ�����ӣ�connections��, SQL��䣨SQL statements��, �������result
 *      sets���Լ����������ݿ����, ʹ��Java�����ܷ���������ݿ⽻�����������õĽ���� ʹ��JDBC, ����Java���򣨰���Java
 *      applications , applets��servlet������ͨ��SQL����洢�����ݿ��еĹ��̣�stored
 *      procedures������ȡ���ݿ⡣ Ҫͨ��JDBC����ȡĳһ�ض������ݿ⣬��������Ӧ��JDBC
 *      driver�������������������ݿ�ĳ����ṩ��������JDBC API��������ݿ�֮��������� ͨ����Java��������ʹ��JDBC
 *      API����JDBC Driver Manager��������JDBC Driver Manager����ָ����JDBC drivers,
 *      �Ժ�Ϳ���ͨ��JDBC API����ȡ���ݿ⡣ JDBC driver �������ض����ݿ��һ��ʵʩ��JDBC�ӿڵ��༯��
 *      "JDBC-ODBC bridge driver"�������͵�driver��ʹ�ͻ���ͨ��JDBC�������ӵ�һ��ʹ��ODBC
 *      driver�����ݿ⡣ʹ������driver��Ҫÿ���ͻ��˻�����װ�����ݿ��Ӧ��ODBC driver������ODBC
 *      driver��һ��Ҫ��Java���ݡ�
 *      </p>
 * 
 * <br>
 *      (Access�н��õ������ݿ�����Ϊdb,��ΪtUser��</br>
 *      <p>
 *      1. ����ʹ��Java�Դ���Class���е�forName��̬����������������. <br>
 *      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); <br>
 *      2. Ȼ������������ݿ���,����Ҫ�õ�java.sql���е�Connection������һ������
 *      ������DriverManager�������ľ�̬����getConnection����������ӡ� <br>
 * 
 *      Connection
 *      con=DriverManager.getConnection("jdbc:odbc:����Դ����","����Դ�û���","����Դ����");
 * 
 *      <br>
 *      ���磺 String sourceDB="jdbc:odbc:MyDataBase"; <br>
 *      Connection con=DriverManager.getConnection(sourceDB,"db2010","pass");
 * 
 *      <br>
 *      ע�ͣ� �����ַ����ֱ�Ϊ:sourceDB,"db2010","pass",���û�������Ϊ: "" <br>
 * 
 *      3. ����Statement��������Statement����������SQL��������ݿ�ִ��SQL��� ��ʱ��Ҫ�õ� Statement�ӿ����е�
 *      executeQuery �� executeUpdate �ķ���, executeQuery
 *      ������Ҫһ���ַ���������Statement�Ὣ����ַ����������ݿ⣬���ݿ�ͻ�ִ������ַ����������SQL��������ؽ��, ��󽫲��������
 *      ResultSet ���󷵻س���.
 *      </p>
 * 
 * @������: Access
 * @���ߣ� ���Ӿ�
 * @���䣺 songyanjun_stars@126.com
 * @���ڣ� Feb 27, 2012 9:19:09 AM
 */
public class LinkAccess {

	/**
	 * @����: TODO java����Access���ݿ� �������
	 * 
	 * @����: main
	 * @�趨:
	 * @param args
	 * @��������: void
	 */
	public static void main(String[] args) {

		Connection con;

		Statement sql;

		ResultSet rs;

		try {
			// ����Access���ݿ���������
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}

		catch (ClassNotFoundException e) {
			System.out.println("" + e);// ����̨��ӡ�쳣
		}

		try {
			// DriverManager.getConnection("ָ����������Դ","���ݿ�����","���ݿ�����"); ���û���������
			// DriverManager.getConnection("ָ����������Դ","���ݿ�����","")
			con = DriverManager.getConnection("jdbc:odbc:MyDataBase",
					"db20101.mdb", "pass");

			sql = con.createStatement();

			rs = sql.executeQuery("Select * FROM tUser");

			while (rs.next()) {
				String ID = rs.getString(1); // ������ݿ��һ��

				String Uid = rs.getString(2);

				System.out.println("����ID: " + ID); // �����Ϣ

				System.out.println("�û�ID: " + Uid);
			}
			con.close();// �ر�����

		} catch (SQLException e) {
			System.out.println("" + e);// ����̨��ӡ�쳣
		}

	}

}
