package test.javabasic;

public class TestOveride extends SuperClass{
	
	public void test() {
		System.out.println("this");
		
	}
	
	public static void main(String[] args) {
		SuperClass sc  = new TestOveride();
		sc.test();
	}

}

class SuperClass {
	public void test() {
		System.out.println("super");
	}
	
}
