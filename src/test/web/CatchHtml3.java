package test.web;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CatchHtml3 {
	public String getOneHtml(String htmlurl) {
		URL url;
		String temp;
		BufferedReader in = null;
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(htmlurl);
			in = new BufferedReader(new InputStreamReader(url.openStream(),
					"utf-8"));// ��ȡ��ҳȫ������
			while ((temp = in.readLine()) != null) {
				sb.append(temp);
				System.out.println(temp);
			}
			
		} catch (MalformedURLException me) {
			System.out.println("�������URL��ʽ�����⣡����ϸ����");
			me.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
					in = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return sb.toString();
	}
	
	public static void main(String args[]) {
		CatchHtml3 ch = new CatchHtml3();
		String s = ch.getOneHtml("http://bbs.csdn.net/topics/360142201");
		//System.out.println(s);
		
	}
	
}