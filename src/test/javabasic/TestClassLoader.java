package test.javabasic;

public class TestClassLoader {
	public static void main(String[] args) {
		//bootstrap class loader ..
		System.out.println(String.class.getClassLoader());
		System.out.println(com.sun.crypto.provider.AESCipher.class.getClassLoader().getClass().getName());
		System.out.println(test.javabasic.TestClassLoader.class.getClassLoader().getClass().getName());
		
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
		
	}
}
