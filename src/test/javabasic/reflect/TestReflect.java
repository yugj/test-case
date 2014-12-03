package test.javabasic.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestReflect {
	public static void main(String[] args) throws Exception{
		
		InputStream is2 = new FileInputStream(System.getProperty("user.dir") +
				"/src/test/javabasic/reflect/testReflect.properties");
		
		Properties prop = new Properties();
		prop.load(is2);
		
		String className = prop.getProperty("class");
		
		Class c = Class.forName(className);
		
		T t = (T)c.newInstance();
		
		Method tm = c.getMethod("getS", null);
		tm.invoke(t);
	}

}


class T {
	int i;
	String s = "hello";
	
	public String getS() {
		System.out.println(s);
		return s;
	}
}