package test.web;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.*;

/*
 Title: ʹ��JavaMail�����ʼ�
 Description: ʵ��JavaMail�������ʼ�����ʵ��û��ʵ�ֽ����ʼ��ĸ�����
 Copyright: Copyright (c) 2003
 Filename: POPMail.java
 @version 1.0
 */
public class ReceiveMail {
	/*
	 * ����˵�����������������û������������������û��������� ��������� �������ͣ�
	 */
	public static void main(String args[]) {
		try {
			String popServer = "pop3.sina.com"; // �ʼ�������
			String popUser = "ygj1023"; // �������ѵ��û����޸�
			String popPassword = "ygj123456"; // �������ѵ������޸�
			receive(popServer, popUser, popPassword);
		} catch (Exception ex) {
			System.out.println("Usage: java com.lotontech.mail.POPMail"
					+ " popServer popUser popPassword");
		}
		System.exit(0);
	}

	/*
	 * ����˵���������ʼ���Ϣ ��������� �������ͣ�
	 */
	public static void receive(String popServer, String popUser,
			String popPassword) {
		Store store = null;
		Folder folder = null;
		try {
			// ��ȡĬ�ϻỰ
			Properties props = System.getProperties();
			Session session = Session.getDefaultInstance(props, null);
			// ʹ��POP3�Ự���ƣ����ӷ�����
			store = session.getStore("pop3");
			store.connect(popServer, popUser, popPassword);
			// ��ȡĬ���ļ���
			folder = store.getDefaultFolder();
			if (folder == null)
				throw new Exception("No default folder");
			// ������ռ���
			folder = folder.getFolder("INBOX");
			if (folder == null)
				throw new Exception("No POP3 INBOX");
			// ʹ��ֻ����ʽ���ռ���
			folder.open(Folder.READ_ONLY);
			// �õ��ļ�����Ϣ����ȡ�ʼ��б�
			Message[] msgs = folder.getMessages();
			for (int msgNum = 0; msgNum < msgs.length; msgNum++) {
				printMessage(msgs[msgNum]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// �ͷ���Դ
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
	 * ����˵������ӡ�ʼ���Ϣ ���������Message message ��Ϣ���� �������ͣ�
	 */
	public static void printMessage(Message message) {
		try {
			// ��÷����ʼ���ַ
			String from = ((InternetAddress) message.getFrom()[0])
					.getPersonal();
			if (from == null)
				from = ((InternetAddress) message.getFrom()[0]).getAddress();
			System.out.println("FROM: " + from);
			// ��ȡ����
			String subject = message.getSubject();
			System.out.println("SUBJECT: " + subject);
			// ��ȡ��Ϣ����
			Part messagePart = message;
			Object content = messagePart.getContent();
			// ����
			if (content instanceof Multipart) {
				messagePart = ((Multipart) content).getBodyPart(0);
				System.out.println("[ Multipart Message ]");
			}
			// ��ȡcontent����
			String contentType = messagePart.getContentType();
			// ����ʼ������Ǵ��ı�������HTML����ô��ӡ����Ϣ
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