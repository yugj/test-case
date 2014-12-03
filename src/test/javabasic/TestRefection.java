package test.javabasic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRefection {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String str = "test.javabasic.T";
		Class c = Class.forName(str);
		Object obj = c.newInstance();
		
		for(Method m: c.getMethods()) {
			System.out.println(m.getName());
			if(m.getName().equals("m")) {
				m.invoke(obj, null);
			}
		}
	}

}

class T {
	 public void m() {
		System.out.println("m invoke");
	}
}