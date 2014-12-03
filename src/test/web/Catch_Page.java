package test.web;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Catch_Page {

	public static void main(String args[]) {
		new Catch_Page().html("http61-", 400, "");
	}

	public void html(String partOfUrl, int totalPage, String key) {

		DataInputStream dis = null;
		BufferedReader in = null;
		try {
			for (int i = 1; i <= totalPage; i++) {
				boolean flag = false;
				String U = partOfUrl + i + ".html";
				URL newUrl = new URL(U);
				URLConnection connect = newUrl.openConnection();
				connect
						.setRequestProperty("User-Agent",
								"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
				dis = new DataInputStream(connect.getInputStream());
				in = new BufferedReader(new InputStreamReader(dis, "GBK"));
				String readLine = null;

				while ((readLine = in.readLine()) != null) {
					String temp = readLine;
					
					//isUrl(temp);
					if (temp.indexOf(key) >= 0) {
						flag = true;
						System.out.println("’“µΩ:" + key
								+ "--------------------- : " + i);
						break;
					}
				}

				if (flag == false) {
					System.out.println(key + "---page " + i + " not fund");
				}
			}
		} catch (MalformedURLException me) {
			System.out.println("MalformedURLException" + me);
		} catch (IOException ioe) {
			System.out.println("ioeException" + ioe);
		} finally {
			try {
				if (dis != null) {
					dis.close();
					dis = null;

				}
				if (in != null) {
					in.close();
					in = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
