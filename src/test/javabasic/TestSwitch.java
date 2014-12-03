package test.javabasic;

public class TestSwitch {
	public static void main(String[] args) {
		
		Ca c = Ca.a;
		switch (c) {//Only convertible int values or enum variables are permitted
		case a:
			System.out.println("a");
			break;
		case b:
			System.out.println("b");
			break;
		default:System.out.println("error");

		}

	}
}


