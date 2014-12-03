package test.web;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestEmailTrans {

	/**
	 * @param args add by zxx ,Feb 5, 2009
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		
		Message msg = new MimeMessage(session);
		msg.setText("ÄãºÃÂð£¿");
		msg.setFrom(new InternetAddress("lili@sohu.com"));
	
		Transport transport = session.getTransport();
		transport.connect("smtp.sina.com", 25, "ygj1023", "ygjs@2283798");
		transport.sendMessage(msg,
				new Address[]{new InternetAddress("guijunyu@gmail.com")});

		//transport.send(msg,new Address[]{new InternetAddress("itcast_test@sohu.com")});
		transport.close();
	}

}
