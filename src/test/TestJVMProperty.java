package test;

public class TestJVMProperty {
	public static void main(String[] args) {
		
		
		long a = Runtime.getRuntime().maxMemory();  //�������ڴ棬��Ӧ-Xmx

		long b = Runtime.getRuntime().freeMemory();  //��ǰJVM�����ڴ�

		long c = Runtime.getRuntime().totalMemory();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		System.out.println(b + c);
	}
}
