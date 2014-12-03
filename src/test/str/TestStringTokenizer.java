package test.str;

import java.util.StringTokenizer;

public class TestStringTokenizer {
	
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(" hello world ");
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
	

}
