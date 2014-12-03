package test.javabasic;

public class Scanner {
	public static void main(String[] args) {
		while (true) {
			java.util.Scanner scan = new java.util.Scanner(System.in);
			String str = scan.nextLine();
			System.out.println(str);
		}
	}

}
