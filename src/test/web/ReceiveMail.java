package test.web;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.*;

/*
 Title: 使用JavaMail接收邮件
 Description: 实例JavaMail包接收邮件，本实例没有实现接收邮件的附件。
 Copyright: Copyright (c) 2003
 Filename: POPMail.java
 @version 1.0
 */
public class ReceiveMail {
	/*
	 * 方法说明：主方法，接收用户输入的邮箱服务器、用户名和密码 输入参数： 返回类型：
	 */
	public static void main(String args[]) {
		try {
			String popServer = "pop3.sina.com"; // 邮件服务器
			String popUser = "ygj1023"; // 根据自已的用户名修改
			String popPassword = "ygj123456"; // 根据自已的密码修改
			receive(popServer, popUser, popPassword);
		} catch (Exception ex) {
			System.out.println("Usage: java com.lotontech.mail.POPMail"
					+ " popServer popUser popPassword");
		}
		System.exit(0);
	}

	/*
	 * 方法说明：接收邮件信息 输入参数： 返回类型：
	 */
	public static void receive(String popServer, String popUser,
			String popPassword) {
		Store store = null;
		Folder folder = null;
		try {
			// 获取默认会话
			Properties props = System.getProperties();
			Session session = Session.getDefaultInstance(props, null);
			// 使用POP3会话机制，连接服务器
			store = session.getStore("pop3");
			store.connect(popServer, popUser, popPassword);
			// 获取默认文件夹
			folder = store.getDefaultFolder();
			if (folder == null)
				throw new Exception("No default folder");
			// 如果是收件箱
			folder = folder.getFolder("INBOX");
			if (folder == null)
				throw new Exception("No POP3 INBOX");
			// 使用只读方式打开收件箱
			folder.open(Folder.READ_ONLY);
			// 得到文件夹信息，获取邮件列表
			Message[] msgs = folder.getMessages();
			for (int msgNum = 0; msgNum < msgs.length; msgNum++) {
				printMessage(msgs[msgNum]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 释放资源
			try {
				if (folder != null)
					folder.close(false);
				if (store != null)
					store.close();
			} catch (Exception ex2) {
				ex2.printStackTrace();
			}
		}
	}

	/*
	 * 方法说明：打印邮件信息 输入参数：Message message 信息对象 返回类型：
	 */
	public static void printMessage(Message message) {
		try {
			// 获得发送邮件地址
			String from = ((InternetAddress) message.getFrom()[0])
					.getPersonal();
			if (from == null)
				from = ((InternetAddress) message.getFrom()[0]).getAddress();
			System.out.println("FROM: " + from);
			// 获取主题
			String subject = message.getSubject();
			System.out.println("SUBJECT: " + subject);
			// 获取信息对象
			Part messagePart = message;
			Object content = messagePart.getContent();
			// 附件
			if (content instanceof Multipart) {
				messagePart = ((Multipart) content).getBodyPart(0);
				System.out.println("[ Multipart Message ]");
			}
			// 获取content类型
			String contentType = messagePart.getContentType();
			// 如果邮件内容是纯文本或者是HTML，那么打印出信息
			System.out.println("CONTENT:" + contentType);
			if (contentType.startsWith("text/plain")
					|| contentType.startsWith("text/html")) {
				InputStream is = messagePart.getInputStream();
				BufferedWriter bw = null;
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is));
				String thisLine = reader.readLine();
				int i = 0;
				bw = new BufferedWriter(new FileWriter(
						"G:\\tem\\" + Integer.valueOf(i) +".html"));
				while (thisLine != null) {
					if(thisLine.indexOf("<html>") >= 0) {
						i ++;
						bw = new BufferedWriter(new FileWriter(
						"G:\\tem\\" + Integer.valueOf(i) +".html"));
						bw.write(thisLine);
						bw.newLine();
						System.out.println(thisLine);
						thisLine = reader.readLine();
					} else {
						bw.write(thisLine);
						System.out.println(thisLine);
						thisLine = reader.readLine();
					}
					
				}
			}
			System.out.println("-------------- END ---------------");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}