package test;

import java.sql.*;

/**
 * @描述: TODO java连接Access数据库
 * 
 *      <p>
 *      建立Access数据库：
 * 
 *      <br>
 *      1.建立Access数据库db.mdb,并创建tUser表，字段有两个: ID字段和Password字段。</br> <br>
 *      2．打开控制面板 -> 管理工具 -> 数据源(ODBC), 选择"系统DSN", 也可以选择"用户DSN"选项卡,
 *      系统的DSN对每个用户都适用可避免调试时出现的权限问题，单击“添加”， 选择“Driver do Microsoft Access
 *      (*.mdb)”,点击"完成", 弹出的对话框里将"数据源名"一项给你的数据源取个名字,比如MyDataBase 。
 *      点"选择"，找到你刚刚建立的数据库文件db2010.mdb，如此一个ODBC数据源就配置好了。
 *      （此处的数据文件我是用Office2010创建的，注意创建的时候必须使用Office兼容模式。否则连接不上的）
 *      </p>
 * 
 * <br>
 *      Java与Access数据库的连接：</br>
 *      <p>
 *      JDBC, 全称为Java DataBase Connectivity standard, 它是一个面向对象的应用程序接口（API）,
 *      通过它可访问各类关系数据库。JDBC也是java核心类库的一部分。 JDBC的最大特点是它独立于具体的关系数据库。与ODBC (Open
 *      Database Connectivity)类似, JDBC API
 *      中定义了一些Java类分别用来表示与数据库的连接（connections）, SQL语句（SQL statements）, 结果集（result
 *      sets）以及其它的数据库对象, 使得Java程序能方便地与数据库交互并处理所得的结果。 使用JDBC, 所有Java程序（包括Java
 *      applications , applets和servlet）都能通过SQL语句或存储在数据库中的过程（stored
 *      procedures）来存取数据库。 要通过JDBC来存取某一特定的数据库，必须有相应的JDBC
 *      driver，它往往是由生产数据库的厂家提供，是连接JDBC API与具体数据库之间的桥梁。 通常，Java程序首先使用JDBC
 *      API来与JDBC Driver Manager交互，由JDBC Driver Manager载入指定的JDBC drivers,
 *      以后就可以通过JDBC API来存取数据库。 JDBC driver 是用于特定数据库的一套实施了JDBC接口的类集。
 *      "JDBC-ODBC bridge driver"这种类型的driver能使客户端通过JDBC调用连接到一个使用ODBC
 *      driver的数据库。使用这类driver需要每个客户端机器都装上数据库对应的ODBC driver，但该ODBC
 *      driver不一定要跟Java兼容。
 *      </p>
 * 
 * <br>
 *      (Access中将用到的数据库名称为db,表为tUser）</br>
 *      <p>
 *      1. 首先使用Java自带的Class类中的forName静态方法加载驱动程序. <br>
 *      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); <br>
 *      2. 然后就是连接数据库了,这里要用到java.sql包中的Connection类声明一个对象，
 *      再用类DriverManager调用它的静态方法getConnection创建这个连接。 <br>
 * 
 *      Connection
 *      con=DriverManager.getConnection("jdbc:odbc:数据源名字","数据源用户名","数据源密码");
 * 
 *      <br>
 *      例如： String sourceDB="jdbc:odbc:MyDataBase"; <br>
 *      Connection con=DriverManager.getConnection(sourceDB,"db2010","pass");
 * 
 *      <br>
 *      注释： 三个字符串分别为:sourceDB,"db2010","pass",如果没有密码就为: "" <br>
 * 
 *      3. 创建Statement对象，利用Statement对象来传送SQL命令给数据库执行SQL命令。 此时就要用到 Statement接口类中的
 *      executeQuery 或 executeUpdate 的方法, executeQuery
 *      方法需要一个字符串参数，Statement会将这个字符串返回数据库，数据库就会执行这个字符串所代表的SQL命令并将返回结果, 最后将操作结果以
 *      ResultSet 对象返回程序.
 *      </p>
 * 
 * @类名称: Access
 * @作者： 宋延军
 * @邮箱： songyanjun_stars@126.com
 * @日期： Feb 27, 2012 9:19:09 AM
 */
public class LinkAccess {

	/**
	 * @描述: TODO java连接Access数据库 测试入口
	 * 
	 * @标题: main
	 * @设定:
	 * @param args
	 * @返回类型: void
	 */
	public static void main(String[] args) {

		Connection con;

		Statement sql;

		ResultSet rs;

		try {
			// 加载Access数据库驱动程序
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}

		catch (ClassNotFoundException e) {
			System.out.println("" + e);// 控制台打印异常
		}

		try {
			// DriverManager.getConnection("指定连接数据源","数据库名称","数据库密码"); 如果没有密码则空
			// DriverManager.getConnection("指定连接数据源","数据库名称","")
			con = DriverManager.getConnection("jdbc:odbc:MyDataBase",
					"db20101.mdb", "pass");

			sql = con.createStatement();

			rs = sql.executeQuery("Select * FROM tUser");

			while (rs.next()) {
				String ID = rs.getString(1); // 获得数据库第一列

				String Uid = rs.getString(2);

				System.out.println("主键ID: " + ID); // 输出信息

				System.out.println("用户ID: " + Uid);
			}
			con.close();// 关闭连接

		} catch (SQLException e) {
			System.out.println("" + e);// 控制台打印异常
		}

	}

}
