package test.web;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.InputStream;

public class CatchHtml {
	public StringBuffer getContent(URL url) {
		StringBuffer contentBuffer = new StringBuffer();
		int responseCode = -1;
		HttpURLConnection con = null;
		InputStream inStr = null;
		try {
			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");// IE�����������?
			con.setConnectTimeout(60000);
			con.setReadTimeout(60000);

			// �����ҳ������Ϣ��?

			responseCode = con.getResponseCode();

			if (responseCode == -1) {
				System.out.println(url.toString()
						+ " : connection is failure...");
				con.disconnect();
				return null;
			}

			System.out.println(url.toString() + " #get response code: "
					+ responseCode);

			if (responseCode >= 400) // ����ʧ��
			{
				System.out.println("����ʧ��:get response code: " + responseCode);
				con.disconnect();
				return null;
			}

			 inStr = con.getInputStream();
			InputStreamReader istreamReader = new InputStreamReader(inStr);
			BufferedReader buffStr = new BufferedReader(istreamReader);

			String str = null;
			while ((str = buffStr.readLine()) != null) {
				contentBuffer.append(str);
				System.out.println(str);
				inStr.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			contentBuffer = null;
			System.out.println("error: " + url.toString());
		} finally {
			con.disconnect();
			if(inStr != null) {
				try {
					inStr.close();
					inStr = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		return contentBuffer;

	}

	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("http://www.sina.com");
			new CatchHtml().getContent(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
