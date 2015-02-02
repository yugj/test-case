package test.javabasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class TestList {
	public static void main(String[] args) {
		List<String> arrayList = new ArrayList<String>();
		List<String> linkedList = new LinkedList<String>();
		Vector<String> vector = new Vector<String>();
		StringBuffer sb = new StringBuffer();
		Map<String, String> hashMap = new HashMap<String, String>();
		Map<String, String> hashTable = new Hashtable<String, String>();
		hashMap.put("key", "value");
		int hashCode = hashMap.hashCode();
		System.out.println(hashCode);
		System.out.println(Float.MAX_VALUE);
	}
}
