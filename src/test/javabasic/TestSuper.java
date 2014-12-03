package test.javabasic;

public class TestSuper extends Super{
	
	String testSuper = "testSuper";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestSuper().f2();

	}
	
	public void f2() {
		super.f();
	
	}

}

class Super{
	public void f() {
		System.out.println("************");
	}
	
}