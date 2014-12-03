package test;


public class ConstructorExtends {
	public static void main(String args[]) {
		new Father();
		new Father("Hello Father");
		new Son();
		new Son("hello son");
		new Son("hello son", "hello father");
	}
}

class Father {
	String s = "Run constructor method of Father";

	public Father() {
		System.out.println(s);
	}

	public Father(String str) {
		s = str;
		System.out.println(s);
	}
}

class Son extends Father {
	String s = "Run constructor method of son";

	public Son() {
		// 实际上在这里加上super()，和没加是一个样的
		System.out.println(s);
	}

	public Son(String str) {
		this();// 这里调用this()表示调用本类的Son(),因为Son()中有了一个super()了，所以这里不能再加了。
		s = str;
		System.out.println(s);
	}

	public Son(String str1, String str2) {
		super(str1 + " " + str2);// 因为这里已经调用了一个父类的带参数的super("---")了，所以不会再自动调用了无参数的了。
		s = str1;
		System.out.println(s);
	}
}
