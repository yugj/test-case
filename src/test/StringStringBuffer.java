package test;

import util.Print;

public class StringStringBuffer {
	public static void main(String[] args) {
		String str = "123456";
		Print.println(str.substring(0,2));
		
		String a = new String("s");
		String b = new String("s");
		String c = "s";
		String d = "s";
		String e = new String("s" + " ");
		String f = new String("s" + " ");
		StringBuffer g = new StringBuffer("s");
		StringBuffer h = new StringBuffer("s");
		Print.println(a == b);
		Print.println(a.equals(b));
		Print.println(c == d);
		Print.println(c.equals(d));
		Print.println(e == f);
		
		int[] i = new int[3];
		int[] j = i.clone();
		System.out.println(i == j);
		Print.println(i.hashCode() == j.hashCode());
		Print.println(new int[3].hashCode() == i.clone().hashCode());
		Print.println(new int[3].hashCode() == new int[3].hashCode());
		Print.println(new Te().hashCode() == new Te().hashCode());
		Te ta = new Te();
		Te tb = ta;
		Print.println(ta.hashCode() == tb.hashCode());
		int k = 2;
		int l = 2;
		int m = k;
		
	}
}

class Te {
	
}

