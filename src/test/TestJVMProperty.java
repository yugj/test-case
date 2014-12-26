package test;

public class TestJVMProperty {
	public static void main(String[] args) {
		
		
		long a = Runtime.getRuntime().maxMemory();  //最大可用内存，对应-Xmx

		long b = Runtime.getRuntime().freeMemory();  //当前JVM空闲内存

		long c = Runtime.getRuntime().totalMemory();
		String arch = System.getProperty("sun.arch.data.model");
	    System.out.println(arch);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(b + c);
		
		System.out.println("+++++++++++++++");
		System.out.println(System.getProperty("user.home"));
		  System.out.println(System.getProperty("java.version"));
		  System.out.println(System.getProperty("os.name"));
		  System.out.println(System.getProperty("java.vendor.url"));
	}
}
