package test;

public class TestJVMProperty {
	public static void main(String[] args) {
		
		
		long a = Runtime.getRuntime().maxMemory();  //最大可用内存，对应-Xmx

		long b = Runtime.getRuntime().freeMemory();  //当前JVM空闲内存

		long c = Runtime.getRuntime().totalMemory();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		System.out.println(b + c);
	}
}
