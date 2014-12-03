package test.io.property;

import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	public static void main(String[] args) throws Exception{
		
		InputStream is2 =  ReadProperties.class.getClassLoader().getClass().
		getResourceAsStream("/test/io/property/test.properties");
		System.out.println(is2);
		
		Properties prop = new Properties();
		
		prop.load(is2);
		String name = prop.getProperty("username");
		String pass = prop.getProperty("password");
		
		System.out.println(name);
		System.out.println(pass);
		
		
	}

}
