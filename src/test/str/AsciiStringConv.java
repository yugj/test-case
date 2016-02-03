package test.str;

import java.io.UnsupportedEncodingException;


/**
 * ascii
 */
public class AsciiStringConv {
	public static void main(String[] args) throws UnsupportedEncodingException {
		t1();// ASCIIת��Ϊ�ַ���

		t2();// �ַ���ת��ΪASCII��

	}

	public static void t1() {// ASCIIת��Ϊ�ַ���

		String s = "129";// ASCII��

		String[] chars = s.split(" ");
		System.out.println("ASCII ���� \n----------------------");
		for (int i = 0; i < chars.length; i++) {
			System.out.println(chars[i] + " "
					+ (char) Integer.parseInt(chars[i]));
		}
	}

	public static void t2() {// �ַ���ת��ΪASCII��

		String s = "1";// �ַ���

		char[] chars = s.toCharArray(); // ���ַ���ת��Ϊ�ַ�����

		System.out.println("\n\n���� ASCII\n----------------------");
		for (int i = 0; i < chars.length; i++) {// ������

			System.out.println(" " + chars[i] + " " + (int) chars[i]);
		}
	}
}