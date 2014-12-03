package test.web;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CatchHtml2 {

	public static void main(String args[]) {
		new CatchHtml2().html();

	}

	public String html() {
		DataInputStream dis = null;
		BufferedReader in = null;
		try {
			URL newUrl = new URL("http://www.sina.com");
			URLConnection connect = newUrl.openConnection();
			connect.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			dis = new DataInputStream(connect.getInputStream());
			in = new BufferedReader(new InputStreamReader(dis, "UTF-8"));
			String html = "";
			String readLine = null;
			while ((readLine = in.readLine()) != null) {
				// html = html + readLine;
				System.out.println(readLine);
			}

			return html;
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
				if(in != null) {
					in.close();
					in = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
