package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpPostUtil { 
    
   
    
    public static void httpPost(String urlAddress,String []params) throws Exception{ 
    		URL url = new URL("http://162.168.0.2/query.jsp");
    		URLConnection connection = url.openConnection();
    		connection.setDoOutput(true);
    		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "8859_1");
    		out.write("username=test&password=test");//这里组织域信息
    		out.flush();
    		out.close();
    		InputStream in=connection.getInputStream();
    }
} 
