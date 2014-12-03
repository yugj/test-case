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

import util.Print;

public class OpenURL {

	public static void main(String args[]) {
		new OpenURL().html("http:m-61-", 5);
	}

	public void html(String partOfUrl, int page) {

		DataInputStream dis = null;
		BufferedReader in = null;
		try {
			
				Set<String > pageurls = new HashSet<String>();
				boolean flag = false;
				String U = partOfUrl + page + ".html";
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
					findUrl(temp,pageurls);
				}
				
				openUrl(pageurls);
				
				
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

	
	private static void findUrl(String line,Set<String> pageurls) {
		String base = "http:/.com/";
		Pattern p = Pattern.compile("thread-(.+?)html"); 
		Matcher m = p.matcher(line);
		while(m.find()) {
			String tempurl = base + m.group().toString();
			System.out.println(tempurl);
			if(!pageurls.contains(tempurl)) {
				pageurls.add(tempurl);
			}
		}
		
	}
	
	private static void openUrl(Set<String> urls) {
		for(String url : urls) {
			System.out.println(url);
			try {
				Runtime.getRuntime().exec("rundll32  url.dll,FileProtocolHandler " + url);
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
