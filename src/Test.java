
public class Test {
	public static void main(String[] args) {
		String wstest = " wstest";
        byte[] rs = wstest.getBytes();

        for (byte b : rs) {
            System.out.println(b + " " + (char)b);
        }
	}
}
