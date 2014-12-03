package test.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEMail_Group {
	public static void main(String[] args) {
		new SendEMail_Group().send();
	}

	public void send() {
		Connection conn = null;
		ResultSet rs = null;
		Statement stat = null;
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		Message message = new MimeMessage(session);
		Transport transport = null;
		try {
			message.setText("吃夜宵_test");
			message.setSubject("java邮件测试");
			message.setFrom(new InternetAddress("1411099383@qq.com"));
			

			transport = session.getTransport();
			transport.connect("smtp.qq.com", 25, "1411099383", "ygjq1@2283798");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/email",
					"root", "ygj");
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from email");
			InternetAddress[] iaddress = new InternetAddress[100];
			
			InternetAddress a = new InternetAddress("1411099383@qq.com");
			InternetAddress b = new InternetAddress("1712071139@qq.com");
			InternetAddress[] test = {a, b};
			//记得改用Address数组 && qqmail测试邮件发送
			int i = 0;
			while(rs.next()) {
				message.setRecipient(RecipientType.TO, new InternetAddress(rs.getString("email")));
				//iaddress[i] = new InternetAddress(rs.getString("email"));
				//i++;
			}
			for(int j=0; j<1000; j++) {
				//Thread.sleep(5000);
				transport.sendMessage(message,message.getAllRecipients());

			}
			Address[] address = iaddress;
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 finally {

			try {
				if (transport != null) {
					transport.close();
					transport = null;
				}
				
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
