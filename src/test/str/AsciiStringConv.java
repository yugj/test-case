package test.str;

import java.io.UnsupportedEncodingException;


/**
 * ascii
 */
public class AsciiStringConv {
	public static void main(String[] args) throws UnsupportedEncodingException {
		t1();// ASCII×ª»»Îª×Ö·û´®

		t2();// ×Ö·û´®×ª»»ÎªASCIIÂë

	}

	public static void t1() {// ASCII×ª»»Îª×Ö·û´®

		String s = "129";// ASCIIÂë

		String[] chars = s.split(" ");
		System.out.println("ASCII ºº×Ö \n----------------------");
		for (int i = 0; i < chars.length; i++) {
			System.out.println(chars[i] + " "
					+ (char) Integer.parseInt(chars[i]));
		}
	}

	public static void t2() {// ×Ö·û´®×ª»»ÎªASCIIÂë

		String s = "1";// ×Ö·û´®

		char[] chars = s.toCharArray(); // °Ñ×Ö·ûÖÐ×ª»»Îª×Ö·ûÊý×é

		System.out.println("\n\nºº×Ö ASCII\n----------------------");
		for (int i = 0; i < chars.length; i++) {// Êä³ö½á¹û

			System.out.println(" " + chars[i] + " " + (int) chars[i]);
		}
	}
}