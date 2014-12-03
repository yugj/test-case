package test.javabasic;

public class UseNull {
	
	String str = null;
	
	public void useNull() {
		try {
			str.length();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new UseNull().useNull();
	}

}
