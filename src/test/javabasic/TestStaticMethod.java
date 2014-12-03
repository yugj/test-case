package test.javabasic;

public class TestStaticMethod {
	public static void main(String[] args) {
		Parent parent = new Parent();
		Parent child = new Child();
		System.out.println(parent.getName());
		System.out.println(child.getName());
	}
}

class Parent {
	public static String getName() {
		return "parent";
	}
}

class Child extends Parent {
	public static String getName() {
		return "child";
	}
}
