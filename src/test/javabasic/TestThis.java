package test.javabasic;

public class TestThis {

	public static void main(String[] args) {
		A a1 = new A("a1");
		a1.f2();

	}
}

class A {
	String name;
	A(String str) {
		name = str;
	}
	
	public void f1() {
		System.out.println("f1() of name:" + name);
		
	}
	
	public void f2() {
		A a2 = new A("a2");
		this.f1();
		a2.f1();
		System.out.println(a2.name);
	}
}