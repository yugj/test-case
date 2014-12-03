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
		// ʵ�������������super()����û����һ������
		System.out.println(s);
	}

	public Son(String str) {
		this();// �������this()��ʾ���ñ����Son(),��ΪSon()������һ��super()�ˣ��������ﲻ���ټ��ˡ�
		s = str;
		System.out.println(s);
	}

	public Son(String str1, String str2) {
		super(str1 + " " + str2);// ��Ϊ�����Ѿ�������һ������Ĵ�������super("---")�ˣ����Բ������Զ��������޲������ˡ�
		s = str1;
		System.out.println(s);
	}
}
