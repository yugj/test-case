package test;

import java.util.HashSet;

public class TestHashSet {
	
	public static void main(String[] args) {
		HashSet<String> strs = new HashSet<String>();
		String str = null;
		for(int i=0; i<10; i++) {
			str = "hello" + i;
			strs.add(str);
		}
		
		
		strs.remove(str);
		for(String ss: strs) {
			System.out.println(ss);
		}
	}

}
